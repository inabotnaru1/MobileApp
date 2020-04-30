package com.sample.app.create_task_screen

import android.content.Context
import android.widget.EditText
import com.google.firebase.database.FirebaseDatabase
import com.sample.app.model.Task

class CreateTaskPresenter(context: Context) {
    private val view = context as CreateTaskView

    fun saveTask(editTaskDeadline : EditText, editTaskTitle : EditText){
        var success = true
        val title = editTaskTitle.text.toString().trim()
        val deadline = editTaskDeadline.text.toString().trim();

        if (title.isEmpty()){
            editTaskTitle.error = "Please enter task title"
            success = false
        }

        if (deadline.isEmpty()){
            editTaskDeadline.error = "Please enter task deadline"
            success = false

        }

        val ref = FirebaseDatabase.getInstance().getReference("tasks")
        val taskId = ref.push().key.toString()
        val task = Task(taskId, title, deadline)

        if (success){
            ref.child(taskId).setValue(task).addOnCompleteListener{
                view.onTaskCreationComplete(task)
            }
        }
        else {
            view.onTaskCreationError()
        }
    }
}