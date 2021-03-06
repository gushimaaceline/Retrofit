package com.example.retrofit

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPosts()

    }

    private fun getPosts() {
//        rv_posts= findViewById(R.id.rv_posts)
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = retrofit.getPosts()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(
                call: Call<List<Post>>, response:
                Response<List<Post>>
            ) {
                if (response.isSuccessful) {
                    var posts = response.body()!!//This is a list, the exclamation is to assert the value hold by variable not to be null
                    rv_posts.layoutManager= LinearLayoutManager(baseContext)
                    rv_posts.adapter= PostsAdapter(posts,baseContext)



//                    rv_posts.layoutManager =LinearLayoutManager(baseContext)
//                        GridLayoutManager(this@MainActivity,2)
                        //LinearLayoutManager(this@MainActivity)




//                    var posts= PostsAdapter(posts,baseContext)
//                    rv_posts.layoutManager= LinearLayoutManager(baseContext)
//                    rv_posts.adapter= PostsAdapter





//                    Toast.makeText(
//                        baseContext, "${posts!!.size} posts", Toast.LENGTH_LONG
//                    ).show() if there is an error show it
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }
        })
    }
}