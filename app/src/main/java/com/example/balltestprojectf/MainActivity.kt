package com.example.balltestprojectf

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.balltestprojectf.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var timerTextView: TextView
    private lateinit var customView: CustomView
    private val animationInterval = 1000L // Интервал для анимации (1 секунда)
    private val totalDuration = 60000L // Общая продолжительность таймера (1 минута)
    private var remainingTime = totalDuration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerTextView = findViewById(R.id.timerTextView)
        customView = findViewById(R.id.customView)

        // Создаем и запускаем таймер
        val countDownTimer = object : CountDownTimer(totalDuration, animationInterval) {
            override fun onTick(millisUntilFinished: Long) {
                remainingTime = millisUntilFinished
                updateTimerText()
                customView.moveShapes()
            }

            override fun onFinish() {
                remainingTime = 0
                updateTimerText()
                // Действия, которые нужно выполнить после завершения таймера
            }
        }

        countDownTimer.start()
    }

    private fun updateTimerText() {
        val minutes = (remainingTime / 1000) / 60
        val seconds = (remainingTime / 1000) % 60
        timerTextView.text = String.format("%d:%02d", minutes, seconds)
    }
}