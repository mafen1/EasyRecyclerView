package com.example.rc

import android.view.View
import com.example.rc.data.Person

class FillingInfo {

    val listName = mutableListOf("Alex", "Marina", "Jhon")
    val listCompany = mutableListOf("Google", "Amazon", "Netflix")

    val user: MutableList<Person> = (0..100).map {
        Person(
            id = it,
            name = listName[it % listName.size],
            company = listCompany[it % listCompany.size],
            years = it
        )
    }.toMutableList()

    fun personInfo(v: View): Person {
        return v.tag as Person
    }


    fun initView(
        position:Int
    ): String {
        val newUser = user[position]
        val id = newUser.id
        val name = newUser.name
        val company = newUser.company
        val years = newUser.years
        val string = "$id $name $company $years"
        return string


    }
}