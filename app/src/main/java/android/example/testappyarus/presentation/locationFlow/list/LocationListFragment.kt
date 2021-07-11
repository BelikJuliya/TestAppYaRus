package android.example.testappyarus.presentation.locationFlow.list

import android.example.testappyarus.R
import android.example.testappyarus.domain.locations.Location
import android.example.testappyarus.presentation.common.CustomRecyclerViewScrollListener
import android.example.testappyarus.presentation.common.ViewModelFactory
import android.example.testappyarus.presentation.common.YarusApp
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_locations_list.*
import javax.inject.Inject

class LocationListFragment : Fragment(R.layout.fragment_locations_list) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var adapter: LocationsListAdapter
    private lateinit var viewModel: LocationListViewModel
    private var currentPage: Int = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        YarusApp.appComponent.inject(this)
        viewModel =
            ViewModelProvider(this, viewModelFactory)[LocationListViewModel::class.java]
        viewModel.loadLocations(currentPage)
        initRecyclerView()
        val locationsObserver = Observer<List<Location>> { locationsList ->
            adapter.locationsList.addAll(locationsList)
            adapter.notifyDataSetChanged()
        }
        viewModel.locationsListLiveData.observe(viewLifecycleOwner, locationsObserver)

        locationsSwipeToRefresh.setOnRefreshListener {
            viewModel.loadLocations(currentPage)
            locationsSwipeToRefresh.isRefreshing = false
        }
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(activity)
        locationsRecyclerView.layoutManager = layoutManager
        locationsRecyclerView.setHasFixedSize(true)
        locationsRecyclerView.adapter = adapter
        setPagination(layoutManager)
    }

    private fun setPagination(layoutManager: LinearLayoutManager) { // may be move it to application class
        val scrollListener = object : CustomRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                if (currentPage < viewModel.maxPage!!) {
                    viewModel.loadLocations(++currentPage)
                }
            }
        }
        locationsRecyclerView.addOnScrollListener(scrollListener as CustomRecyclerViewScrollListener)
    }
}