package com.codefrnd.shoppinglist.repositories

import com.codefrnd.shoppinglist.data.db.ShoppingDatabase
import com.codefrnd.shoppinglist.data.db.entites.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsertItem(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun deleteItem(item: ShoppingItem) = db.getShoppingDao().deleteItem(item)

    fun getAllItem() = db.getShoppingDao().getAllShoppingItem()
}