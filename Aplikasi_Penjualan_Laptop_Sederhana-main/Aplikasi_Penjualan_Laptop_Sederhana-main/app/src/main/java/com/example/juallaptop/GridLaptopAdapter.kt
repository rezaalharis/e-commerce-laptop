package com.example.juallaptop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.ArrayList

class GridLaptopAdapter(list: ArrayList<laptop?>) :
    RecyclerView.Adapter<GridLaptopAdapter.GridViewHolder?>() {
    private val listLaptop: ArrayList<laptop>

    init {
        listLaptop = list
    }

    @NonNull
    @Override
    fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, viewType: Int): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.item_grid, viewGroup, false)
        return GridViewHolder(view)
    }

    @Override
    fun onBindViewHolder(@NonNull holder: GridViewHolder, i: Int) {
        Glide.with(holder.itemView.getContext())
            .load(listLaptop.get(i).getFotoLaptop())
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgLaptop)
    }

    @get:Override
    val itemCount: Int
        get() = listLaptop.size()

    internal inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgLaptop: ImageView

        init {
            imgLaptop = itemView.findViewById(R.id.img_item_photo_grid)
        }
    }
}
