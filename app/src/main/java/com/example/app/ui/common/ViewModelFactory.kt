package com.example.app.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app.AssetLoader
import com.example.app.network.ApiClient
import com.example.app.repository.category.CategoryRemoteDataSource
import com.example.app.repository.category.CategoryRepository
import com.example.app.repository.categorydetail.CategoryDetailRemoteDataSource
import com.example.app.repository.categorydetail.CategoryDetailRepository
import com.example.app.repository.home.HomeAssetDataSource
import com.example.app.repository.home.HomeRepository
import com.example.app.ui.category.CategoryViewModel
import com.example.app.ui.categorydetail.CategoryDetailViewModel
import com.example.app.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository = CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))
                CategoryViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryDetailViewModel::class.java) -> {
                val repository = CategoryDetailRepository(CategoryDetailRemoteDataSource(ApiClient.create()))
                CategoryDetailViewModel(repository) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}