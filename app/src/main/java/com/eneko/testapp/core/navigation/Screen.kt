package com.eneko.testapp.core.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
object Splash

@Serializable
object Main
@Serializable
object Home
@Serializable
object Breeds

@Serializable
data class BreedsDetails(val breedName: String)

@Serializable
data class Settings(val info: SettingsInfo)

@Parcelize
@Serializable
data class  SettingsInfo(val name: String, val id: Int, val darkMode: Boolean) : Parcelable

@Serializable
object Screen1

@Serializable
object Screen2

@Serializable
object Screen3

@Serializable
object TimeScreen