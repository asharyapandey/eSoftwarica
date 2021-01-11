package com.asharya.esoftwarica.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asharya.esoftwarica.DataStore
import com.asharya.esoftwarica.R
import com.asharya.esoftwarica.adapters.StudentAdapter

class HomeFragment : Fragment() {
    private lateinit var rvStudent : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        rvStudent = view.findViewById(R.id.rvStudent)

        val adapter = StudentAdapter(DataStore.studentList, this)

        rvStudent.layoutManager = LinearLayoutManager(activity)
        rvStudent.adapter = adapter

        return view
    }
}