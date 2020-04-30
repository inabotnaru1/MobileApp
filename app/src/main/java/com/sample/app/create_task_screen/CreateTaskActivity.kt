package com.sample.app.create_task_screen

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sample.app.R
import com.sample.app.model.Task
import com.sample.app.tabs_screens.tabs.TabsActivity


import kotlinx.android.synthetic.main.activity_task_creation.*
import kotlinx.android.synthetic.main.content_task_creation.*

class CreateTaskActivity : AppCompatActivity() ,
    CreateTaskView {

    lateinit var editTaskTitle : EditText
    lateinit var editTaskDeadline : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_creation)
        setSupportActionBar(toolbar)


        editTaskTitle = findViewById(R.id.taskTitle)
        editTaskDeadline = findViewById(R.id.taskDeadline)


        addTaskButton.setOnClickListener{
            CreateTaskPresenter(this)
                .saveTask(editTaskDeadline, editTaskTitle)
        }
    }

    override fun onTaskCreationComplete(task: Task) {
        startActivity(Intent(this, TabsActivity::class.java))
        Toast.makeText(applicationContext, "Task Created", Toast.LENGTH_LONG).show()
    }

    override fun onTaskCreationError() {
        Toast.makeText(applicationContext, "Task Wasn't Created", Toast.LENGTH_LONG).show()
    }

}

