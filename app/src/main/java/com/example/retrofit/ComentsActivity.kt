package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_coments.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body

class ComentsActivity : AppCompatActivity() {
    var postId= 0
    lateinit var tvPOstTitle:TextView
    lateinit var tvPostBody: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coments)
        postId= intent.getIntExtra("post_id",0)
        castComments()
        getPosts()
        getComments()


    }
    fun castComments(){
        tvPOstTitle= findViewById(R.id.tvPOstTitle)
        tvPostBody= findViewById(R.id.tvPostBody)

    }
    fun getPosts() {
        if (postId == 0) {
            finish()
        }
        //Toast data not found
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPosts(postId)
        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    var post = response.body()
                    tvPOstTitle.text = post?.title
                    tvPostBody.text = post?.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
        fun getComments(){
            var rvComment= findViewById<RecyclerView>(R.id.rvComents)
            var apiClient= ApiClient.buildApiClient(ApiInterface::class.java)
            var request= apiClient.getComments(postId)
            request.enqueue(object :Callback<List<Comment>>{
                override fun onResponse(
                    call: Call<List<Comment>>, response: Response<List<Comment>>
                ) {
                 var comments= response.body()!!
                    var CommentsAdapter=CommentsAdapter(comments)
                    rvComment.adapter= CommentsAdapter
                    rvComment.layoutManager= LinearLayoutManager(baseContext)
                }

                override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                  Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
                }
            })

            }


        }

