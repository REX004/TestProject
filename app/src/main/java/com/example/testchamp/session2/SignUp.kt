package com.example.testchamp.session2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.android.volley.AuthFailureError
import com.example.testchamp.R
import com.example.testchamp.databinding.SignUpBinding
import com.example.testchamp.session3.BottomNavigationView
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.realtime.Realtime
import io.github.jan.supabase.storage.Storage
import kotlinx.coroutines.launch


class SignUp : Fragment() {

    private lateinit var binding: SignUpBinding
    private lateinit var supabase: SupabaseClient
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.sign_up, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val Email_get = view.findViewById<EditText>(R.id.emailET)
        val bF1 = view.findViewById<Button>(R.id.signUpBT)
        val bF2 = view.findViewById<TextView>(R.id.signIm)
        val controller = findNavController()
        bF1.setOnClickListener { controller.navigate(R.id.onBoarding2) }
        bF2.setOnClickListener { controller.navigate(R.id.logIn) }
        val supabaseUrl = "https://tnmahbgcomhugvcalfgk.supabase.co"
        val supabaseKey =
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InRubWFoYmdjb21odWd2Y2FsZmdrIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDY3NzgwNjAsImV4cCI6MjAyMjM1NDA2MH0.6s6CPbw4ibYEtBP2FBOlf8JFA7R5dpqzJ6284ULBF0I"

        supabase = createSupabaseClient(supabaseUrl = supabaseUrl, supabaseKey = supabaseKey) {
            install(Auth)
            install(Realtime)
            install(Storage)
            install(Postgrest)
        }


        bF1.setOnClickListener {
            signUpUser(email = String(), password = String(), name = String())
        }

    }

    private fun signUpUser(email: String, password: String, name: String) {
        val email_get = view?.findViewById<EditText>(R.id.emailET)
        val password_get = view?.findViewById<EditText>(R.id.passwordET)
        val name_get = view?.findViewById<EditText>(R.id.nameET)
        val enteredEmail = email_get?.text.toString()
        val enteredPassword = password_get?.text.toString()
        val enteredName = name_get?.text.toString()
        lifecycleScope.launch {
            try {
                val user = supabase.auth.signUpWith(Email) {
                    this.email = enteredEmail
                    this.password = enteredPassword
                }

                // Регистрация успешна, сохраняем данные пользователя
                saveUserData(enteredEmail, enteredPassword, enteredName)

                // Перенаправляем на Bottom Navigation View
                val intent = Intent(requireContext(), BottomNavigationView::class.java)
                startActivity(intent)
            } catch (e: AuthFailureError) {
                // Обработка ошибки регистрации здесь
                showMessage("Введите заново!")
            }
        }
    }

    private fun saveUserData(email: String, password: String, name: String) {
        // Сохранение данных в SharedPreferences
        val sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("userEmail", email)
        editor.putString("userPassword", password)
        editor.putString("userName", name)
        editor.apply()
    }

    private fun showMessage(message: String) {

        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    }
