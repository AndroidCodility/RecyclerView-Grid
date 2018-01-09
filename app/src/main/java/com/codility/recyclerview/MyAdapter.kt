package com.codility.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Govind on 01/09/2018.
 */
class MyAdapter(private val userList: ArrayList<User>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.list_item, parent, false))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(user: User) {
            val tvName = itemView.findViewById<TextView>(R.id.tvName)
            val tvAddress = itemView.findViewById<TextView>(R.id.tvAddress)
            tvName.text = user.name;
            tvAddress.text = user.address
        }
    }
}