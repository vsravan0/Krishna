package com.test.krishna

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.krishna.data.db.entities.Comments

/*
RecycleView : Contains multiple Views / Items

How many Items ?
What is UI of each item ?
Reusable
Adapter :  RecyclerView.Adapter
 */
class CommentsAdapter(val mList: List<Comments>?) : RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {




    // Helps set the views to display
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("CommentsAdapter", "onCreateViewHolder");

        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        Log.d("CommentsAdapter", "getItemCount");
        return mList!!.size
    }
    // Bind the list views / items to our Widgets ( TextView)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("CommentsAdapter", "onBindViewHolder - "+position)

        holder.itemView.setOnClickListener {

     //   Log.d("CommentsAdapter", " Clicked position "+position);

            onClickListener?.onClick(position)
        }

        val comment : Comments = mList?.get(position) !!
        holder.title.text = "Email  " + comment.email
        holder.desc.text = "Name " + comment.name
        val image_url ="https://via.placeholder.com/150/d32776"
        Glide.with(holder.itemView.context).load(image_url).into(holder.imageView)
    }

    // Signle iteam/ View
    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val  title : TextView = itemView.findViewById(R.id.id_tv_title)
        val  desc : TextView = itemView.findViewById(R.id.id_tv_desc)
        val imageView : ImageView = itemView.findViewById(R.id.id_iv)
    }

    private var onClickListener : OnClickListener ? = null

    fun setOnClickListener(listener: OnClickListener) {
        this.onClickListener = listener
    }

    interface OnClickListener {
        fun onClick(position: Int)
    }


}