package com.udacity.shoestore.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.models.TextData
import com.udacity.shoestore.models.WelcomeViewModel

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    val welcomeViewModel: WelcomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome,
            container,
            false
        )

        val scoreFragmentArgs by navArgs<WelcomeFragmentArgs>()

        binding.welcomeViewModel = welcomeViewModel

        binding.textData = TextData("")

        welcomeViewModel.text.observe(viewLifecycleOwner, Observer { newText ->
            binding.textView.text = newText
        })

        binding.nameTextView.text = scoreFragmentArgs.userLogin

        binding.goToInstructionButton.setOnClickListener{
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeDestinationToInstructionFragment())
        }

        return binding.root
    }

}