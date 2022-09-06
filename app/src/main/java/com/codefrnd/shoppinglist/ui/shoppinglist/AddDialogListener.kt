package com.codefrnd.shoppinglist.ui.shoppinglist

import com.codefrnd.shoppinglist.data.db.entites.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}