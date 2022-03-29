package com.example.rc

import android.util.Log
import com.example.rc.data.Person

class FillingInfo(
    listName: MutableList<String>,
    listCompany: MutableList<String>
) {



        val user: MutableList<Person> = (0..100).map {
            Person(
                id = it,
                name = listName[it % listName.size],
                company = listCompany[it % listCompany.size],
                years = it
            )
        }.toMutableList()

}