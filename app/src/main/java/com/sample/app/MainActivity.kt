package com.sample.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sample.app.api.MainApiActivity
import com.sample.app.firebase.tabs.TabsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabsExampleButton.setOnClickListener {
            startActivity(Intent(this, TabsActivity::class.java))
        }

    }
}
