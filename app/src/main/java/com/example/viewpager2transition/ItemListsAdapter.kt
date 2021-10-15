package com.example.viewpager2transition

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2transition.databinding.ShoppingItemBinding
import com.example.viewpager2transition.models.ShoppingItem

class ItemListsAdapter:RecyclerView.Adapter<ItemListsAdapter.ShoppingItemViewHolder>() {


    private val diffcallback=object :DiffUtil.ItemCallback<ShoppingItem>(){

        override fun areItemsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
            return oldItem.item_photo_resource==newItem.item_photo_resource
        }

        override fun areContentsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
            return oldItem.hashCode()==newItem.hashCode()
        }
    }

    val differ=AsyncListDiffer(this,diffcallback)

    var data:List<ShoppingItem>
    get() = differ.currentList
    set(value) = differ.submitList(value)



    inner  class ShoppingItemViewHolder(val binding:ShoppingItemBinding):RecyclerView.ViewHolder(binding.root){


        fun bind(item:ShoppingItem){

            binding.itemShoppingPhoto.setImageResource(item.item_photo_resource)
            binding.shoppingItemName.text=item.item_name
            binding.shoppingItemPrice.text=item.item_price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
       val binding=ShoppingItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ShoppingItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {

        val item=data[position]

        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return data.size
    }
}