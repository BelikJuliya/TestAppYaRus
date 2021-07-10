package android.example.testappyarus.presentation.characterFlow.list

import android.example.testappyarus.R
import android.example.testappyarus.domain.characters.Character
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CharacterListAdapter :
    RecyclerView.Adapter<CharacterListAdapter.MyViewHolder>() {
    var listCharacters = ArrayList<Character>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var characterNameTextView: TextView? = null
        var characterSpeciesTextView: TextView? = null
        var characterAvatarImageView: ImageView? = null

        init {
            characterNameTextView = itemView.findViewById(R.id.character_name)
            characterSpeciesTextView = itemView.findViewById(R.id.character_species)
            characterAvatarImageView = itemView.findViewById(R.id.character_avatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.character_list_item, parent, false)
        return MyViewHolder(itemView).listen { position ->
            itemView.findNavController()
                .navigate(
                    CharacterListFragmentDirections
                        .actionCharacterListFragmentToCharacterDetailsFragment(
                            listCharacters[position].id
                        )
                )
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.characterNameTextView?.text = listCharacters[position].name
        holder.characterSpeciesTextView?.text = listCharacters[position].species
        holder.characterAvatarImageView?.let {
            Glide.with(holder.characterAvatarImageView!!).load(listCharacters[position].imageUrl)
                .apply(RequestOptions.centerCropTransform()).into(
                    it
                )
        }
    }

    override fun getItemCount() = listCharacters.size
}

fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(absoluteAdapterPosition)
    }
    return this
}