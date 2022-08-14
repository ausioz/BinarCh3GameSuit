package com.ausioz.binarch3gamesuit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.ausioz.binarch3gamesuit.databinding.ActivityMainBinding
import com.ausioz.binarch3gamesuit.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {

    private var _binding: ActivitySplashScreenBinding? = null
    private val textTitle = (R.string.app_title_text)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        _binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        _binding?.splashText?.text = (getText(textTitle))

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 3000 is the delayed time in milliseconds.
    }
}