package eu.example.mywishlistapp

import android.content.Context
import androidx.room.Room
import eu.example.mywishlistapp.Data.WishDatabase
import eu.example.mywishlistapp.Data.WishRepository

object Graph {
    lateinit var database: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context,
            WishDatabase::class.java,"wishlist.dp").build()
    }
}