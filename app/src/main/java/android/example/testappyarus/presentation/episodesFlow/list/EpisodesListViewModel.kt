package android.example.testappyarus.presentation.episodesFlow.list

import android.example.testappyarus.data.IRepository
import android.example.testappyarus.data.rest.IResponse
import android.example.testappyarus.domain.episodes.Episode
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodesListViewModel @Inject constructor(private val repository: IRepository) : ViewModel() {
    var maxPage: Int? = 1
    val episodesListLiveData: MutableLiveData<List<Episode>> by lazy {
        MutableLiveData<List<Episode>>()
    }
    private var episodesResponse: IResponse<List<Episode>>? = null

    fun loadEpisodes(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            episodesResponse = repository.getEpisodes(page)
            episodesListLiveData.postValue(episodesResponse?.toDomainObject())
            maxPage = episodesResponse?.getPage()
        }
    }
}