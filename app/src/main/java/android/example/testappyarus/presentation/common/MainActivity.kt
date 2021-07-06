package android.example.testappyarus.presentation.common

import android.example.testappyarus.R
import android.example.testappyarus.di.AppComponent
import android.example.testappyarus.presentation.characterFlow.CharacterViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var  component: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        YarusApp.appComponent.inject(this)

        val viewModel = ViewModelProvider(this, viewModelFactory)[CharacterViewModel::class.java]
        viewModel.sayBlaBla()
        viewModel.getCharacterApiCall()

    }
}