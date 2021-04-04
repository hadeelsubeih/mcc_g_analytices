package com.example.googleanalytics.db

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.googleanalytics.R
import com.example.googleanalytics.detailes
import com.example.googleanalytics.model.head
import kotlinx.android.synthetic.main.menumwk.view.*

class Adapter (var activity: Activity, var data: MutableList<head>) :
    RecyclerView.Adapter<Adapter.MyViewHolderNew>() {

    class MyViewHolderNew(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Img : ImageView = itemView.img
        val Text = itemView.textView
        val Rat = itemView.rat
        val HH = itemView.hh


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderNew {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.menumwk, parent, false)
        return MyViewHolderNew(
            itemView
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolderNew, position: Int) {


        holder.Img.setImageResource(data[position].Item_img)
        holder.Text.text = data[position].nameOfitem
        holder.Rat.rating = data[position].Rating
        holder.HH.text = data[position].realNum.toString()
        holder.Img.setOnClickListener {
            val i = Intent(activity, detailes::class.java)
            i.putExtra("imgs", data[position].Item_img)
            i.putExtra("names", data[position].nameOfitem)
            i.putExtra("price", data[position].realNum)

            activity.startActivity(i)


        }


    }}
















