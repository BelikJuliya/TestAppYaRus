package android.example.testappyarus.presentation.common

import android.example.testappyarus.R
import android.example.testappyarus.di.AppComponent
import android.example.testappyarus.presentation.characterFlow.CharacterViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
//        YarusApp.appComponent.inject(this)
//
//        val viewModel = ViewModelProvider(this, viewModelFactory)[CharacterViewModel::class.java]
//        viewModel.getCharacterApiCall()

    }
}