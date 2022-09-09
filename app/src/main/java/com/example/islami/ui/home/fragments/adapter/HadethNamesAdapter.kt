package com.example.islami.ui.home.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R


class HadethNamesAdapter(val items  :List<String>) :RecyclerView.Adapter<HadethNamesAdapter.ViewHolder> (){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hadeth_name,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hadethName =items.get(position)
        holder.name.setText(hadethName)
        if(onHadethClickListener!=null){
            holder.itemView.setOnClickListener{
                onHadethClickListener?.onHadethClick(position,hadethName)
            }
        }
    }

    override fun getItemCount(): Int   = items.size

    var onHadethClickListener:OnHadethClickListener? =null

    interface OnHadethClickListener{
        fun onHadethClick(pos: Int,name:String)

    }


    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val name :TextView = itemView.findViewById(R.id.hadeth_name)
    }
}


