package com.example.rc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listName = mutableListOf<String>("Alex", "Marina", "Jhon")
        val listCompany = mutableListOf<String>("Google", "Amazon", "Netflix")
        adapter = Adapter(listName, listCompany)

        binding.rcView.layoutManager = LinearLayoutManager(this)
        binding.rcView.adapter = adapter
    }
}