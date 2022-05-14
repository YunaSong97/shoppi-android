package com.example.app.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.app.GlideApp

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?){
    if(!imageUrl.isNullOrEmpty()){
        GlideApp.with(view)
            .load(imageUrl)
            .into(view)
    }
}