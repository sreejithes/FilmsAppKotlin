package com.example.filmsapp.ui
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmsapp.R
import com.example.filmsapp.adapter.FilmAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {
    val items: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_home, container, false)
        init(v)

        return v
    }

    private fun init(v: View) {

//        val filmName = v.findViewById<TextView>(R.id.film_name)
//        val releaseYear=v.findViewById<TextView>(R.id.release_year)
//        val process = FetchData()
//        process.execute()
        additems()

        v.home_recycler.layoutManager = LinearLayoutManager(context)

        v.home_recycler.adapter = FilmAdapter(items, activity as Context)


    }

    private fun additems() {
        items.add("adsadasd")
        items.add("adsadasd")
        items.add("adsadasd")
        items.add("adsadasd")
        items.add("adsadasd")
        items.add("adsadasd")
    }

}
