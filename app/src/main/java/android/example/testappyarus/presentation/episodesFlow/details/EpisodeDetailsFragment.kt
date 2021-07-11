package android.example.testappyarus.presentation.episodesFlow.details

import android.example.testappyarus.R
import android.example.testappyarus.domain.episodes.EpisodeResult
import android.example.testappyarus.presentation.characterFlow.details.CharacterDetailsFragmentArgs
import android.example.testappyarus.presentation.common.ViewModelFactory
import android.example.testappyarus.presentation.common.YarusApp
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_episode_details.*
import javax.inject.Inject

class EpisodeDetailsFragment : Fragment(R.layout.fragment_episode_details) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        YarusApp.appComponent.inject(this)
        val viewModel =
            ViewModelProvider(this, viewModelFactory)[EpisodeDetailsViewModel::class.java]
        val args by navArgs<CharacterDetailsFragmentArgs>()
        viewModel.loadEpisodeDetails(args.characterId)
        println("onCreateView after loading characters")
        val characterDetailsObserver = Observer<EpisodeResult> { result ->
            println("Live Data changed")
            episodeDetailsName.text = result.name
            episodeDetailsAirDate.text = result.air_date
            episodeDetailsEpisode.text = result.episode
        }
        viewModel.episodesDetailsLiveData.observe(viewLifecycleOwner, characterDetailsObserver)
    }
}