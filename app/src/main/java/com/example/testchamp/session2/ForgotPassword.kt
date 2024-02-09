package com.example.testchamp.session2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.testchamp.R


class ForgotPassword : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.forgot_password, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bF1 = view.findViewById<Button>(R.id.BT_SignUp3)
        val bF2 = view.findViewById<TextView>(R.id.sign_in)
        val controller = findNavController()
        bF1.setOnClickListener { controller.navigate(R.id.otpVerification) }
        bF2.setOnClickListener { controller.navigate(R.id.logIn) }

    }

}