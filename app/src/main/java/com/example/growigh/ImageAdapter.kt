package com.example.growigh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.growigh.dataclass.Images

class ImageAdapter(private val images: List<Images>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = images[position]
        val imageUrl = image.urls.regular
        val tagline = image.alt_description
        holder.likes.text = "${image.likes} likes"
        if (image.user != null) {
            holder.nameperson.text = image.user.name
            holder.username.text = image.user.username
        } else {
            // Handle the case when sponsorship or sponsor is null
            // You can set default values or show an error message, etc.
        }



        Glide.with(holder.itemView)
            .load(imageUrl)
            .into(holder.imageView)

        holder.taglineTextView.text = tagline
    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val taglineTextView: TextView = itemView.findViewById(R.id.desc)
        val likes : TextView = itemView.findViewById(R.id.like_count)
        val username : TextView = itemView.findViewById(R.id.pub_name)
        val nameperson : TextView = itemView.findViewById(R.id.cat_name)
    }
}
