package com.example.findmovienew.presentation.poster

import android.app.Activity
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.findmovienew.R
import moxy.MvpPresenter

class PosterPresenter(private val imageUrl: String) : MvpPresenter<PosterView>() {


    fun onCreate() {
        viewState.setupPosterImage(imageUrl)
    }



}