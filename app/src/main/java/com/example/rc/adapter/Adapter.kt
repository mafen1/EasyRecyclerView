package com.example.rc.adapter

import android.content.Intent
import android.util.Log
import android.view.*
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.rc.DescriptionActivity
import com.example.rc.FillingInfo
import com.example.rc.R
import com.example.rc.data.Person
import com.example.rc.databinding.PersonItemLayoutBinding
import com.google.android.material.snackbar.Snackbar

class Adapter(

) : RecyclerView.Adapter<Adapter.MyViewHolder>(), View.OnClickListener {


    var list: List<Person> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var index = 0


    class MyViewHolder(
        val binding: PersonItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflateLayout = LayoutInflater.from(parent.context)
        val binding = PersonItemLayoutBinding.inflate(inflateLayout, parent, false)
        binding.avatar.setOnClickListener(this)
        binding.more.setOnClickListener(this)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPosition = list[position]
        with(holder.binding) {
            holder.itemView.tag = currentPosition
            more.tag = currentPosition

            tvName.text = currentPosition.name
            tvCompany.text = currentPosition.company
            tvYears.text = currentPosition.years.toString()

        }
        holder.itemView.setOnClickListener {
            val i = Intent(holder.binding.root.context, DescriptionActivity::class.java)
            index = currentPosition.id
            Log.d(TAG, index.toString())
            i.putExtra(NAME, index)
            holder.binding.root.context.startActivity(i)
        }

    }

    override fun getItemCount(): Int = list.size

    fun showPopUpMenu(v: View) {
        val popupMenu = PopupMenu(v.context, v)
        popupMenu.menu.add(0, DELETE_ID, Menu.NONE, "delete")
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                DELETE_ID -> FillingInfo().personInfo(v)
                else -> {
                    Snackbar.make(
                        v,
                        "Error in popUpMenu",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
            return@setOnMenuItemClickListener true
        }
        popupMenu.show()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.more -> {
                showPopUpMenu(v)
            }
        }
    }
    companion object {
        val DELETE_ID = 1
        val TAG = "TAG"
        val NAME = "name"
    }

}