package com.example.cursoandroidaula05.presenter.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cursoandroidaula05.data.entities.User
import com.example.cursoandroidaula05.data.enums.MimeTypes
import com.example.cursoandroidaula05.databinding.FragmentDetailsBinding
import com.example.cursoandroidaula05.extensions.getStringExtraText
import com.example.cursoandroidaula05.extensions.putStringExtraText
import com.example.cursoandroidaula05.ui.MainActivity

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        (activity as? MainActivity?)?.showToolBar()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = arguments?.getParcelable<User>(Intent.EXTRA_TEXT)

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

    companion object {
        fun newInstance(eName: String, eEmail: String) = DetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(Intent.EXTRA_TEXT, User(eName, eEmail))
            }
        }
    }
}