package com.markas.games.core.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.markas.games.core.R
import com.markas.games.core.databinding.ItemListGamesBinding
import com.markas.games.core.domain.model.Games
import java.util.*

class PcGamesAdapter : RecyclerView.Adapter<PcGamesAdapter.ListViewHolder>() {

    private var listData = ArrayList<Games>()
    var onItemClick: ((Games) -> Unit)? = null

    fun setData(newListData: List<Games>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_games, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListGamesBinding.bind(itemView)
        fun bind(data: Games) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.backgroundImage)
                    .transition(withCrossFade())
                    .into(image)

                title.text = data.name
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}