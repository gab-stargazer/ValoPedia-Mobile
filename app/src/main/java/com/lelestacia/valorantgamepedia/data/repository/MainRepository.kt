package com.lelestacia.valorantgamepedia.data.repository

import com.lelestacia.valorantgamepedia.data.model.remote.agent_data.AgentData
import com.lelestacia.valorantgamepedia.data.model.remote.currencies_data.CurrenciesData
import com.lelestacia.valorantgamepedia.data.model.remote.weapons_data.weapons_info.WeaponsData
import com.lelestacia.valorantgamepedia.utility.FinalResponse
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getAgents() : Flow<FinalResponse<List<AgentData>>>

    fun getCurrencies() : Flow<FinalResponse<List<CurrenciesData>>>

    fun getWeapons() : Flow<FinalResponse<List<WeaponsData>>>
}