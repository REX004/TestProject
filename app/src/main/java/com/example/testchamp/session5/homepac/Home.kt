package com.example.testchamp.session5.homepac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.testchamp.R


class Home : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bF1 = view.findViewById<TextView>(R.id.button1)
        val bF2 = view.findViewById<TextView>(R.id.button2)
        val bF3 = view.findViewById<TextView>(R.id.button3)
        val bF4 = view.findViewById<TextView>(R.id.button4)
//hello

        val controller = findNavController()
//        bF1.setOnClickListener { controller.navigate(R.id.signIm) }
        bF2.setOnClickListener { controller.navigate(R.id.signUp) }
        bF3.setOnClickListener { controller.navigate(R.id.forgotPassword) }
        bF4.setOnClickListener { controller.navigate(R.id.forgotPassword) }

    }
}