package android.example.testappyarus.presentation.characterFlow.details

import android.example.testappyarus.data.IRepository
import android.example.testappyarus.data.rest.Result
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterDetailsViewModel @Inject constructor(private val repository: IRepository) :
    ViewModel() {
    val charactersDetailsLiveData: MutableLiveData<Result> by lazy {
        MutableLiveData<Result>()
    }

    fun loadCharacterDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            charactersDetailsLiveData.postValue(repository.getCharacterDetails(id))
        }
    }
}