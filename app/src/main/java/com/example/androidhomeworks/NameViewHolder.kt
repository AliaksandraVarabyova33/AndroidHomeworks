package com.example.androidhomeworks

import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomeworks.databinding.ItemNameBinding

class NameViewHolder(private val binding: ItemNameBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(text: String) {
        binding.textView.text = text
    }
}