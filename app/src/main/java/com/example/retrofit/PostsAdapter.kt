package com.example.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post.view.*

class PostsAdapter(
    private val posts: List<Post>
) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostsViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
    )

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = posts[position]
        holder.itemView.title.text = post.userId.toString()
        holder.itemView.body.text = post.id.toString()
        holder.itemView.title.text = post.title
        holder.itemView.body.text = post.body
    }

    override fun getItemCount() = posts.size

    class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}