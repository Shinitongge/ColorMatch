package com.colormatch.app.utils

import android.graphics.Bitmap
import android.graphics.Color
import androidx.palette.graphics.Palette
import com.colormatch.app.data.model.ColorAnalysis
import kotlin.math.sqrt

object ColorAnalyzer {
    
    fun extractColors(bitmap: Bitmap): List<ColorAnalysis> {
        val palette = Palette.from(bitmap).generate()
        val colorList = mutableListOf<ColorAnalysis>()
        
        // 提取主要颜色
        palette.dominantSwatch?.let { swatch ->
            colorList.add(
                ColorAnalysis(
                    color = swatch.rgb,
                    percentage = 0.4f,
                    colorName = getColorName(swatch.rgb)
                )
            )
        }
        
        // 提取其他显著颜色
        palette.swatches.forEach { swatch ->
            if (swatch != palette.dominantSwatch) {
                colorList.add(
                    ColorAnalysis(
                        color = swatch.rgb,
                        percentage = swatch.population.toFloat() / getTotalPixels(palette),
                        colorName = getColorName(swatch.rgb)
                    )
                )
            }
        }
        
        return colorList.take(5) // 返回前5种主要颜色
    }
    
    private fun getTotalPixels(palette: Palette): Float {
        return palette.swatches.sumOf { it.population }.toFloat()
    }
    
    private fun getColorName(color: Int): String {
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)
        
        return when {
            isGray(red, green, blue) -> when {
                red < 80 -> "黑色"
                red > 200 -> "白色"
                else -> "灰色"
            }
            red > green && red > blue -> when {
                red > 200 && green < 100 && blue < 100 -> "红色"
                red > 150 && green > 100 && blue < 100 -> "橙色"
                else -> "红色系"
            }
            green > red && green > blue -> when {
                green > 200 && red < 100 && blue < 100 -> "绿色"
                green > 150 && red > 100 && blue < 100 -> "黄绿色"
                else -> "绿色系"
            }
            blue > red && blue > green -> when {
                blue > 200 && red < 100 && green < 100 -> "蓝色"
                blue > 150 && red > 100 && green < 100 -> "紫色"
                else -> "蓝色系"
            }
            red > 150 && green > 150 && blue < 100 -> "黄色"
            red > 150 && green < 100 && blue > 150 -> "紫红色"
            green > 150 && blue > 150 && red < 100 -> "青色"
            else -> "混合色"
        }
    }
    
    private fun isGray(red: Int, green: Int, blue: Int): Boolean {
        val maxDiff = maxOf(
            kotlin.math.abs(red - green),
            kotlin.math.abs(green - blue),
            kotlin.math.abs(blue - red)
        )
        return maxDiff < 30
    }
}