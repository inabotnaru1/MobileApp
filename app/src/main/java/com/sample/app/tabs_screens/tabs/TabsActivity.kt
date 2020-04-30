package com.sample.app.tabs_screens.tabs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sample.app.R
import com.sample.app.create_task_screen.CreateTaskActivity
//import com.sample.app.extensions.setStatusBarColor
import com.sample.app.tabs_screens.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_tabs.*

class TabsActivity : AppCompatActivity() {

    private val pagerAdapter: ViewPagerAdapter =
        ViewPagerAdapter(this.supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)
        setSupportActionBar(toolbar)
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)

        createTaskButton.setOnClickListener {
            startActivity(Intent(this, CreateTaskActivity::class.java))
        }
    }
}
