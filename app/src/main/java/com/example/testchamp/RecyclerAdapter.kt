package com.example.testchamp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.testchamp.databinding.RecyclerAdapterBinding

class RecyclerAdapter : AppCompatActivity() {

    private lateinit var binding: RecyclerAdapterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = RecyclerAdapterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}