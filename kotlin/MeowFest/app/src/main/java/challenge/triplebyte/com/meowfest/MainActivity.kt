package challenge.triplebyte.com.meowfest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import challenge.triplebyte.com.meowfest.api.CatsApi
import challenge.triplebyte.com.meowfest.model.Cats
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.support.v7.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    lateinit var catAdaptor: CatAdaptor
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        val retrofit = Retrofit
                .Builder()
                .baseUrl("https://chex-triplebyte.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create()).build()

        val client = retrofit.create(CatsApi::class.java)
        val call = client.cats()
        call.enqueue(object : Callback<List<Cats>> {
            override fun onResponse(call: Call<List<Cats>>?, response: Response<List<Cats>>?) {
                if (response != null) {
                    val response = response.body()
                    if (response != null) {
                        catAdaptor = CatAdaptor(response)
                        val mLayoutManager = LinearLayoutManager(applicationContext)
                        recyclerView.layoutManager = mLayoutManager
                        recyclerView.itemAnimator = DefaultItemAnimator()
                        recyclerView.adapter = catAdaptor
                    }
                }
            }

            override fun onFailure(call: Call<List<Cats>>?, t: Throwable?) {
                Log.i(TAG, t!!.message.toString())
            }
        })
    }
}
