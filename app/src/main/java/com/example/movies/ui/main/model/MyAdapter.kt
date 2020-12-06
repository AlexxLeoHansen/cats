package com.example.movies.ui.main.model

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter constructor(private val mDataList: List<Movie>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}