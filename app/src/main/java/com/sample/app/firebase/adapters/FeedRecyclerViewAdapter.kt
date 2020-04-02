package com.sample.app.firebase.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.R
import com.sample.app.firebase.models.Feed
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.feed_item.view.*

class FeedRecyclerViewAdapter(
    context: Context,
    private val feeds: MutableList<Feed>
) : RecyclerView.Adapter<FeedRecyclerViewAdapter.FeedItemViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedItemViewHolder {
        // create a new view
        val view = layoutInflater.inflate(R.layout.feed_item, parent, false)
        // set the view's size, margins, paddings and layout parameters

        return FeedItemViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: FeedItemViewHolder, position: Int) {
        val feed = feeds[position]
        holder.bind(feed)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = feeds.size

    inner class FeedItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val titleTxtView: TextView = view.titleTxtView
        private val deadlineTxtView: TextView = view.deadlineTxtView
//        private val avatarImgView: ImageView = view.avatarImgView

        fun bind(feed: Feed) {
            titleTxtView.text = feed.title
            deadlineTxtView.text = feed.deadline
            Picasso
                .get()
        }
    }
}
