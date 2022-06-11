package com.example.app

import android.content.Context
import androidx.room.Room
import com.example.app.database.AppDatabase
import com.example.app.network.ApiClient
import com.example.app.repository.cart.CartItemLocalDataSource
import com.example.app.repository.cart.CartRepository

object ServiceLocator {
    private var apiClient: ApiClient? = null
    private var database: AppDatabase? = null
    private var cartRepository: CartRepository? = null

    fun provideApiClient(): ApiClient {
        return apiClient ?: kotlin.run {
            ApiClient.create().also {
                apiClient = it
            }
        }
    }

    private fun provideDatabase(applicaContext: Context): AppDatabase {
        return database ?: kotlin.run {
            Room.databaseBuilder(
                applicaContext,
                AppDatabase::class.java,
                "shoppi-local"
            ).build().also {
                database = it
            }
        }
    }

    fun provideCartRepository(context: Context): CartRepository{
        return cartRepository ?: kotlin.run {
            val dao = provideDatabase(context.applicationContext).cartItemDao()
            CartRepository(CartItemLocalDataSource(dao)).also {
                cartRepository = it
            }
        }
    }
}