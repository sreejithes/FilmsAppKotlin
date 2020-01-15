package com.example.filmsapp.adapter

import android.os.AsyncTask
import com.example.filmsapp.MainActivity
import com.example.filmsapp.ui.DetailsFragment
import com.example.filmsapp.ui.HomeFragment
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
class FetchData :
    AsyncTask<Void?, Void?, Void?>() {
    var data = ""
    var dataParsed = ""
    var singleParse = ""
    var title=""

    override fun doInBackground(vararg p0: Void?): Void? {
        var url: URL? = null
        try {
            url = URL("https://swapi.co/api/films/")
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
        try {
            val httpURLConnection =
                url!!.openConnection() as HttpURLConnection
            val inputStream = httpURLConnection.inputStream
            val bufferedReader =
                BufferedReader(InputStreamReader(inputStream))
            var line: String? = " "
            while (line != null) {
                line = bufferedReader.readLine()
                data = data + line
            }
            val JA = JSONArray(data)
            for (i in 0 until JA.length()) {
                val JO = JA[i] as JSONObject
                title=title +JO["title"]
                singleParse =  "Director:" + JO["director"] + "\n" +
                        "Producer:" + JO["producer"] + "\n"+
                        "Release date:" + JO["release_date"] + "\n" +
                        "Discription:"+JO["opening_crawl"]+"\n"
                dataParsed = dataParsed + singleParse
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return null
    }
    override fun onPostExecute(aVoid: Void?) {
        super.onPostExecute(aVoid)
        DetailsFragment.title.setText(title)
        DetailsFragment.details.setText(dataParsed)
    }
}