package com.example.rc

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.rc.data.Person
import com.example.rc.databinding.PersonItemLayoutBinding

class Adapter : RecyclerView.Adapter<Adapter.MyViewHolder>() {
    val TAG = "TAG"
    var list: List<Person> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }
        val listName = mutableListOf<String>("Alex", "Marina", "Jhon" )
        val listCompany = mutableListOf<String>("Google", "Amazon", "Netflix" )


    init {
        listName.shuffle()
        listCompany.shuffle()
        val user: MutableList<Person> = (0..100).map {
            Person(
                id = it,
                name = listName[it % listName.size],
                company = listCompany[it % listCompany.size],
                years = it
            )
        }.toMutableList()
        list = user
        Log.d(TAG, "$list")
    }
    class MyViewHolder(
        val binding: PersonItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflateLayout = LayoutInflater.from(parent.context)
        val binding = PersonItemLayoutBinding.inflate(inflateLayout, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPosition = list[position]
        with(holder.binding){
            tvName.text = currentPosition.name
            tvCompany.text = currentPosition.company
            tvYears.text = currentPosition.years.toString()
        }
    }

    override fun getItemCount(): Int = list.size



}