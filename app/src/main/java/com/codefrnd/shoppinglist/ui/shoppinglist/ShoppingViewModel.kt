package com.codefrnd.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codefrnd.shoppinglist.data.db.entites.ShoppingItem
import com.codefrnd.shoppinglist.repositories.ShoppingRepository
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {

    fun upsertItem(item: ShoppingItem) = viewModelScope.launch {
        repository.upsertItem(item)
    }

    fun deleteItem(item: ShoppingItem) = viewModelScope.launch {
        repository.deleteItem(item)
    }

    fun getAllShoppingItems() = repository.getAllItem()
}