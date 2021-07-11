package android.example.testappyarus.presentation.common

import android.example.testappyarus.R
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.RickMortyGreenTheme)
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        val navigation = findViewById<View>(R.id.bottom_navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.characters -> {
                    navController.navigate(R.id.characterListFragment)
                    true
                }
                R.id.locations -> {
                    navController.navigate(R.id.locationListFragment)
                    true
                }
                R.id.episodes -> {
                    navController.navigate(R.id.episodesListFragment)
                    true
                }
                else -> false
            }
        }
    }
}
