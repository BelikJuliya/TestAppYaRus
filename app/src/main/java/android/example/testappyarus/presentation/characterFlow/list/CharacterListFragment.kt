package android.example.testappyarus.presentation.characterFlow.list

import android.example.testappyarus.R
import android.example.testappyarus.domain.characters.Character
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
import kotlinx.android.synthetic.main.fragment_character_list.*
import javax.inject.Inject


/**
 * A fragment representing a list of characters.
 */
// TODO get max page only once and implement internet connection check
class CharacterListFragment : Fragment(R.layout.fragment_character_list) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var adapter: CharacterListAdapter
    private lateinit var viewModel: CharacterViewModel
    private var currentPage: Int = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        YarusApp.appComponent.inject(this) //may be it should be better initialized in Main Activity
        initRecyclerView()
        viewModel = ViewModelProvider(this, viewModelFactory)[CharacterViewModel::class.java]
        viewModel.loadCharacters(currentPage)
        val characterObserver = Observer<List<Character>> { characterList ->
                adapter.listCharacters.addAll(characterList)
                adapter.notifyDataSetChanged()
        }
        viewModel.charactersLiveData.observe(viewLifecycleOwner, characterObserver)

        characterSwipeToRefresh.setOnRefreshListener {
            viewModel.loadCharacters(currentPage)
            characterSwipeToRefresh.isRefreshing = false
        }
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(activity)
        characterRecyclerView.layoutManager = layoutManager
        characterRecyclerView.setHasFixedSize(true)
        characterRecyclerView.adapter = adapter
        setPagination(layoutManager)
    }

    private fun setPagination(layoutManager: LinearLayoutManager) { // may be move it to application class
        val scrollListener = object : CustomRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                if (currentPage < viewModel.maxPage!!){
                    viewModel.loadCharacters(++currentPage)
                }
            }
        }
        characterRecyclerView.addOnScrollListener(scrollListener as CustomRecyclerViewScrollListener)
    }
}

