package android.example.testappyarus.presentation.characterFlow

import android.example.testappyarus.data.IRepository
import android.example.testappyarus.domain.Character
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterViewModel @Inject constructor(private val repository: IRepository) : ViewModel() {
    var charactersLiveData: MutableLiveData<List<Character>> = MutableLiveData()

    fun getCharacterApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            charactersLiveData.postValue(repository.getCharacterApiCall())
            println("Bla bla bla")
        }
    }
}