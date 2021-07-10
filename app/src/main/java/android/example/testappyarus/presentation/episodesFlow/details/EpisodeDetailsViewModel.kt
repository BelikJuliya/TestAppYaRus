package android.example.testappyarus.presentation.episodesFlow.details

import android.example.testappyarus.data.IRepository
import android.example.testappyarus.domain.episodes.EpisodeResult
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodeDetailsViewModel @Inject constructor(private val repository: IRepository) :
    ViewModel() {
    val episodesDetailsLiveData: MutableLiveData<EpisodeResult> by lazy {
        MutableLiveData<EpisodeResult>()
    }

    fun loadEpisodeDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            episodesDetailsLiveData.postValue(repository.getEpisodeDetails(id))
        }
    }
}