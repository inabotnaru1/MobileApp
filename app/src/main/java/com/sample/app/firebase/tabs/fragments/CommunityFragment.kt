package com.sample.app.firebase.tabs.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.sample.app.R
import com.sample.app.api.MainApiActivity
import com.sample.app.firebase.tabs.TabsActivity
import kotlinx.android.synthetic.main.activity_main.*


class CommunityFragment : Fragment() {

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_community, container, false)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_community, container, false)
        // Inflate the layout for this fragment
        val myButton: Button = rootView.findViewById<View>(R.id.memberListButton) as Button
        myButton.setOnClickListener {
            startActivity(Intent(this.context, MainApiActivity::class.java))
        }
        return rootView
    }
}