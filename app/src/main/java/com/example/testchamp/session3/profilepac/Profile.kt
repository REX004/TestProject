package com.example.testchamp.session3.profilepac

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.testchamp.R

class Profile : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получаем значения из SharedPreferences
        val sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val userName = sharedPreferences.getString("userName", "")

        // Находим TextView с идентификатором hello_ken
        val helloKenTextView = view.findViewById<TextView>(R.id.hello_ken)

        // Устанавливаем текст в TextView
        helloKenTextView.text = userName
    }
}
