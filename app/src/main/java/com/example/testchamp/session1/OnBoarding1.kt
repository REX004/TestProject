package com.example.testchamp.session1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.testchamp.R


class OnBoarding1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.on_boarding1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.post {
            val controller = findNavController()

            val bF1 = view.findViewById<RelativeLayout>(R.id.skipButton)
            val bF2 = view.findViewById<RelativeLayout>(R.id.nextButton)

            bF1.setOnClickListener {
                controller.navigate(R.id.onBoarding2)
            }
            bF2.setOnClickListener {
                controller.navigate(R.id.onBoarding3)
            }
        }
    }

}