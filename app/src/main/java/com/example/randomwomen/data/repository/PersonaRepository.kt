package com.example.randomwomen.data.repository

import com.example.randomwomen.data.remote.dto.PersonaApi
import com.example.randomwomen.data.remote.dto.PersonaDto
import com.example.randomwomen.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PersonaRepository @Inject constructor(private val api: PersonaApi)
{
    fun getPersona(): Flow<Resource<List<PersonaDto>>> = flow {
        try{
            emit(Resource.Loading())

            val person = api.getPersons()

            emit(Resource.Success(person.results))
        }catch (e: HttpException){
            emit(Resource.Error(e.message ?: "Error HTTP"))

        }catch (e: IOException){
            emit(Resource.Error(e.message ?: "Verificar conexion"))
        }
    }
}