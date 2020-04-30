package com.sample.app.tabs_screens.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.R
import com.sample.app.model.Task
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedRecyclerViewAdapter(
    context: Context,
    private val tasks: MutableList<Task>
) : RecyclerView.Adapter<FeedRecyclerViewAdapter.FeedItemViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedItemViewHolder {
        val view = layoutInflater.inflate(R.layout.feed_item, parent, false)
        return FeedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedItemViewHolder, position: Int) {
        val feed = tasks[position]
        holder.bind(feed)
    }

    override fun getItemCount() = tasks.size

    inner class FeedItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val titleTxtView: TextView = view.titleTxtView
        private val deadlineTxtView: TextView = view.deadlineTxtView

        fun bind(task: Task) {
            titleTxtView.text = task.title
            deadlineTxtView.text = task.deadline
            Picasso
                .get()
        }
    }
}
