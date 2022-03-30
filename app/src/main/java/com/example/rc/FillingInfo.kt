package com.example.rc

import android.util.Log
import com.example.rc.data.Person

class FillingInfo(
) {
    val listName = mutableListOf<String>("Alex", "Marina", "Jhon")
    val listCompany = mutableListOf<String>("Google", "Amazon", "Netflix")
        val user: MutableList<Person> = (0..100).map {
            Person(
                id = it,
                name = listName[it % listName.size],
                company = listCompany[it % listCompany.size],
                years = it
            )
        }.toMutableList()
    fun fillingInfo(){
        listName.shuffle()
        listCompany.shuffle()
    }
}