package com.sample.app


import com.sample.app.create_task_screen.CreateTaskActivity
import com.sample.app.create_task_screen.CreateTaskPresenter
import com.sample.app.model.User
import com.sample.app.share_task_screen.ShareTaskActivity
import org.junit.Test
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ShareTaskTest {

    private var users = listOf(
    User(
        "Ina Botnaru",
        "inabotnaru1@gmail.com",
        "31 August 20/5",
        "10",
        "Chisinau",
        "999"
    ),
        User(
            "Iurie Melinte",
            "iuriemelinte@gmail.com",
            "Papustva Noua 28",
            "45",
            "Balti",
            "3228"
        )
    )


    @Test
    fun users_areValid() {
        val shareTaskActivity = ShareTaskActivity()
        val isValid = shareTaskActivity.isValidList(users)
        assertEquals(true, isValid)
    }

    @Test
    fun users_areNotValid() {
        val shareTaskActivity = ShareTaskActivity()
        users[1].email = ""
        val isValid = shareTaskActivity.isValidList(users)
        assertEquals(false, isValid)
    }

}
