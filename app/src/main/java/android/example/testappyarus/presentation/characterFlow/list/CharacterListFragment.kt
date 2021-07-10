package android.example.testappyarus.presentation.characterFlow.list

import android.example.testappyarus.R
import android.example.testappyarus.domain.characters.Character
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
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject

/**
 * A fragment representing a list of characters.
 */
class CharacterListFragment : Fragment() {
    @Inject
     lateinit var viewModelFactory: ViewModelFactory
     private val adapter = CharacterListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        YarusApp.appComponent.inject(this) //may be it should be better initialized in Main Activity
        val viewModel = ViewModelProvider(this, viewModelFactory)[CharacterViewModel::class.java]
        viewModel.loadCharacters()
        val characterObserver = Observer<List<Character>> { characterList ->
            adapter.listCharacters = characterList as ArrayList<Character>
            adapter.notifyDataSetChanged()
            println("New list set to adapter")
        }
        viewModel.charactersLiveData.observe(viewLifecycleOwner, characterObserver)

        val view = inflater.inflate(R.layout.fragment_character_list, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        val recyclerView: RecyclerView? = view?.findViewById(R.id.character_recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = adapter
    }
}