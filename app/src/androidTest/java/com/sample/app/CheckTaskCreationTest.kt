package com.sample.app

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sample.app.create_task_screen.CreateTaskActivity

import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CheckTaskCreationTest {
    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun onLaunchCheckButtonIsDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.tabsExampleButton))
            .check(matches(isDisplayed()))

    }

    @Test
    fun onTaskCreation() {
        ActivityScenario.launch(CreateTaskActivity::class.java)

        onView(withId(R.id.taskDeadline))
            .perform(typeText("12.02.2010"),
        ViewActions.closeSoftKeyboard())


        onView(withId(R.id.taskTitle))
            .perform(typeText("Buy Carrots"),
                ViewActions.closeSoftKeyboard())

        onView(withId(R.id.addTaskButton))
            .perform(click())

    }
}
