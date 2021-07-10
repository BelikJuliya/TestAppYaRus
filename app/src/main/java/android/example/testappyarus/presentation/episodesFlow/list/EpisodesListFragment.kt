package android.example.testappyarus.presentation.episodesFlow.list

import android.example.testappyarus.R
import android.example.testappyarus.domain.episodes.Episode
import android.example.testappyarus.presentation.common.ViewModelFactory
import android.example.testappyarus.presentation.common.YarusApp
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_episodes_list.*
import javax.inject.Inject

class EpisodesListFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private var adapter = EpisodesListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_episodes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        YarusApp.appComponent.inject(this) //may be it should be better initialized in Main Activity
        val viewModel =
            ViewModelProvider(this, viewModelFactory)[EpisodesListViewModel::class.java]
        viewModel.loadEpisodes()
        initRecyclerView()

        val episodesObserver = Observer<List<Episode>> { episode ->
            adapter.episodesList = episode as ArrayList<Episode>
            adapter.notifyDataSetChanged()
            println("New list set to adapter")
        }
        viewModel.episodesListLiveData.observe(viewLifecycleOwner, episodesObserver)
    }

    private fun initRecyclerView() {
        episodesRecyclerView.layoutManager = LinearLayoutManager(activity)
        episodesRecyclerView.setHasFixedSize(true)
        episodesRecyclerView.adapter = adapter
    }
}