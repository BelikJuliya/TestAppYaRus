package android.example.testappyarus.presentation.locationFlow.details

import android.example.testappyarus.data.IRepository
import android.example.testappyarus.domain.locations.LocationResult
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationDetailsViewModel @Inject constructor(private val repository: IRepository): ViewModel() {
     val locationsDetailsLiveData: MutableLiveData<LocationResult> by lazy {
        MutableLiveData<LocationResult>()
    }

    fun loadLocationDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            locationsDetailsLiveData.postValue(repository.getLocationDetails(id))
        }
    }
}