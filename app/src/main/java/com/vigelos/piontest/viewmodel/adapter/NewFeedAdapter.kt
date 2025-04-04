package com.vigelos.piontest.viewmodel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vigelos.piontest.data.model.Item
import com.vigelos.piontest.databinding.ItemNewFeedBinding

class NewFeedAdapter(
    private val items: List<Item>
) : RecyclerView.Adapter<NewFeedAdapter.PostViewHolder>() {

    inner class PostViewHolder(val binding: ItemNewFeedBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemNewFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = items[position]
        val context = holder.itemView.context

        with(holder.binding) {
            // Load avatar
            item.avatar?.href?.let {
                Glide.with(context)
                    .load(it)
                    .circleCrop()
                    .into(avatar)
            } ?: run {
                avatar.setImageDrawable(null)
            }

            // Set title, description
            title.text = item.title
            description.text = item.description ?: ""

            // Load up to 3 images
            val imageList = item.images.orEmpty().take(3)

            val imageViews = listOf(image1, image2, image3)

            imageViews.forEachIndexed { index, imageView ->
                if (index < imageList.size) {
                    Glide.with(context)
                        .load(imageList[index].href)
                        .centerCrop()
                        .into(imageView)
                    imageView.visibility = View.VISIBLE
                } else {
                    imageView.visibility = View.GONE
                }
            }
        }
    }

    override fun getItemCount(): Int = items.size
}
