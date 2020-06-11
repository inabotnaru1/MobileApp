package com.sample.app.create_task_screen

import android.content.Context
import android.widget.EditText
import com.google.firebase.database.FirebaseDatabase
import com.sample.app.model.Task
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CreateTaskPresenter(context: Context) {
    private val view = context as CreateTaskView

    fun saveTask(editTaskDeadline : EditText, editTaskTitle : EditText){
        val title = editTaskTitle.text.toString().trim()
        val deadline = editTaskDeadline.text.toString().trim();

        val success = checkData(title, deadline)

        if (!checkData(title, deadline)){
            editTaskTitle.error = "Incorrect Data"
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

    fun checkData(title: String, deadline: String): Boolean{

        if (title.isEmpty() || deadline.isEmpty() ){
           return false
        }
        return true
    }
}