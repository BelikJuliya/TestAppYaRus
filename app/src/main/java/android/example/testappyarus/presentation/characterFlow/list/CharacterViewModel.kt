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
    var maxPage: Int? = 1
    val charactersLiveData: MutableLiveData<List<Character>> by lazy {
        MutableLiveData<List<Character>>()
    }

    fun loadCharacters(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val characterResponse = repository.getCharacters(page)
            charactersLiveData.postValue(characterResponse?.toDomainObject())
            maxPage = characterResponse?.getPage()
        }
    }
}