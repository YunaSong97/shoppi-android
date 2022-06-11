package com.example.app.repository.productdeatil

import com.example.app.model.Product
import com.example.app.model.ProductDetail

class ProductDetailRepository(
    private val remoteDataSource: ProductDetailRemoteDataSource
){
    suspend fun getProductDetail(productId : String): Product {
        return remoteDataSource.getProductDetail(productId)
    }
}