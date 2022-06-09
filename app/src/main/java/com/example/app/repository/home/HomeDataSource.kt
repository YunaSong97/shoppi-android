package com.example.app.repository.home

import com.example.app.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}