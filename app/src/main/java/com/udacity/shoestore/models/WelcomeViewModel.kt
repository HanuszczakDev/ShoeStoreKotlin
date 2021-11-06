package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class TextData (
    var textField: String
)

class WelcomeViewModel : ViewModel() {
    private val _text = MutableLiveData<String>()
    val text: LiveData<String>
        get() = _text

    fun convert(textData: TextData) {
        _text.value = textData.textField
    }
}