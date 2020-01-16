package com.example.filmsapp.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmsapp.R
import com.example.filmsapp.adapter.FilmAdapter
import com.example.filmsapp.data.Filmdata
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException


class HomeFragment : Fragment() {
    val itemLlist: ArrayList<Filmdata> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_home, container, false)
        val progressBar=v.findViewById<ProgressBar>(R.id.progress_bar)
        init(v)
        fetchData()

        return v
    }

    private fun init(v: View) {

        v.home_recycler.layoutManager = LinearLayoutManager(context)

        v.home_recycler.adapter = FilmAdapter(this.itemLlist, activity as Context)


    }

    private fun fetchData() {
        val mClient = OkHttpClient();
        val request = Request.Builder()
            .url("https://swapi.co/api/films/")
            .addHeader("Content-Type", " application/x-www-form-urlencoded")
            .build()

        mClient.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: okhttp3.Call, e: IOException) {
                activity!!.runOnUiThread {
                    Toast.makeText(activity, "Failed", Toast.LENGTH_LONG)

                }
                e.printStackTrace()
            }

            override fun onResponse(call: okhttp3.Call, response: Response) {
                if (response.isSuccessful) {
                    val responseString = response.body!!.string()
                    Log.d("loga", "succ: " + responseString)

                    activity!!.runOnUiThread {
                        try {
                            val jsonObj = JSONObject(responseString)
                            val JA = jsonObj.getJSONArray("results")
                            for (i in 0 until JA.length()) {
                                val JO = JA[i] as JSONObject
                                val model = Filmdata(
                                    JO.getString("title"),
                                    JO.getString("director"),
                                    JO.getString("producer"),
                                    JO.getString("release_date"),
                                    JO.getString("opening_crawl")
                                )
                                itemLlist.add(model)
                                view!!.home_recycler.adapter = FilmAdapter(itemLlist, activity as Context)
                                progress_bar.visibility=View.INVISIBLE
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
            }

        })
    }
}
