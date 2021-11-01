package com.udacity.shoestore.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        binding.loginButton.setOnClickListener(this)

        binding.createAccountButton.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(v: View?) {
        if (binding.editTextTextPersonName.text.isNotEmpty() && binding.editTextTextPassword.text.isNotEmpty()) {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginDestinationToWelcomeDestination(
                    binding.editTextTextPersonName.text.toString()
                )
            )
        } else if (binding.editTextTextPersonName.text.isEmpty()) {
            binding.editTextTextPersonName.error = "invalid login"
        } else {
            binding.editTextTextPassword.error = "empty password"
        }
    }

}