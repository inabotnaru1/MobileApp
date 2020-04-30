package com.sample.app.tabs_screens.tabs.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.sample.app.R
import com.sample.app.share_task_screen.ShareTaskActivity


class CommunityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_community, container, false)
        val myButton: Button = rootView.findViewById<View>(R.id.memberListButton) as Button
        myButton.setOnClickListener {
            startActivity(Intent(this.context, ShareTaskActivity::class.java))
        }
        return rootView
    }
}