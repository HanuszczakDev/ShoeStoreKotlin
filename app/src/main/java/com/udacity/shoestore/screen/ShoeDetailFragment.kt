package com.udacity.shoestore.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    private val viewModel: ShoeViewModel by activityViewModels()

//    private val shoeObject = Shoe("a","b","c","d", R.drawable.shoe)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        binding.shoeViewModel = viewModel

        binding.shoe = Shoe("","","","", R.drawable.shoe)

//        binding.acceptButton.setOnClickListener {
//            if (!validate(shoeObject)) {
//                viewModel.addShoe(shoeObject)
//                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailDestinationToShoeListDestination())
//            } else {
//                Toast.makeText(requireContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show()
//            }
//        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailDestinationToShoeListDestination())
        }

        return binding.root
    }

    private fun validate(shoe: Shoe): Boolean {
        return shoe.name.isNotEmpty()
                && shoe.company.isNotEmpty()
                && shoe.description.isNotEmpty()
                && shoe.size.isNotEmpty()
    }

}