package com.example.cursoandroidaula05

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cursoandroidaula05.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(User.EXTRA_USER)

        with(binding) {
            tvName.text = user?.name
            tvEmail.text = user?.email

            btnShare.setOnClickListener {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, user?.name)
                    type = "text/plain"
                }
                if (sendIntent.action == Intent.ACTION_SEND)
                    sendIntent.getStringExtra(Intent.EXTRA_TEXT)

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }

        }
    }
}