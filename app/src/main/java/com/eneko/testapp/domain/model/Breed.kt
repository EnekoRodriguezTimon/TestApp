package com.eneko.testapp.domain.model

import com.google.gson.annotations.SerializedName


data class Breed(
    @field:SerializedName("id") val id: String,
    @field:SerializedName("type") val type: String,
    @field:SerializedName("attributes")val attributes: Attributes
)

data class Attributes(
    val name: String,
    val description: String,
    val life: Life,
    val maleWeight: MaleWeight,
    val femaleWeight: FemaleWeight,
    val hypoallergenic: Boolean,
)

data class Life(
    val min: Int,
    val max: Int
)

data class MaleWeight(
    val min: Int,
    val max: Int
)

data class FemaleWeight(
    val min: Int,
    val max: Int
)