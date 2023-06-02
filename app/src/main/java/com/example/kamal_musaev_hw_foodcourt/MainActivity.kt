package com.example.kamal_musaev_hw_foodcourt

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kamal_musaev_hw_foodcourt.adapter.ButtonAdapter
import com.example.kamal_musaev_hw_foodcourt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var arrayList: ArrayList<Button> = ArrayList()

    lateinit var adapter: ButtonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        arrayList.add(Button(true, R.string.delivery))
        arrayList.add(Button(false, R.string.pickup))
        arrayList.add(Button(false, R.string.catering))
        arrayList.add(Button(false, R.string.curbside))

        adapter = ButtonAdapter(this, arrayList) {

        }
        binding.recyclerViewForButton.adapter = adapter

    }
}