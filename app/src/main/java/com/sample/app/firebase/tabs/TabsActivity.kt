package com.sample.app.firebase.tabs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sample.app.R
import com.sample.app.firebase.TaskCreation
//import com.sample.app.extensions.setStatusBarColor
import com.sample.app.firebase.tabs.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_tabs.*

class TabsActivity : AppCompatActivity() {

    private val pagerAdapter: ViewPagerAdapter = ViewPagerAdapter(this.supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)
        setSupportActionBar(toolbar)
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)

        createTaskButton.setOnClickListener {
            startActivity(Intent(this, TaskCreation::class.java))
        }
    }
}
