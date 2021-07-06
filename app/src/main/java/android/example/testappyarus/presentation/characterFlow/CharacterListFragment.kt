package android.example.testappyarus.presentation.characterFlow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.example.testappyarus.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A fragment representing a list of characters.
 */
class CharacterListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val recyclerView: RecyclerView? = view?.findViewById(R.id.character_recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        return inflater.inflate(R.layout.fragment_character_list, container, false)
    }
}