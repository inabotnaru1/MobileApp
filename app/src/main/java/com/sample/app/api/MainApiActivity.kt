package com.sample.app.api

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.app.R
import com.sample.app.firebase.adapters.FeedRecyclerViewAdapter

import kotlinx.android.synthetic.main.activity_main_api.*
import kotlinx.android.synthetic.main.activity_tabs.*
import kotlinx.android.synthetic.main.content_main_api.*
import kotlinx.android.synthetic.main.fragment_tasks.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainApiActivity : AppCompatActivity() {
    lateinit var textViewResult : TextView
    lateinit var specificData : SpecificData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main_api)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Api::class.java)

        val testApi = retrofit.create(Api::class.java)

        val newTestData = TestData("1","Mw6653hyuB","My Dream Job","My dream job is to be a cat")

        testApi.postData(newTestData).enqueue(object :Callback<TestData>{
            override fun onFailure(call: Call<TestData>, t: Throwable) {
                d("fail","saaaad")
            }

            override fun onResponse(call: Call<TestData>, response: Response<TestData>) {
                if (response.isSuccessful){
                    Toast.makeText(this@MainApiActivity, "Post Request Successful", Toast.LENGTH_LONG).show()
                }
            }

        })

        api.fetchData().enqueue(object : Callback<List<SpecificData>>{
            override fun onFailure(call: Call<List<SpecificData>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<SpecificData>>, response: Response<List<SpecificData>>) {
                showData(response.body()!!)
            }
        })

    }

    private fun showData(data: List<SpecificData>) {
        apiRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainApiActivity)
            adapter = DataAdapter(data)
        }

    }


}
