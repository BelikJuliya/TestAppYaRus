package android.example.testappyarus.presentation.locationFlow.details

import android.example.testappyarus.R
import android.example.testappyarus.domain.locations.LocationResult
import android.example.testappyarus.presentation.characterFlow.details.CharacterDetailsFragmentArgs
import android.example.testappyarus.presentation.common.ViewModelFactory
import android.example.testappyarus.presentation.common.YarusApp
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_location_details.*
import javax.inject.Inject

class LocationDetailsFragment : Fragment(R.layout.fragment_location_details) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        YarusApp.appComponent.inject(this)
        val viewModel =
            ViewModelProvider(this, viewModelFactory)[LocationDetailsViewModel::class.java]
        val args by navArgs<CharacterDetailsFragmentArgs>()
        viewModel.loadLocationDetails(args.characterId)
        val locationDetailsObserver = Observer<LocationResult> { result ->
            locationDetailsName.text = result.name
            locationDetailsType.text = result.type
            locationDetailsDimension.text = result.dimension

        }
        viewModel.locationsDetailsLiveData.observe(viewLifecycleOwner, locationDetailsObserver)
    }
}