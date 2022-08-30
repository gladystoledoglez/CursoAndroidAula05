package com.example.cursoandroidaula05.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val name: String, val email: String) : Parcelable