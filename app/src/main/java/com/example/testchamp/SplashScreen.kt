package com.example.testchamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testchamp.databinding.SplashScreenBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var binding: SplashScreenBinding

            binding = SplashScreenBinding.inflate(layoutInflater)
            setContentView(R.layout.splash_screen)

            CoroutineScope(Dispatchers.Main).launch {
                delay(2000)
                startActivity(Intent(this@SplashScreen, MainActivity::class.java))
                finish()
            }
        }
    }
