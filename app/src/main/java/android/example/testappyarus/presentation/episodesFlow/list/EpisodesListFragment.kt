package android.example.testappyarus.presentation.episodesFlow.list

import android.example.testappyarus.R
import android.example.testappyarus.domain.episodes.Episode
import android.example.testappyarus.presentation.common.EndlessRecyclerViewScrollListener
import android.example.testappyarus.presentation.common.ViewModelFactory
import android.example.testappyarus.presentation.common.YarusApp
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_episodes_list.*
import javax.inject.Inject

class EpisodesListFragment : Fragment(R.layout.fragment_episodes_list) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var adapter: EpisodesListAdapter
    private lateinit var viewModel: EpisodesListViewModel
    private var currentPage: Int = 1 // make it constant
    private val maxPage = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        YarusApp.appComponent.inject(this) //may be it should be better initialized in Main Activity
        viewModel =
            ViewModelProvider(this, viewModelFactory)[EpisodesListViewModel::class.java]
        viewModel.loadEpisodes(currentPage)
        initRecyclerView()

        val episodesObserver = Observer<List<Episode>> { episode ->
            adapter.episodesList.addAll(episode)
            adapter.notifyDataSetChanged()
        }
        viewModel.episodesListLiveData.observe(viewLifecycleOwner, episodesObserver)

        episodesSwipeToRefresh.setOnRefreshListener {
            viewModel.loadEpisodes(currentPage)
            episodesSwipeToRefresh.isRefreshing = false
        }
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(activity)
        episodesRecyclerView.layoutManager = layoutManager
        episodesRecyclerView.setHasFixedSize(true)
        episodesRecyclerView.adapter = adapter
        setPagination(layoutManager)
    }

    private fun setPagination(layoutManager: LinearLayoutManager) { // may be move it to application class
        val scrollListener = object : EndlessRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                if (currentPage <= maxPage){
                    viewModel.loadEpisodes(++currentPage)
                }
            }
        }
        episodesRecyclerView.addOnScrollListener(scrollListener as EndlessRecyclerViewScrollListener)
    }
}