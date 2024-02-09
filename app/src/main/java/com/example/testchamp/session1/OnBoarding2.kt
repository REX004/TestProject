package com.example.testchamp.session1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.testchamp.R

class OnBoarding2 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.on_boarding2, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bF1 = view.findViewById<RelativeLayout>(R.id.signInButton)
        val bF2 = view.findViewById<TextView>(R.id.sign_in)
        val controller = findNavController()
        bF1.setOnClickListener { controller.navigate(R.id.signUp) }
        bF2.setOnClickListener { controller.navigate(R.id.logIn) }

    }

}