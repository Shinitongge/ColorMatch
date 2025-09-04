package com.colormatch.app.data.model

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class ClothingItem(
    val id: String = UUID.randomUUID().toString(),
    val imagePath: String,
    val category: ClothingCategory,
    val colors: List<ColorAnalysis>,
    val createdAt: Long = System.currentTimeMillis()
) : Parcelable

@Parcelize
enum class ClothingCategory(val displayName: String) : Parcelable {
    TOP("上衣"),
    BOTTOM("裤子"),
    OUTERWEAR("外套"),
    SHOES("鞋子"),
    HAT("帽子"),
    ACCESSORY("配饰"),
    DRESS("连衣裙")
}

@Parcelize
data class ColorAnalysis(
    val color: Int,
    val percentage: Float,
    val colorName: String
) : Parcelable