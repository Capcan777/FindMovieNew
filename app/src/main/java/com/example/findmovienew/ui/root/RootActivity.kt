package com.example.findmovienew.ui.root

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.findmovienew.R
import com.example.findmovienew.core.navigation.NavigatorHolder
import com.example.findmovienew.core.navigation.NavigatorImpl
import com.example.findmovienew.databinding.ActivityRootBinding
import com.example.findmovienew.ui.movies.MoviesFragment
import org.koin.android.ext.android.inject

class RootActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRootBinding

//    private val navigatorHolder: NavigatorHolder by inject()
//
//    private val navigator = NavigatorImpl(
//        fragmentContainerViewId = R.id.rootFragmentContainerView,
//        fragmentManager = supportFragmentManager
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Привязываем вёрстку к экрану
        binding = ActivityRootBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

}