package com.asharya.esoftwarica.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.asharya.esoftwarica.DataStore
import com.asharya.esoftwarica.R
import com.asharya.esoftwarica.fragments.HomeFragment
import com.asharya.esoftwarica.models.Student
import com.bumptech.glide.Glide

class StudentAdapter(val listStudent: List<Student>, val context: HomeFragment) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    inner class StudentViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val imgProfile : ImageView
        val name : TextView
        val address : TextView
        val sex : TextView
        val age : TextView
        val btnDelete : ImageButton

        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            name = view.findViewById(R.id.tvName)
            address = view.findViewById(R.id.tvAddress)
            sex= view.findViewById(R.id.tvSex)
            age = view.findViewById(R.id.tvAge)
            btnDelete = view.findViewById(R.id.btnDelete)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = listStudent[position]

        Glide.with(context).load(student.profilePicture).into(holder.imgProfile)

        holder.name.text = student.fullName.capitalize()
        holder.sex.text = student.gender
        holder.address.text = student.address
        holder.age.text = student.age.toString()

        holder.btnDelete.setOnClickListener {
            DataStore.studentList.removeAt(position)
            this.notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

}