package android.example.testappyarus.presentation.characterFlow.list

import android.example.testappyarus.data.IRepository
import android.example.testappyarus.domain.characters.Character
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterViewModel @Inject constructor(private val repository: IRepository) : ViewModel() {
    val charactersLiveData: MutableLiveData<List<Character>> by lazy {
        MutableLiveData<List<Character>>()
    }

    fun loadCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            charactersLiveData.postValue(repository.getCharacterApiCall())
        }
    }
}