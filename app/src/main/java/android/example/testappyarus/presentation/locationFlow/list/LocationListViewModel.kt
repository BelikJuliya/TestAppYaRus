package android.example.testappyarus.presentation.locationFlow.list

import android.example.testappyarus.data.IRepository
import android.example.testappyarus.data.rest.IResponse
import android.example.testappyarus.domain.locations.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationListViewModel @Inject constructor(private val repository: IRepository) : ViewModel() {
    var maxPage: Int? = 1
    val locationsListLiveData: MutableLiveData<List<Location>> by lazy {
        MutableLiveData<List<Location>>()
    }
    private var locationResponse: IResponse<List<Location>>? = null

    fun loadLocations(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            locationResponse = repository.getLocations(page)
            locationsListLiveData.postValue(locationResponse?.toDomainObject())
            maxPage = locationResponse?.getPage()
        }
    }
}