package com.gukunov.testburg.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gukunov.testburg.databinding.RwItemBinding
import com.gukunov.testburg.domain.entity.BurgerItem

class FoodListAdapter : RecyclerView.Adapter<FoodListAdapter.FoodListViewHolder>() {

    private val differ = AsyncListDiffer(this, diffCallback)


    fun setData(items: List<BurgerItem>) {
        differ.submitList(items)
    }



    inner class FoodListViewHolder(private val binding: RwItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel: BurgerItem) {
            binding.textView2.text = viewModel.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RwItemBinding.inflate(inflater, parent, false)
        return FoodListViewHolder(binding)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: FoodListViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<BurgerItem>() {
            override fun areItemsTheSame(oldItem: BurgerItem, newItem: BurgerItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: BurgerItem, newItem: BurgerItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}