package com.example.rc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rc.adapter.Adapter
import com.example.rc.data.Person
import com.example.rc.databinding.ActivityDescriptionBinding
import com.example.rc.databinding.ActivityMainBinding

class DescriptionActivity : AppCompatActivity() {
    lateinit var binding1: ActivityDescriptionBinding
    lateinit var binding: ActivityMainBinding
    val Adapter = Adapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityDescriptionBinding.inflate(layoutInflater)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(binding1.root)
        initButton()
        initView()


    }
    private fun initView(){
        val a = FillingInfo().personInfo(binding.root)
        binding1.tvName.text = a.name
    }
    private fun initButton(){
        binding1.btnBack.setOnClickListener {
            finish()
        }
    }
}