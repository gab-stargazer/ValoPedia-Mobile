package com.lelestacia.valorantgamepedia.data.api

import com.lelestacia.valorantgamepedia.data.model.remote.GenericResponse
import com.lelestacia.valorantgamepedia.data.model.remote.agent_data.AgentData
import com.lelestacia.valorantgamepedia.data.model.remote.currencies_data.CurrenciesData
import com.lelestacia.valorantgamepedia.data.model.remote.maps_data.MapsData
import com.lelestacia.valorantgamepedia.data.model.remote.weapons_data.WeaponsData
import retrofit2.http.GET

interface ValorantApi {

    @GET("agents")
    suspend fun getAgents(): GenericResponse<AgentData>

    @GET("currencies")
    suspend fun getCurrencies(): GenericResponse<CurrenciesData>

    @GET("weapons")
    suspend fun getWeapons(): GenericResponse<WeaponsData>

    @GET("maps")
    suspend fun getMaps(): GenericResponse<MapsData>
}