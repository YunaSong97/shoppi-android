package com.example.app.repository.category

import com.example.app.model.Category

class CategoryRepository(
    private val remoteDataSource: CategoryRemoteDataSource
) {
    suspend fun getCategories(): List<Category>{
        return remoteDataSource.getCategories()
    }
}