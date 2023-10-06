package com.example.balltestprojectf

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val redPaint = Paint()
    private val bluePaint = Paint()
    private var redCircleX = 0f
    private var blueSquareY = 0f

    init {
        redPaint.color = Color.RED
        bluePaint.color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Закрашиваем фон чёрным цветом
        canvas?.drawColor(Color.WHITE)

        // Рисуем красный круг
        canvas?.drawCircle(redCircleX, height / 2f, width / 20f, redPaint)

        // Рисуем синий квадрат
        val squareSize = width / 5f
        canvas?.drawRect(0f, blueSquareY, squareSize, blueSquareY + squareSize, bluePaint)
    }

    fun moveShapes() {
        // Анимация красного круга (слева направо)
        redCircleX += width / 40f
        if (redCircleX > width) {
            redCircleX = 0f
        }

        // Анимация синего квадрата (сверху вниз)
        blueSquareY += height / 40f
        if (blueSquareY > height) {
            blueSquareY = 0f
        }

        // Перерисовываем экран
        invalidate()
    }

    fun clearScreen() {
        redCircleX = 0f // Сбрасываем положение красного круга
        blueSquareY = 0f // Сбрасываем положение синего квадрата
        invalidate() // Перерисовываем экран
    }
}