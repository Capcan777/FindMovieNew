package com.example.findmovienew.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PosterViewModel(private val imageUrl: String) : ViewModel() {

    private val urlLiveData = MutableLiveData(imageUrl)
    fun observeUrl(): LiveData<String> = urlLiveData


}