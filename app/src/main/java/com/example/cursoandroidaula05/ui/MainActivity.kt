package com.example.cursoandroidaula05.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cursoandroidaula05.databinding.ActivityMainBinding
import com.example.cursoandroidaula05.extensions.*
import com.example.cursoandroidaula05.presenter.fragments.LoginFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager.transitionTo(LoginFragment.newInstance(), isBackStack = false)
        setContentView(binding.root)

        onReceivedAction()
    }

    private fun onReceivedAction() {
        if (intent.isActionSend()) {
            binding.tvSharedText.text = when {
                intent.isTextPlain() -> intent.getStringExtraText()
                else -> String.EMPTY
            }
        }
    }
}