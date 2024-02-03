package com.divyanshu.movie_app_2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.divyanshu.movie_app_2.databinding.TvShowItemBinding
import com.divyanshu.movie_app_2.model.TVShowItem

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding: TvShowItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val itemCallbackListener = object : DiffUtil.ItemCallback<TVShowItem>() {
        override fun areItemsTheSame(oldItem: TVShowItem, newItem: TVShowItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TVShowItem, newItem: TVShowItem): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, itemCallbackListener)
    var tvShows: List<TVShowItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            TvShowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun getItemCount(): Int {
        return tvShows.count()
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTvShow = tvShows[position]
        holder.binding.apply {
            txtTvShow.text = currentTvShow.name
            imgTvShow.load(currentTvShow.image.original) {
                crossfade(true)
                crossfade(500)
            }
            //  imgTvShow.load
        }
    }
}

