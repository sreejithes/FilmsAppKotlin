package com.example.filmsapp.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.filmsapp.R

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_details, container, false)
        iniit(v)
        return v
    }

    private fun iniit(v: View) {

        val details=v.findViewById<TextView>(R.id.film_details)
        val title=v.findViewById<TextView>(R.id.film_title)

    }

}
