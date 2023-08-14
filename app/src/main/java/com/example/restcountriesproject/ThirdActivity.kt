package com.example.restcountriesproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.restcountriesproject.data_package.RefurbishedCountry
import com.example.restcountriesproject.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityThirdBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        var countryObject = RefurbishedCountry(
            intent.getStringExtra("commonNameKey").toString(),
            intent.getStringExtra("officialNameKey").toString(),
            intent.getStringExtra("capitalKey").toString(),
            intent.getFloatExtra("areaKey",0.0f),
            intent.getStringExtra("flagAltKey").toString()
        )
        binding.countryVariable = countryObject

//        kazkas = intent.getStringExtra("flagPngKey").toString()
//        binding.commonNameTextViewId.text = intent.getStringExtra("commonNameKey")
//        binding.commonNameTextViewId.setText(intent.getStringExtra("commonNameKey"))
//        binding.officialNameTextViewId.text = intent.getStringExtra("officialNameKey")
//        binding.areaTextViewId.text = intent.getFloatExtra("areaKey",0.0f).toString()
//        binding.capitalTextViewId.text = intent.getStringExtra("capitalKey")
//        binding.flagAltTextViewId.text = intent.getStringExtra("officialNameKey")
        val image : ImageView = findViewById(R.id.imageViewThirdLayuout)

        Log.i("RESPONSE1000", "${intent.getStringExtra("flagPngKey")}")
        Glide.with(this)
            .load(intent.getStringExtra("flagPngKey").toString())
            .into(image)

    }
}