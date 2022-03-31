package com.example.rc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rc.adapter.Adapter
import com.example.rc.adapter.Adapter.Companion.TAG
import com.example.rc.adapter.UserActions
import com.example.rc.data.Person
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
        adapterRC.list = FillingInfo().user
    }

}