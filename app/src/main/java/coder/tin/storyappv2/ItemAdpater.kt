package coder.tin.storyappv2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ItemAdpater(val storyTitles:Array<String>,val storyContents: Array<String>,val storyImages:Array<String>) :RecyclerView.Adapter<ItemAdpater.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardTitle: TextView = itemView.findViewById(R.id.cardTitle)
        val cardContent:TextView = itemView.findViewById(R.id.cardContent)
        val cardImage:ImageView = itemView.findViewById(R.id.cardImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_item_view,parent,false   )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cardTitle.text = storyTitles[position]
        holder.cardContent.text = storyContents[position]
        Picasso.get().load(storyImages[position]).into(holder.cardImage)
    }

    override fun getItemCount(): Int {
        return storyTitles.size
    }
}