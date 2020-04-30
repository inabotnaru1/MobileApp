package com.sample.app.share_task_screen

import android.content.Context
import com.sample.app.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShareTaskPresenter(context: Context) {
    val view = context as ShareTaskView

    fun getDataFromApi(){
        ApiService.create()
            .fetchData().enqueue(object : Callback<List<User>> {
                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    view.onDataErrorFromApi(t)
                }

                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    view.onDataCopmpleteFromApi(response.body()!!)
                }
            })

    }
}