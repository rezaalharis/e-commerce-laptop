package com.example.juallaptop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.ArrayList

class CardLaptopAdapter(list: ArrayList<laptop?>) :
    RecyclerView.Adapter<CardLaptopAdapter.CardViewHolder?>() {
    private val listLaptop: ArrayList<laptop>

    init {
        listLaptop = list
    }

    @NonNull
    @Override
    fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.item_card, viewGroup, false)
        return CardViewHolder(view)
    }

    @Override
    fun onBindViewHolder(@NonNull holder: CardViewHolder, position: Int) {
        val laptop: laptop = listLaptop.get(position)
        Glide.with(holder.itemView.getContext())
            .load(laptop.getFotoLaptop())
            .apply(RequestOptions().override(250, 260))
            .into(holder.imgPhoto)
        holder.tvName.setText(laptop.getNamaLaptop())
        holder.tvDetail.setText(laptop.getDetailLaptop())

//        holder.btnBuy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(holder.itemView.getContext(), "Beli" + listLaptop.get(holder.getAdapterPosition()).getNamaLaptop(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        holder.btnShare.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        holder.itemView.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                Toast.makeText(
                    holder.itemView.getContext(),
                    "Kamu Memilih " + listLaptop.get(holder.getAdapterPosition()).getNamaLaptop(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    @get:Override
    val itemCount: Int
        get() = listLaptop.size()

    internal inner class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgPhoto: ImageView
        var tvName: TextView
        var tvDetail: TextView
        var btnBuy: Button
        var btnShare: Button

        init {
            imgPhoto = view.findViewById(R.id.img_item_photo_card)
            tvName = view.findViewById(R.id.tv_item_name_card)
            tvDetail = view.findViewById(R.id.tv_item_detail_card)
            btnBuy = view.findViewById(R.id.btn_buy)
            btnShare = view.findViewById(R.id.btn_share)
        }
    }
}
