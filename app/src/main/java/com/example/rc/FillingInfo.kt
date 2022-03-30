package com.example.rc

import android.util.Log
import android.view.View
import com.example.rc.data.Person

class FillingInfo {
    val TAG = "TAG"
    val listName = mutableListOf("Alex", "Marina", "Jhon")
    val listCompany = mutableListOf("Google", "Amazon", "Netflix")
    var user = mutableListOf<Person>()
    init {
        user = (0..100).map {
            Person(
                id = it,
                name = listName[it % listName.size],
                company = listCompany[it % listCompany.size],
                years = it
            )
        }.toMutableList()
    }
    fun deleteUser(person: Person){
        val indexToDelete = user.indexOfFirst { it.id == person.id }
        if (indexToDelete != 1){
            user.removeAt(indexToDelete)
        }
    }

    fun userIndex(person: Person): Int {
        return person.id
    }
    fun personInfo(v: View): Person {
        return v.tag as Person
    }

    fun shuffleLists(){
        listName.shuffle()
        listCompany.shuffle()

    }
}