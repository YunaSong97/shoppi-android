package com.example.app.repository

import com.example.app.model.HomeData

interface HomeDataSource {

    fun getHomeData(): HomeData?
}