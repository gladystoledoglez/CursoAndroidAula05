package com.example.cursoandroidaula05.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.cursoandroidaula05.R

fun FragmentManager.transitionTo(fragment: Fragment, isBackStack: Boolean = true) {
    val transition = beginTransaction().replace(R.id.fcvContainer, fragment)
    if (isBackStack) {
        transition.addToBackStack(fragment.javaClass.simpleName)
    }
    transition.commit()
}