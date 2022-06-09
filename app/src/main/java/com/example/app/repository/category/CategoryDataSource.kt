package com.example.app.repository.category

import com.example.app.model.Category

interface CategoryDataSource {

    suspend fun getCategories(): List<Category>
}