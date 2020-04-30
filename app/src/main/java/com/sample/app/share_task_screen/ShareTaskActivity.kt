package com.sample.app.share_task_screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.app.R
import com.sample.app.model.User

import kotlinx.android.synthetic.main.content_main_api.*


class ShareTaskActivity : AppCompatActivity() , ShareTaskView{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main_api)

        ShareTaskPresenter(this).getDataFromApi()

    }

    override fun onDataCopmpleteFromApi(users: List<User>) {
        apiRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ShareTaskActivity)
            adapter = ShareTaskAdapter(users)
        }
    }

    override fun onDataErrorFromApi(throwable: Throwable) {
        error("error ------> ${throwable.localizedMessage}")
    }


}
