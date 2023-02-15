package com.example.youtube.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtube.data.model.PopularVideo
import com.example.youtube.databinding.ItemCountBinding

class VideosCategoriesAdapter: PagingDataAdapter<PopularVideo, VideosCategoriesAdapter.VideoViewHolder>(diffUtil) {
    inner class VideoViewHolder(private val binding: ItemCountBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: PopularVideo) = with(binding) {
            Glide.with(ivVideoPoster.context)
                .load(item.snippet.thumbnails.standard.url)
                .into(ivVideoPoster)
            tvVideoDescription.text = item.snippet.title
            tvNameChannel.text = item.snippet.channelTitle
        }

        init {
            itemView.setOnClickListener {
                getItem(bindingAdapterPosition)?.apply {
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            ItemCountBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<PopularVideo>() {
            override fun areItemsTheSame(oldItem: PopularVideo, newItem: PopularVideo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: PopularVideo, newItem: PopularVideo): Boolean {
                return oldItem == newItem
            }
        }
    }
}