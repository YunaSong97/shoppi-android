package com.example.app.repository

import com.example.app.model.Category

interface CategoryDataSource {

    suspend fun getCategories(): List<Category>
}