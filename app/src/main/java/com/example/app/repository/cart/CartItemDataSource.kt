package com.example.app.repository.cart

import com.example.app.model.CartItem

interface CartItemDataSource {

    suspend fun addCartItem(cartItem: CartItem)
    suspend fun getCartItems(): List<CartItem>
}