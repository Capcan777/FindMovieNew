package com.example.findmovienew.ui.root

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.findmovienew.R
import com.example.findmovienew.databinding.ActivityRootBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class RootActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRootBinding
    lateinit var confirmDialog: MaterialAlertDialogBuilder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Привязываем вёрстку к экрану
        binding = ActivityRootBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.rootFragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.detailsFragment, R.id.moviesCastFragment -> {
                    animateBottonNavigateView()
                }

                else -> {
                    binding.bottomNavigationView.visibility = View.VISIBLE
                }
            }
        }
    }

    fun animateBottonNavigateView() {
        binding.bottomNavigationView.visibility = View.GONE
    }

//        if (savedInstanceState == null) {
//            navigator.openFragment(MoviesFragment())
//        }
}
//
//    override fun onResume() {
//        super.onResume()
//        navigatorHolder.attachNavigator(navigator)
//    }
//
//    override fun onPause() {
//        super.onPause()
//        navigatorHolder.detachNavigator()
//    }

