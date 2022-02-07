package com.markas.games.core.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.markas.games.core.R
import com.markas.games.core.databinding.ItemListGenresBinding
import com.markas.games.core.domain.model.Genres
import java.util.*

class GenresAdapter : RecyclerView.Adapter<GenresAdapter.ListViewHolder>() {

    private var listData = ArrayList<Genres>()
    var onItemClick: ((Genres) -> Unit)? = null

    fun setData(newListData: List<Genres>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_genres, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListGenresBinding.bind(itemView)
        fun bind(data: Genres) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.imageBackground)
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