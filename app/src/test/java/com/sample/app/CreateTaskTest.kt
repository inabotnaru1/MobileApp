package com.sample.app


import com.sample.app.create_task_screen.CreateTaskActivity
import com.sample.app.create_task_screen.CreateTaskPresenter
import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CreateTaskTest {

    @Test
    fun task_isValid() {
        val createTaskActivity = CreateTaskActivity()
        val context = createTaskActivity.classContext
        val createTaskPresenter = CreateTaskPresenter(context)
        val isDataValid = createTaskPresenter.checkData("Eating Hamburger", "14.02.2019")
        assertEquals(true, isDataValid)
    }

    @Test
    fun title_isEmpty() {
        val createTaskActivity = CreateTaskActivity()
        val context = createTaskActivity.classContext
        val createTaskPresenter = CreateTaskPresenter(context)
        val isTitleValid = createTaskPresenter.checkData("", "14.02.2019")
        assertEquals(false, isTitleValid)
    }

    @Test
    fun deadline_isEmpty() {
        val createTaskActivity = CreateTaskActivity()
        val context = createTaskActivity.classContext
        val createTaskPresenter = CreateTaskPresenter(context)
        val isDeadlineValid = createTaskPresenter.checkData("Bring Clothes", "")
        assertEquals(false, isDeadlineValid)
    }

    @Test
    fun task_isInvalid() {
        val createTaskActivity = CreateTaskActivity()
        val context = createTaskActivity.classContext
        val createTaskPresenter = CreateTaskPresenter(context)
        val isDataValid = createTaskPresenter.checkData("", "")
        assertEquals(false, isDataValid)
    }

}
