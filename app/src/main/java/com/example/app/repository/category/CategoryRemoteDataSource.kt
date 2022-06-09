package com.example.app.repository.category

import com.example.app.model.Category
import com.example.app.network.ApiClient
import com.example.app.repository.category.CategoryDataSource

class CategoryRemoteDataSource(private val apiClient: ApiClient): CategoryDataSource {
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}