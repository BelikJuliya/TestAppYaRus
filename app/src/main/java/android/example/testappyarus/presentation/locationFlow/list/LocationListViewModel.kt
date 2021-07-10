package android.example.testappyarus.presentation.locationFlow.list

import android.example.testappyarus.data.IRepository
import android.example.testappyarus.domain.locations.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationListViewModel @Inject constructor(private val repository: IRepository) : ViewModel() {
    val locationsListLiveData: MutableLiveData<List<Location>> by lazy {
        MutableLiveData<List<Location>>()
    }

    fun loadLocations() {
        viewModelScope.launch(Dispatchers.IO) {
            locationsListLiveData.postValue(repository.getLocations())
        }
    }
}