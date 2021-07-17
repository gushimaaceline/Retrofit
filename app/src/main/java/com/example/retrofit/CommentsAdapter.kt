package com.example.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.comment_list_item.view.*

class CommentsAdapter(var commentList:List<Comment>):RecyclerView.Adapter<CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var itemView= LayoutInflater.from(parent.context).inflate(R.layout.comment_list_item,parent,false)
        return CommentsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var comment= commentList.get(position)
        holder.itemView.tvName.text= comment.name.toString()
        holder.itemView.tvEmail.text= comment.email.toString()
        holder.itemView.tvBody.text= comment.body.toString()


    }

    override fun getItemCount(): Int {
        return commentList.size
    }

}
class CommentsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var cvComment= itemView.findViewById<TextView>(R.id.cvComment)
    var tvName= itemView.findViewById<TextView>(R.id.tvName)
    var tvEmail= itemView.findViewById<TextView>(R.id.tvEmail)
    var tvBody= itemView.findViewById<TextView>(R.id.tvBody)
}