package com.example.app.repository.productdeatil

import com.example.app.model.Product

interface ProductDetailDataSource {
    suspend fun getProductDetail(productId: String): Product
}