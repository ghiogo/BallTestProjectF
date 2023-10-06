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

        canvas?.drawColor(Color.WHITE)
        canvas?.drawCircle(redCircleX, height / 2f, width / 20f, redPaint)
        val squareSize = width / 5f
        canvas?.drawRect(0f, blueSquareY, squareSize, blueSquareY + squareSize, bluePaint)
    }

    fun moveShapes() {
        redCircleX += width / 40f
        if (redCircleX > width) {
            redCircleX = 0f
        }
        blueSquareY += height / 40f
        if (blueSquareY > height) {
            blueSquareY = 0f
        }
        invalidate()
    }
}