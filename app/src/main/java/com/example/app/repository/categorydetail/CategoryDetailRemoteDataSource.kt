package com.example.app.repository.categorydetail

import com.example.app.model.CategoryDetail
import com.example.app.network.ApiClient

class CategoryDetailRemoteDataSource(private val api: ApiClient): CategoryDetailDataSource {
    override suspend fun getCategoryDetail(): CategoryDetail {
        return api.getCategoryDetail()
    }
}