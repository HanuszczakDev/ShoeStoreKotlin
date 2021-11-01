package com.udacity.shoestore.models

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import timber.log.Timber

class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _showMessage = MutableLiveData<Boolean>()
    val showMessage: LiveData<Boolean>
        get() = _showMessage

    init {
        val list = mutableListOf(
            Shoe("shoe1","35.0","company1", "description1", R.drawable.shoe),
            Shoe("shoe2","30.0","company2", "description2", R.drawable.shoe)
        )
        _shoeList.value = list
        Timber.i("ShoeListViewModel initialized!")
    }

    fun addShoe(view: View, shoe: Shoe) {
        _showMessage.value = false
        if (validate(shoe)) {
            _shoeList.value?.add(shoe)
            view.findNavController().navigateUp()
        } else {
            _showMessage.value = true
        }
    }

    private fun validate(shoe: Shoe): Boolean {
        return shoe.name.isNotEmpty()
                && shoe.company.isNotEmpty()
                && shoe.description.isNotEmpty()
                && shoe.size.isNotEmpty()
    }
}