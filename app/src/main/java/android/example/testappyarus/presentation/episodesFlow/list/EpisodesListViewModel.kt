package android.example.testappyarus.presentation.episodesFlow.list

import android.example.testappyarus.data.IRepository
import android.example.testappyarus.domain.Episode
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodesListViewModel @Inject constructor(private val repository: IRepository) : ViewModel() {
    val episodesListLiveData: MutableLiveData<List<Episode>> by lazy {
        MutableLiveData<List<Episode>>()
    }

    fun loadEpisodes() {
        viewModelScope.launch(Dispatchers.IO) {
            episodesListLiveData.postValue(repository.getEpisodes())
        }
    }
}