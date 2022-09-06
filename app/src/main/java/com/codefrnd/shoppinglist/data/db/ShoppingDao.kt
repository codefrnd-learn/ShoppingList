package com.codefrnd.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codefrnd.shoppinglist.data.db.entites.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun deleteItem(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItem() : LiveData<List<ShoppingItem>>
}