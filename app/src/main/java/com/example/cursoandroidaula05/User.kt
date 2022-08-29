package com.example.cursoandroidaula05

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val name: String, val email: String) : Parcelable{

    companion object{
        const val EXTRA_USER = "EXTRA_USER"
    }
}
