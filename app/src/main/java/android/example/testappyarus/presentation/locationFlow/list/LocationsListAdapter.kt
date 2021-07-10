package android.example.testappyarus.presentation.locationFlow.list

import android.example.testappyarus.R
import android.example.testappyarus.domain.locations.Location
import android.example.testappyarus.presentation.characterFlow.list.listen
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.locations_list_item.view.*

class LocationsListAdapter : RecyclerView.Adapter<LocationsListAdapter.LocationsViewHolder>() {

    var locationsList = ArrayList<Location>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.locations_list_item, parent, false)
        return LocationsViewHolder(itemView).listen { position ->
            itemView.findNavController()
                .navigate(
                    LocationListFragmentDirections
                        .actionLocationListFragmentToLocationDetailsFragment(
                            locationsList[position].id
                        )
                )
        }
    }

    override fun onBindViewHolder(holder: LocationsViewHolder, position: Int) {
        holder.locationNameTextView.text = locationsList[position].name
        holder.locationTypeTextView.text = locationsList[position].type
        holder.locationDateTextView.text = locationsList[position].created
    }

    override fun getItemCount() = locationsList.size

    class LocationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var locationNameTextView: TextView = itemView.location_name
        var locationTypeTextView: TextView = itemView.location_type
        var locationDateTextView: TextView = itemView.location_created
    }
}

fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(absoluteAdapterPosition)
    }
    return this
}