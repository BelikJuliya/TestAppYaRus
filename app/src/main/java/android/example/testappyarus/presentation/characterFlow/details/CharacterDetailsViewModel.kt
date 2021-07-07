package android.example.testappyarus.presentation.characterFlow.details

import android.example.testappyarus.data.IRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import android.example.testappyarus.data.rest.Result
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterDetailsViewModel @Inject constructor(private val repository: IRepository): ViewModel() {
    val charactersDetailsLiveData: MutableLiveData<List<Result>> by lazy {
        MutableLiveData<List<Result>>()
    }

    fun loadCharacterDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            charactersDetailsLiveData.postValue(repository.getCharacterDetails(id))
        }
    }
}