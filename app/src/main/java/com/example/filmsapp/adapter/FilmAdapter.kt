package com.example.filmsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.filmsapp.R
import kotlinx.android.synthetic.main.item_films.view.*


internal class FilmAdapter(val items: ArrayList<String>, val context: Context) :
    RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_films, parent, false))

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.filmName.text = items.get(position)
        holder?.releaseYear.text = items.get(position)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var filmName = view.findViewById<TextView>(R.id.film_name)
        var releaseYear = view.release_year
    }
}


