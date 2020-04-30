package com.sample.app.create_task_screen

import com.sample.app.model.Task


interface CreateTaskView {
    fun onTaskCreationComplete(task: Task)
    fun onTaskCreationError()
}