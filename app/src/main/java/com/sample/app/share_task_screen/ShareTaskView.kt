package com.sample.app.share_task_screen

import com.sample.app.model.User

interface ShareTaskView {
    fun onDataCopmpleteFromApi(users: List<User>)
    fun onDataErrorFromApi(throwable: Throwable)
}