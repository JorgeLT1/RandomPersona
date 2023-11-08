package com.example.randomwomen.ui.theme.Persona

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomwomen.data.remote.dto.PersonaDto
import com.example.randomwomen.data.repository.PersonaRepository
import com.example.randomwomen.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class PersonListState(
    val isLoading: Boolean = false,
    val persona: List<PersonaDto> = emptyList(),
    val error: String = "",
)


@HiltViewModel
class PersonaViewModel @Inject constructor(
    private val personRepository: PersonaRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(PersonListState())
    val uiState: StateFlow<PersonListState> = _uiState.asStateFlow()

    init {
        personRepository.getPersona().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _uiState.update { it.copy(isLoading = true) }
                }

                is Resource.Success -> {
                    _uiState.update { it.copy(persona = result.data ?: emptyList()) }
                }

                is Resource.Error -> {
                    _uiState.update { it.copy(error = result.message ?: "Error desconocido") }
                }
            }
        }.launchIn(viewModelScope)
    }

}