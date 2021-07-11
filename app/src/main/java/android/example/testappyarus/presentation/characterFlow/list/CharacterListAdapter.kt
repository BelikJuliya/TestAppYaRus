package android.example.testappyarus.presentation.characterFlow.list

import android.content.Context
import android.example.testappyarus.R
import android.example.testappyarus.domain.characters.Character
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.character_list_item.view.*

class CharacterListAdapter :
    RecyclerView.Adapter<CharacterListAdapter.MyViewHolder>() {
    var listCharacters = ArrayList<Character>()
    lateinit var context: Context

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var characterNameTextView: TextView = itemView.characterName
        var characterSpeciesTextView: TextView = itemView.characterSpecies
        var characterStatus: TextView = itemView.characterStatus
        val characterGender: TextView = itemView.characterGender
        var characterAvatarImageView: ImageView = itemView.characterAvatar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.character_list_item, parent, false)
        context = parent.context
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
        holder.characterNameTextView.text = listCharacters[position].name
        holder.characterSpeciesTextView.text = listCharacters[position].species
        holder.characterStatus.text = listCharacters[position].status
        holder.characterGender.text = listCharacters[position].gender
        holder.characterAvatarImageView.let {
            Glide.with(holder.characterAvatarImageView).load(listCharacters[position].imageUrl)
                .apply(RequestOptions.centerCropTransform()).into(
                    it
                )
        }

        val color = when (listCharacters[position].status) {
            "Dead" -> R.color.dead_red
            "Alive" -> R.color.alive_green
            else -> R.color.unknown
        }
        holder.characterStatus.setTextColor(ContextCompat.getColor(context, color))
    }

    override fun getItemCount() = listCharacters.size
}

fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(absoluteAdapterPosition)
    }
    return this
}