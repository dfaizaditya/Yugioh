package com.submission.yugioh

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.submission.yugioh.databinding.ItemCardBinding
import com.submission.yugioh.model.Card
import com.submission.yugioh.utils.Constants.progressIndicator

class CardAdapter : ListAdapter<Card, CardAdapter.ViewHolder>(DIFF_CALLBACK) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Card) {
            with(binding) {
                tvName.text = data.name
                tvType.text = data.type
                tvDesc.text = data.desc
                Log.d("ooo", data.card_images.toString())
                Glide.with(itemView.context)
                    .load(data.card_images!![0].image_url_small)
                    .placeholder(itemView.context.progressIndicator())
                    .error(android.R.color.darker_gray)
                    .into(ivCard)
                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(data)
                }
            }
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Card)
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Card> =
            object : DiffUtil.ItemCallback<Card>() {
                override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
                    return oldItem.id == newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
                    return oldItem == newItem
                }
            }
    }
}