package com.example.app.repository.productdeatil

import com.example.app.model.Product
import com.example.app.network.ApiClient

class ProductDetailRemoteDataSource(private val api: ApiClient) : ProductDetailDataSource {
    override suspend fun getProductDetail(productId : String): Product {
        return api.getProductDetail(productId)
    }
}