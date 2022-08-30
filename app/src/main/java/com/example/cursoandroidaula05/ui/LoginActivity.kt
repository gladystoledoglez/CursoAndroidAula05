package com.example.cursoandroidaula05.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import com.example.cursoandroidaula05.data.entities.User
import com.example.cursoandroidaula05.databinding.ActivityLoginBinding
import com.example.cursoandroidaula05.extensions.EMPTY
import com.example.cursoandroidaula05.extensions.getStringExtraText
import com.example.cursoandroidaula05.extensions.isActionSend
import com.example.cursoandroidaula05.extensions.isTextPlain

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnRegister.setOnClickListener { sendUserData(etName.text, etEmail.text) }
        }

        onReceivedAction()
    }

    private fun sendUserData(eName: Editable, eEmail: Editable) {
        Intent(this@LoginActivity, DetailsActivity::class.java).also {
            it.putExtra(Intent.EXTRA_TEXT, User(eName.toString(), eEmail.toString()))
            startActivity(it)
        }
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