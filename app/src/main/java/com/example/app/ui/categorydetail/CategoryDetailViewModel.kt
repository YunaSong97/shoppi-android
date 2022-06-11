package com.example.app.ui.categorydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.model.Product
import com.example.app.model.Promotion
import com.example.app.model.TopSelling
import com.example.app.repository.cart.CartRepository
import com.example.app.repository.categorydetail.CategoryDetailRepository
import com.example.app.ui.common.Event
import kotlinx.coroutines.launch
import java.security.PrivateKey

class CategoryDetailViewModel(
    private val categoryDetailRepository: CategoryDetailRepository,
): ViewModel() {

    private val _topSelling = MutableLiveData<TopSelling>()
    val topSelling : LiveData<TopSelling> = _topSelling

    private val _promotions = MutableLiveData<Promotion>()
    val promotions : LiveData<Promotion> = _promotions


    init {
        loadCategoryDetail()
    }

    private fun loadCategoryDetail() {
        viewModelScope.launch {
            val categoryDetail = categoryDetailRepository.getCategoryDetail()
            _topSelling.value = categoryDetail.topSelling
            _promotions.value = categoryDetail.promotions
        }
    }
}