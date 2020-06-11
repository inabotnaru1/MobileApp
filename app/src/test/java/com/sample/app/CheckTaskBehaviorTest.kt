package com.sample.app


import com.sample.app.create_task_screen.CreateTaskActivity
import com.sample.app.create_task_screen.CreateTaskPresenter
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


class CheckTaskBehaviorTest {


    @Test
    fun task_isValid() {
        val createTaskActivity = CreateTaskActivity()
        val context = createTaskActivity.classContext
        val createTaskPresenter = CreateTaskPresenter(context)
        val isDataValid = createTaskPresenter.checkData("Eating Hamburger", "14.02.2019")
        assertEquals(true, isDataValid)
    }



}
