package android.example.testappyarus.presentation.characterFlow.details

import android.example.testappyarus.R
import android.example.testappyarus.domain.characters.CharacterResult
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
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_character_details.*
import javax.inject.Inject

class CharacterDetailsFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        YarusApp.appComponent.inject(this) //may be it should be better initialized in Main Activity
        val viewModel =
            ViewModelProvider(this, viewModelFactory)[CharacterDetailsViewModel::class.java]
        val args by navArgs<CharacterDetailsFragmentArgs>()
        viewModel.loadCharacterDetails(args.characterId) // get from nav args
        println("onCreateView after loading characters")
        val characterDetailsObserver = Observer<CharacterResult> { result ->
            println("Live Data changed")
            println("List is not null")
            if (result != null) {
                name.text = result.name
                gender.text = result.gender
                location.text = result.location.name
                status.text = result.status
                species.text = result.species
                Glide.with(character_big_avatar).load(result.image)
                    .apply(RequestOptions.centerCropTransform())
                    .into(character_big_avatar)
                println("new values set to views")
            }
        }
        viewModel.charactersDetailsLiveData.observe(viewLifecycleOwner, characterDetailsObserver)
        println("observation started")
        return inflater.inflate(R.layout.fragment_character_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}