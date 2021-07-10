package android.example.testappyarus.presentation.episodesFlow.list

import android.example.testappyarus.R
import android.example.testappyarus.domain.episodes.Episode
import android.example.testappyarus.presentation.characterFlow.list.CharacterListFragmentDirections
import android.example.testappyarus.presentation.characterFlow.list.listen
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.episodes_list_item.view.*

class EpisodesListAdapter : RecyclerView.Adapter<EpisodesListAdapter.EpisodesViewHolder>() {

    var episodesList = ArrayList<Episode>()

    class EpisodesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var episodeNameTextView: TextView = itemView.episodeName
        var episodeTextView: TextView = itemView.episode
        var airDateTextView: TextView = itemView.airDate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.episodes_list_item, parent, false)
        return EpisodesListAdapter.EpisodesViewHolder(itemView).listen { position ->
            itemView.findNavController()
                .navigate(
                    EpisodesListFragmentDirections
                        .actionEpisodesListFragmentToEpisodeDetailsFragment(
                            episodesList[position].id
                        )
                )
        }
    }

    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) {
        holder.episodeNameTextView.text = episodesList[position].name
        holder.episodeTextView.text = episodesList[position].episode
        holder.airDateTextView.text = episodesList[position].airDate
    }

    override fun getItemCount() = episodesList.size
}

fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(absoluteAdapterPosition)
    }
    return this
}