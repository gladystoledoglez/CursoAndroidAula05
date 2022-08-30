package com.example.cursoandroidaula05.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cursoandroidaula05.data.entities.User
import com.example.cursoandroidaula05.data.enums.MimeTypes
import com.example.cursoandroidaula05.databinding.ActivityDetailsBinding
import com.example.cursoandroidaula05.extensions.getStringExtraText
import com.example.cursoandroidaula05.extensions.putStringExtraText

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(Intent.EXTRA_TEXT)

        with(binding) {
            tvName.text = user?.name
            tvEmail.text = user?.email
            btnShare.setOnClickListener { shareText(user?.name) }
        }
    }

    private fun shareText(text: String?) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putStringExtraText(text)
            type = MimeTypes.TEXT_PLAIN.type
        }

        if (sendIntent.action == Intent.ACTION_SEND)
            sendIntent.getStringExtraText()

        startActivity(Intent.createChooser(sendIntent, null))
    }
}