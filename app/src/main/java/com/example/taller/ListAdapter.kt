package com.example.taller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taller.databinding.ItemBinding

class ListAdapter(
    private val items: List<Item>,
    private val onItemClick: (Item) -> Unit,
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemBinding.inflate(inflater, parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }


    inner class ViewHolder(private val itemBiding: ItemBinding) : RecyclerView.ViewHolder(itemBiding.root) {
        fun bind(item: Item) {
            with(itemBiding) {
                title.text = item.title
                description.text = item.description
                root.setOnClickListener { onItemClick(item) }
            }
        }
    }
}