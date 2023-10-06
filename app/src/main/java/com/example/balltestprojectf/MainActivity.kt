package com.example.balltestprojectf

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.balltestprojectf.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val animationInterval = 1000L
    private val totalDuration = 60000L
    private var remainingTime = totalDuration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countDownTimer = object : CountDownTimer(totalDuration, animationInterval) {
            override fun onTick(millisUntilFinished: Long) {
                remainingTime = millisUntilFinished
                updateTimerText()
                binding.customView.moveShapes()
            }

            override fun onFinish() {
                remainingTime = 0
                updateTimerText()
            }
        }
        countDownTimer.start()
    }

    private fun updateTimerText() {
        val minutes = (remainingTime / 1000) / 60
        val seconds = (remainingTime / 1000) % 60
        binding.timerTextView.text = "$minutes:${if (seconds < 10) "0" else ""}$seconds"
    }
}