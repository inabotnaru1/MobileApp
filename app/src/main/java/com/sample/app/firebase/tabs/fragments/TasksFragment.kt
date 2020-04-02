package com.sample.app.firebase.tabs.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.sample.app.R
import com.sample.app.firebase.adapters.FeedRecyclerViewAdapter
import com.sample.app.firebase.models.Feed
import kotlinx.android.synthetic.main.fragment_tasks.view.*

class TasksFragment: Fragment() {

    private lateinit var adapter: FeedRecyclerViewAdapter
    lateinit var ref : DatabaseReference
    lateinit var taskList : MutableList<Feed>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_tasks, container, false)

        view.apply {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }



        return view
    }

    override fun onAttach(context: Context) {

        super.onAttach(context)
        initViews(context)


    }

    private fun initViews(context: Context) {
        taskList = mutableListOf();

        ref = FirebaseDatabase.getInstance().getReference("tasks")

        ref.addValueEventListener(object :ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()) {
                    for (t in p0.children){
                        val task = t.getValue(Feed::class.java)

                        taskList.add(task!!)
                    }

                   adapter.notifyDataSetChanged()
                }
            }
        })
//        taskList;
        adapter = FeedRecyclerViewAdapter(context, taskList)
    }

}



