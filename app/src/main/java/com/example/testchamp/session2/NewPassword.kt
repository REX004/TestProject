package com.example.testchamp.session2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.testchamp.R
import com.example.testchamp.session3.BottomNavigationView


class NewPassword : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.new_password, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bF1 = view.findViewById<Button>(R.id.button3)

        bF1.setOnClickListener {
        val intent = Intent(requireContext(), BottomNavigationView::class.java)
        startActivity(intent)

        requireActivity().finish()
    }
}}