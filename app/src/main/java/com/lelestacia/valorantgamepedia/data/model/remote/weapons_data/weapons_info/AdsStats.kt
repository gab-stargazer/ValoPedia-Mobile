package com.lelestacia.valorantgamepedia.data.model.remote.weapons_data.weapons_info


import com.google.gson.annotations.SerializedName

data class AdsStats(
    @SerializedName("burstCount")
    val burstCount: Int,
    @SerializedName("fireRate")
    val fireRate: Double,
    @SerializedName("firstBulletAccuracy")
    val firstBulletAccuracy: Double,
    @SerializedName("runSpeedMultiplier")
    val runSpeedMultiplier: Double,
    @SerializedName("zoomMultiplier")
    val zoomMultiplier: Double
)