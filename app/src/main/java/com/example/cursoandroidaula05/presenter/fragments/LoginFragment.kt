package com.example.cursoandroidaula05.presenter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cursoandroidaula05.databinding.FragmentLoginBinding
import com.example.cursoandroidaula05.extensions.transitionTo

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnRegister.setOnClickListener {
                parentFragmentManager.transitionTo(
                    DetailsFragment.newInstance(etName.text.toString(), etEmail.text.toString()),
                    isBackStack = true
                )
            }
        }
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}
