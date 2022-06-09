package com.example.app.repository.categorydetail

import com.example.app.model.CategoryDetail

interface CategoryDetailDataSource {

    suspend fun getCategoryDetail(): CategoryDetail
}