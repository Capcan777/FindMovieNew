package com.example.findmovienew.ui.poster

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.findmovienew.util.Creator
import com.example.findmovienew.R
import com.example.findmovienew.presentation.poster.PosterPresenter
import com.example.findmovienew.presentation.poster.PosterView
import moxy.presenter.InjectPresenter

class PosterActivity : AppCompatActivity(), PosterView {

    private lateinit var poster: ImageView

    @InjectPresenter
    private lateinit var providePosterPresenter: PosterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val url = intent.extras?.getString("poster", "") ?: ""
        providePosterPresenter = Creator.providePosterPresenter(this, url)

        setContentView(R.layout.activity_poster)
        poster = findViewById(R.id.poster)

        providePosterPresenter.onCreate()
    }

    override fun setupPosterImage(url: String) {
        Glide.with(applicationContext)
            .load(url)
            .into(poster)


    }
}