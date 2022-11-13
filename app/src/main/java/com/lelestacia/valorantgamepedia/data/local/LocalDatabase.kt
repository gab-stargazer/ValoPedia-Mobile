package com.lelestacia.valorantgamepedia.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lelestacia.valorantgamepedia.data.model.local.agent_data.dao.AgentDao
import com.lelestacia.valorantgamepedia.data.model.local.agent_data.entities.Ability
import com.lelestacia.valorantgamepedia.data.model.local.agent_data.entities.Agent
import com.lelestacia.valorantgamepedia.data.model.local.converter.StringConverter
import com.lelestacia.valorantgamepedia.data.model.local.maps_data.dao.MapDao
import com.lelestacia.valorantgamepedia.data.model.local.maps_data.entity.Map
import com.lelestacia.valorantgamepedia.data.model.local.weapon_data.dao.WeaponDao
import com.lelestacia.valorantgamepedia.data.model.local.weapon_data.entity.DamageRange
import com.lelestacia.valorantgamepedia.data.model.local.weapon_data.entity.Weapon
import com.lelestacia.valorantgamepedia.data.model.local.weapon_data.entity.WeaponSkin
import com.lelestacia.valorantgamepedia.data.model.local.weapon_data.entity.WeaponStatistic

@Database(
    entities = [Map::class, Agent::class,
        Ability::class, Weapon::class,
        WeaponStatistic::class, WeaponSkin::class,
        DamageRange::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(value = [StringConverter::class])
abstract class LocalDatabase : RoomDatabase() {

    abstract fun mapDao(): MapDao

    abstract fun agentDao(): AgentDao

    abstract fun weaponDao(): WeaponDao
}