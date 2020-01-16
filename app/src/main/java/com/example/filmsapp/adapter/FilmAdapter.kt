package com.example.filmsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmsapp.R
import com.example.filmsapp.data.Filmdata
import com.example.filmsapp.ui.DetailsFragment


internal class FilmAdapter(val itemLlist: ArrayList<Filmdata>, val context: Context) :
    RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_films, parent, false))

    }

    override fun getItemCount(): Int {
        return itemLlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.filmName.text = itemLlist.get(position).filmName
        holder?.filmName.setOnClickListener {
            val detailsFragment=DetailsFragment(itemLlist.get(position).filmName,itemLlist.get(position).directorName,itemLlist.get(position).producerName,itemLlist.get(position).releaseDate,itemLlist.get(position).description)
            val manager:FragmentManager=(context as AppCompatActivity).supportFragmentManager
            manager.beginTransaction().add(R.id.main_content,detailsFragment,"detailsFragment").addToBackStack("stack").commit()
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var filmName = view.findViewById<TextView>(R.id.film_name)
    }
}


