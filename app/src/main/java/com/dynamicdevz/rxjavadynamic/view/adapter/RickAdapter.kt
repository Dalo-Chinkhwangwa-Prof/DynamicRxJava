package com.dynamicdevz.rxjavadynamic.view.adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ablanco.zoomy.Zoomy
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dynamicdevz.rxjavadynamic.databinding.GridItemLayoutBinding
import com.dynamicdevz.rxjavadynamic.databinding.ListItemLayoutBinding
import com.dynamicdevz.rxjavadynamic.model.data.Result
import com.dynamicdevz.rxjavadynamic.util.ViewType

class RickAdapter(private val vType: ViewType, private val delegate: RickDelegate) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface RickDelegate{
        fun selectCharacter(result: Result)
    }

    inner class GridViewHolder(val binding: GridItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class ListViewHolder(val binding: ListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    var listResults = listOf<Result>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (vType == ViewType.LIST) {
            ListViewHolder(
                ListItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else
            GridViewHolder(
                GridItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val result = listResults[position]
        val zBuilder = Zoomy.Builder(holder.itemView.context as Activity)



        if(holder is GridViewHolder){
            holder.binding.name.setOnClickListener {
                delegate.selectCharacter(result)
                Log.d("TAG_X", "clicked....")
            }

            Glide.with(holder.itemView)
                .applyDefaultRequestOptions(RequestOptions().centerCrop())
                .load(result.image)
                .into(holder.binding.imageView)
            holder.binding.name.text = result.name

            zBuilder.target(holder.binding.imageView)

        } else if(holder is ListViewHolder){
            holder.binding.name.setOnClickListener {
                delegate.selectCharacter(result)
                Log.d("TAG_X", "clicked....")
            }

            Glide.with(holder.itemView)
                .applyDefaultRequestOptions(RequestOptions().centerCrop())
                .load(result.image)
                .into(holder.binding.imageView)
            holder.binding.name.text = result.name

            zBuilder.target(holder.binding.imageView)
        }

        zBuilder.register()

    }

    override fun getItemCount(): Int = listResults.size

}