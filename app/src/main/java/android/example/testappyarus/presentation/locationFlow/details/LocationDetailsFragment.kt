package android.example.testappyarus.presentation.locationFlow.details

import android.example.testappyarus.R
import android.example.testappyarus.data.rest.Result
import android.example.testappyarus.presentation.characterFlow.details.CharacterDetailsFragmentArgs
import android.example.testappyarus.presentation.characterFlow.details.CharacterDetailsViewModel
import android.example.testappyarus.presentation.common.ViewModelFactory
import android.example.testappyarus.presentation.common.YarusApp
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_location_details.*
import javax.inject.Inject

class LocationDetailsFragment: Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        YarusApp.appComponent.inject(this) //may be it should be better initialized in Main Activity
        val viewModel =
            ViewModelProvider(this, viewModelFactory)[CharacterDetailsViewModel::class.java]
        val args by navArgs<CharacterDetailsFragmentArgs>()
        viewModel.loadCharacterDetails(args.characterId) // get from nav args
        println("onCreateView after loading characters")
        val characterDetailsObserver = Observer<Result> { result ->
//                locationDetailsName.text = result.name
//                locationDetailsType.text = result.type
//                locationDetailsDimension.text = result.dimension

        }
        viewModel.charactersDetailsLiveData.observe(viewLifecycleOwner, characterDetailsObserver)
        println("observation started")
        return inflater.inflate(R.layout.fragment_location_details, container, false)
    }
}