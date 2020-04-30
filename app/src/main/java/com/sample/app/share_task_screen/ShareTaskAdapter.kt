package com.sample.app.share_task_screen

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.R
import com.sample.app.model.User
import kotlinx.android.synthetic.main.data_row.view.*

class ShareTaskAdapter (private val data: List<User>):RecyclerView.Adapter<ShareTaskAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.name
        val email: TextView = itemView.email
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pieceOfData = data[position]
        d("Bla","bla? ${pieceOfData.name}")
        d("Blabla","blabla? ${pieceOfData.email}")
        holder.name.text = pieceOfData.name
        holder.email.text = pieceOfData.email
    }

}