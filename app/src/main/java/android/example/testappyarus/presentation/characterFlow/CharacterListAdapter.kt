package android.example.testappyarus.presentation.characterFlow

import android.example.testappyarus.R
import android.example.testappyarus.domain.Character
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CharacterListAdapter(val characters: List<Character>) :
    RecyclerView.Adapter<CharacterListAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var characterNameTextView: TextView? = null
        var characterSpiciesTextView: TextView? = null
        var characterAvatarImageView: ImageView? = null

        init {
            characterNameTextView = itemView.findViewById(R.id.character_name)
            characterSpiciesTextView = itemView.findViewById(R.id.character_species)
            characterAvatarImageView = itemView.findViewById(R.id.character_avatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.character_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.characterNameTextView?.text = characters[position].name
        holder.characterSpiciesTextView?.text = characters[position].species
        //holder.characterAvatarImageView?.setImageBitmap(Picasso.with(ap).load(imageUri).into(ivBasicImage);)
    }

    override fun getItemCount() = characters.size
}