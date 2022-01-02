package com.example.marveluniverse.ui

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.marveluniverse.R
import com.example.marveluniverse.databinding.ActivityMainBinding
import com.example.marveluniverse.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding : ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding.bookloading.start()
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            binding.bookloading.stop()
            finish()
        }, 2500)
    }
}