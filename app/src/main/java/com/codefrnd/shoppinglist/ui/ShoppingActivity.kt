package com.codefrnd.shoppinglist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.codefrnd.shoppinglist.R
import com.codefrnd.shoppinglist.data.db.ShoppingDatabase
import com.codefrnd.shoppinglist.repositories.ShoppingRepository
import com.codefrnd.shoppinglist.ui.shoppinglist.ShoppingViewModel
import com.codefrnd.shoppinglist.ui.shoppinglist.ShoppingViewModelFactory

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        /**
         * DO NOT INSTANTIATE
         * IT MAKES IT DEPENDENT ON ACTIVITY
         */

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory)[ShoppingViewModel::class.java]
    }
}