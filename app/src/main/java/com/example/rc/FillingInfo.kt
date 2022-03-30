package com.example.rc

import com.example.rc.data.Person

typealias UsersListener = (users: List<Person>) -> Unit
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

    fun deleteUser(person: Person){
        val indexToDelete = user.indexOfFirst { it.id == person.id }
        if (indexToDelete != 1){
            user.removeAt(indexToDelete)
        }
    }



    fun shuffleLists(){
        listName.shuffle()
        listCompany.shuffle()
    }
}