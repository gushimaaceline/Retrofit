package com.example.retrofit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post.view.*

class PostsAdapter(var posts: List<Post>,var context: Context) : RecyclerView.Adapter<PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        var post = posts.get(position)
        holder.itemView.userId.text = post.userId.toString()
        holder.itemView.Id.text = post.id.toString()
        holder.itemView.title.text = post.title.toString()
        holder.itemView.body.text = post.body.toString()
        holder.cvPost.setOnClickListener {
            var intent= Intent(context,ComentsActivity::class.java)
            intent.putExtra("post_id",post.id.toString())
        }
    }

    override fun getItemCount() = posts.size

}
class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var cvPost= itemView.findViewById<CardView>(R.id.cvPost)
    var userId= itemView.findViewById<TextView>(R.id.userId)
    var id= itemView.findViewById<TextView>(R.id.Id)
    var title= itemView.findViewById<TextView>(R.id.title)
    var body= itemView.findViewById<TextView>(R.id.body)



}