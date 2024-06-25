package com.example.juallaptop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.ArrayList

class ListLaptopAdapter(list: ArrayList<laptop?>) :
    RecyclerView.Adapter<ListLaptopAdapter.ListViewHolder?>() {
    private val listLaptop: ArrayList<laptop>

    init {
        listLaptop = list
    }

    @NonNull
    @Override
    fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.item_laptop, viewGroup, false)
        return ListViewHolder(view)
    }

    @Override
    fun onBindViewHolder(@NonNull holder: ListViewHolder, position: Int) {
        val laptop: laptop = listLaptop.get(position)
        Glide.with(holder.itemView.getContext())
            .load(laptop.getFotoLaptop())
            .apply(RequestOptions().override(130, 140))
            .into(holder.imgLaptop)
        holder.tvName.setText(laptop.getNamaLaptop())
        holder.tvDetail.setText(laptop.getDetailLaptop())
    }

    @get:Override
    val itemCount: Int
        get() = listLaptop.size()

    inner class ListViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgLaptop: ImageView
        var tvName: TextView
        var tvDetail: TextView

        init {
            imgLaptop = itemView.findViewById(R.id.img_item_photo)
            tvName = itemView.findViewById(R.id.tv_item_name)
            tvDetail = itemView.findViewById(R.id.tv_item_detail)
        }
    }
}
