package com.example.app.repository.categorydetail

import com.example.app.model.CategoryDetail

class CategoryDetailRepository(
    private val remoteDataSource: CategoryDetailRemoteDataSource
) {
    suspend fun getCategoryDetail(): CategoryDetail{
        return remoteDataSource.getCategoryDetail()
    }
}