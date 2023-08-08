package com.example.restcountriesproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.content.res.Configuration
import android.view.View
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
        val intent = Intent(this,SecondActivity::class.java)
        setContentView(binding.root)

        textViewBlink()

        openNewActivityOnButtonClick(intent)
    }

    private fun openNewActivityOnButtonClick(intent : Intent) {
        binding.mainLayout.setOnClickListener{
            startActivity(intent)
        }
    }

    private fun textViewBlink() {
        val anim = AnimationUtils.loadAnimation(applicationContext, R.anim.blink)
        binding.clickAnywhereTextView.startAnimation(anim)
    }

}