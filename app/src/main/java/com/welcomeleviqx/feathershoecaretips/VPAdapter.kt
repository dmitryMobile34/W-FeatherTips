package com.welcomeleviqx.feathershoecaretips

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.welcomeleviqx.feathershoecaretips.databinding.RawVpItemBinding


class ViewPagerAdapter(items: List<String>): RecyclerView.Adapter<PagerVH>() {

    private var listItems = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        val binding = RawVpItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerVH(binding)
    }

    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {

        holder.binding.mainText.text = listItems[position]

    }

    override fun getItemCount(): Int = listItems.size

}

class PagerVH(val binding: RawVpItemBinding) : RecyclerView.ViewHolder(binding.root)