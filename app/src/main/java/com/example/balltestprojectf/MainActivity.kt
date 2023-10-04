package com.example.balltestprojectf

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.balltestprojectf.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val redCircleAnimator = ObjectAnimator.ofFloat(
            binding.redCircle,
            "translationX",
            0f,
            resources.displayMetrics.widthPixels.toFloat()
        )
        redCircleAnimator.duration = 10000

        val blueSquareAnimator = ObjectAnimator.ofFloat(
            binding.blueSquare,
            "translationY",
            resources.displayMetrics.heightPixels.toFloat(),
            binding.blueSquare.height.toFloat()
        )
        blueSquareAnimator.duration = 10000

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(redCircleAnimator, blueSquareAnimator)

        binding.startButton.setOnClickListener {
            animatorSet.start()
        }
    }
}
