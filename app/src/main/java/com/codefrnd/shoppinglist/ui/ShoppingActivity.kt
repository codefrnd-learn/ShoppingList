package com.codefrnd.shoppinglist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.codefrnd.shoppinglist.R
import com.codefrnd.shoppinglist.adapter.ShoppingItemAdapter
import com.codefrnd.shoppinglist.data.db.ShoppingDatabase
import com.codefrnd.shoppinglist.data.db.entites.ShoppingItem
import com.codefrnd.shoppinglist.repositories.ShoppingRepository
import com.codefrnd.shoppinglist.ui.shoppinglist.AddDialogListener
import com.codefrnd.shoppinglist.ui.shoppinglist.AddShoppingItemDialog
import com.codefrnd.shoppinglist.ui.shoppinglist.ShoppingViewModel
import com.codefrnd.shoppinglist.ui.shoppinglist.ShoppingViewModelFactory
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ShoppingActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: ShoppingViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        /**
         * DO NOT INSTANTIATE
         * IT MAKES IT DEPENDENT ON ACTIVITY
         */

        val viewModel = ViewModelProviders.of(this, factory)[ShoppingViewModel::class.java]

        val adapter = ShoppingItemAdapter(listOf(), viewModel)
        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingItemDialog(this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewModel.upsertItem(item)
                    }
                }
            ).show()
        }
    }
}