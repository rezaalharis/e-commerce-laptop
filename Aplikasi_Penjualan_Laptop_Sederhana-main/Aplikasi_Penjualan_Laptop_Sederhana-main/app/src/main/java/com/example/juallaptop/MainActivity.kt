package com.example.juallaptop

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var rvLaptop: RecyclerView? = null
    var btn_list: Button? = null
    var btn_grid: Button? = null
    var btn_detail: Button? = null
    private val list: ArrayList<laptop> = ArrayList()
    @Override
    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvLaptop = findViewById(R.id.rv_laptop)
        rvLaptop.setHasFixedSize(true)
        list.addAll(DataLaptop.getListData())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvLaptop.setLayoutManager(LinearLayoutManager(this))
        val listLaptopAdapter = ListLaptopAdapter(list)
        rvLaptop.setAdapter(listLaptopAdapter)
    }

    @Override
    fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @Override
    fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.getItemId())
        return super.onOptionsItemSelected(item)
    }

    fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> showRecyclerList()
            R.id.action_grid -> showRecyclerGrid()
            R.id.action_cardview -> showRecyclerCard()
        }
    }

    private fun showRecyclerCard() {
        rvLaptop.setLayoutManager(LinearLayoutManager(this))
        val cardLaptopAdapter = CardLaptopAdapter(list)
        rvLaptop.setAdapter(cardLaptopAdapter)
    }

    private fun showRecyclerGrid() {
        rvLaptop.setLayoutManager(GridLayoutManager(this, 2))
        val gridLaptopAdapter = GridLaptopAdapter(list)
        rvLaptop.setAdapter(gridLaptopAdapter)
    }
}