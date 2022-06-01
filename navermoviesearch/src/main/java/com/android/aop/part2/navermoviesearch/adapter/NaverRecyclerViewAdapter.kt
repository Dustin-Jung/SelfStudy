package com.android.aop.part2.navermoviesearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.aop.part2.navermoviesearch.api.Item
import com.android.aop.part2.navermoviesearch.databinding.NaverItemBinding

class NaverRecyclerViewAdapter : RecyclerView.Adapter<NaverViewHolder>() {

    private val itemList = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NaverViewHolder {
        val binding = NaverItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NaverViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NaverViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun addAll(list: List<Item>) {
        itemList.addAll(list)
        notifyDataSetChanged()
    }
}

class NaverViewHolder(private val binding: NaverItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item) {
        binding.item = item
    }
}
