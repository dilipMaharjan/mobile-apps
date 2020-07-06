package challenge.triplebyte.com.meowfest

/**
 *
 *   Created by Dilip Maharjan on 15-07-2018
 */

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import challenge.triplebyte.com.meowfest.model.Cats
import challenge.triplebyte.com.meowfest.R.id.imageView
import android.graphics.BitmapFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import java.net.URL


class CatAdaptor(private val catList: List<Cats>) : RecyclerView.Adapter<CatAdaptor.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var time: TextView = view.findViewById(R.id.time)
        var image: ImageView = view.findViewById(R.id.imageView)
        var description: TextView = view.findViewById(R.id.description)


    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent!!.context)
                .inflate(R.layout.list_item, parent, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return catList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        val cat = catList!![position]
        holder!!.title.text = cat.title
        holder!!.time.text = cat.time
        holder!!.description.text = cat.description
        Glide.with(holder.image.context)
                .load(cat.image)
                .into(holder!!.image)
    }
}