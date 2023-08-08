package com.example.restcountriesproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.example.restcountriesproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textViewBlink()

    }

    private fun textViewBlink() {
        val anim = AnimationUtils.loadAnimation(applicationContext, R.anim.blink)
        binding.clickAnywhereTextView.startAnimation(anim)
    }

}