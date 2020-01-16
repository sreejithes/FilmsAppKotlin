package com.example.filmsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.filmsapp.MainActivity
import com.example.filmsapp.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_details.view.*

class DetailsFragment(var title:String, var directorName: String, var producerName: String, var releaseDate : String, var description:String) : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_details, container, false)
        description=description.replace("\n","")
        v.film_title.text = title
        v.film_director.text=directorName
        v.film_producer.text=producerName
        v.film_release_date.text=releaseDate
        v.film_description.text=description
        return v
    }
}
