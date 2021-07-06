package android.example.testappyarus.presentation

import android.example.testappyarus.data.IRepository
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class CharacterViewModel @Inject constructor(private val repository: IRepository): ViewModel() {
    fun sayBlaBla(){
        println("Bla bla bla")
    }
}