package com.example.androidhomeworks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomeworks.databinding.ItemNameBinding

class NameRecyclerViewAdapter(private val list: MutableList<String>) :
    RecyclerView.Adapter<NameViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val binding = ItemNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NameViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    fun addItem(name: String) {
        list.add(name)
        notifyItemInserted(list.size - 1)
    }

    fun setData(newList: List<String>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}