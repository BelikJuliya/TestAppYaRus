package android.example.testappyarus.presentation.locationFlow.list

import android.example.testappyarus.R
import android.example.testappyarus.domain.locations.Location
import android.example.testappyarus.presentation.common.ViewModelFactory
import android.example.testappyarus.presentation.common.YarusApp
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_character_list.*
import kotlinx.android.synthetic.main.fragment_locations_list.*
import javax.inject.Inject

class LocationListFragment : Fragment(R.layout.fragment_locations_list) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private var adapter = LocationsListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        YarusApp.appComponent.inject(this) //may be it should be better initialized in Main Activity
        val viewModel =
            ViewModelProvider(this, viewModelFactory)[LocationListViewModel::class.java]
        viewModel.loadLocations()
        initRecyclerView()

        val locationsObserver = Observer<List<Location>> { locationsList ->
            adapter.locationsList = locationsList as ArrayList<Location>
            adapter.notifyDataSetChanged()
        }
        viewModel.locationsListLiveData.observe(viewLifecycleOwner, locationsObserver)

        locationsSwipeToRefresh.setOnRefreshListener {
            viewModel.loadLocations()
            locationsSwipeToRefresh.isRefreshing = false
        }
    }

    private fun initRecyclerView() {
        locationsRecyclerView.layoutManager = LinearLayoutManager(activity)
        locationsRecyclerView.setHasFixedSize(true)
        locationsRecyclerView.adapter = adapter
    }
}