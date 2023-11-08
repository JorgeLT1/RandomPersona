package com.example.randomwomen.ui.theme.Persona


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.randomwomen.data.remote.dto.PersonaDto

@Composable
fun ConsultaPersona(persona: List<PersonaDto>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
    {
        Text(text = "Lista de Women's", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(persona) { personas ->
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Nombre: " + personas.name.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Fecha: " + personas.name.first,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(text = "Rnc: " + personas.nat, style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}