package com.example.testchamp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testchamp.session1.OnBoarding1



import com.example.testchamp.session3.BottomNavigationView

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Проверяем, авторизован ли пользователь
        if (isUserLoggedIn()) {
            // Пользователь уже авторизован, перенаправляем на Bottom Navigation Activity
            startBottomNavigationView()
        } else {
            // Пользователь не авторизован, отображаем фрагмент для входа
            supportFragmentManager.beginTransaction()
                .replace(R.id.myNavHostFragment, OnBoarding1())
                .commit()
        }
    }


    private fun isUserLoggedIn(): Boolean {
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val userEmail = sharedPreferences.getString("userEmail", null)
        val userPassword = sharedPreferences.getString("userPassword", null)

        return userEmail != null && userPassword != null
    }

    // Метод для перехода на Bottom Navigation Activity
    private fun startBottomNavigationView() {
        val intent = Intent(this, BottomNavigationView::class.java)
        startActivity(intent)
        finish()
    // Опционально, если вы хотите закрыть текущую активность после перехода
    }
}