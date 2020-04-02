package com.sample.app.firebase

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.sample.app.R
import com.sample.app.firebase.models.Feed
import com.sample.app.firebase.tabs.TabsActivity


import kotlinx.android.synthetic.main.activity_task_creation.*
import kotlinx.android.synthetic.main.content_task_creation.*

class TaskCreation : AppCompatActivity() {

    lateinit var editTaskTitle : EditText
    lateinit var editTaskDeadline : EditText
    var success = true;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_creation)
        setSupportActionBar(toolbar)


        editTaskTitle = findViewById(R.id.taskTitle)
        editTaskDeadline = findViewById(R.id.taskDeadline)


        addTaskButton.setOnClickListener{
            saveTask()
            if (success){
                startActivity(Intent(this, TabsActivity::class.java))
            }
        }
    }

    private fun saveTask(){
    val title = editTaskTitle.text.toString().trim()
    val deadline = editTaskDeadline.text.toString().trim();

    if (title.isEmpty()){
        editTaskTitle.error = "Please enter task title"
        success = false
        return
    }

    if (deadline.isEmpty()){
        editTaskDeadline.error = "Please enter task deadline"
        success = false
        return
    }


    val ref = FirebaseDatabase.getInstance().getReference("tasks")

    val taskId = ref.push().key.toString()

    val task = Feed(taskId, title, deadline)

    ref.child(taskId).setValue(task).addOnCompleteListener{
        Toast.makeText(applicationContext, "Task Created", Toast.LENGTH_LONG).show()
        }
    }

}

