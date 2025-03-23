package com.example.findmovienew.ui.names

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.findmovienew.domain.models.Person

class PersonsAdapter : RecyclerView.Adapter<PersonViewHolder>() {
    var persons = mutableListOf<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(persons[position])
    }

}