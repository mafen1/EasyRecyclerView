package com.example.rc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rc.adapter.Adapter
import com.example.rc.adapter.Adapter.Companion.NAME
import com.example.rc.adapter.Adapter.Companion.TAG
import com.example.rc.databinding.ActivityDescriptionBinding

class DescriptionActivity : AppCompatActivity() {
    lateinit var binding1: ActivityDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding1.root)
        initButton()

        val index = intent.getIntExtra(NAME, 0)
        val (id, name, company, years)=  FillingInfo().initView(
            index
        ).split(" ")

        binding1.tvName.text = name
        binding1.tvCompany.text = company
        binding1.tvYears.text = years
    }


    private fun initButton(){
        binding1.btnBack.setOnClickListener {
            finish()
        }
    }
}