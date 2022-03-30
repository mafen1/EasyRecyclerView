package com.example.rc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val adapterRC = Adapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        initView()


    }
    private fun initView(){
        binding.rcView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterRC
        }
    }
    private fun initData(){
        FillingInfo().fillingInfo()
        adapterRC.list = FillingInfo().user
    }
}