package android.example.testappyarus.presentation.characterFlow.list

import android.example.testappyarus.R
import android.example.testappyarus.domain.characters.Character
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
class CharacterListFragment : Fragment(R.layout.fragment_character_list) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val adapter = CharacterListAdapter()
    private var loading = true
    private var pastVisiblesItems = 0
    private var visibleItemCount: Int = 0
    private var totalItemCount: Int = 0
    private lateinit var viewModel: CharacterViewModel
    private var currentPage: Int = 2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        YarusApp.appComponent.inject(this) //may be it should be better initialized in Main Activity
        viewModel = ViewModelProvider(this, viewModelFactory)[CharacterViewModel::class.java]
        viewModel.loadCharacters(currentPage)
        val characterObserver = Observer<List<Character>> { characterList ->
            if (characterList != null) {
                adapter.listCharacters = characterList as ArrayList<Character>
                adapter.notifyDataSetChanged()
            }
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

        characterRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) { //check for scroll down
                    visibleItemCount = layoutManager.childCount
                    totalItemCount = layoutManager.itemCount
                    pastVisiblesItems = layoutManager.findFirstVisibleItemPosition()
                    if (loading) {
                        if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                            loading = false
                            println("fetch new data")
                            currentPage++
                            if (currentPage <= 671) viewModel.loadCharacters(currentPage)
                            // Do pagination.. i.e. fetch new data
                            loading = true
                        }
                    }
                }
            }
        })
    }
}