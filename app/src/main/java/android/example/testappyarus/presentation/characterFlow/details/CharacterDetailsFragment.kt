package android.example.testappyarus.presentation.characterFlow.details

import android.example.testappyarus.data.rest.Result
import android.example.testappyarus.domain.Character
import android.example.testappyarus.presentation.common.ViewModelFactory
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class CharacterDetailsFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel =
            ViewModelProvider(this, viewModelFactory)[CharacterDetailsViewModel::class.java]
        viewModel.loadCharacterDetails(1) // get from nav args
        val characterDetailsObserver = Observer<List<Result>> { characterList ->
            // Update the UI, in this case, a TextView.
        }
        viewModel.charactersDetailsLiveData.observe(viewLifecycleOwner, characterDetailsObserver)
    }

}