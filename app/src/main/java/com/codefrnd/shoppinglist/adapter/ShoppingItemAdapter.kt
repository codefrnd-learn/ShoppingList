package com.codefrnd.shoppinglist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codefrnd.shoppinglist.R
import com.codefrnd.shoppinglist.data.db.entites.ShoppingItem
import com.codefrnd.shoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(v)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currShoppingItem = items[position]

        holder.itemView.tvName.text = currShoppingItem.name
        holder.itemView.tvAmount.text = "${currShoppingItem.amount}"

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.deleteItem(currShoppingItem)
        }

        holder.itemView.ivPlus.setOnClickListener {
            currShoppingItem.amount++
            viewModel.upsertItem(currShoppingItem)
        }

        holder.itemView.ivMinus.setOnClickListener {
            if (currShoppingItem.amount > 0)
                currShoppingItem.amount--
            viewModel.upsertItem(currShoppingItem)
        }
    }

    override fun getItemCount(): Int = items.size

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}