package com.idz.colman24class2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idz.colman24class2.OnItemClickListener
import com.idz.colman24class2.R
import com.idz.colman24class2.databinding.StudentListRowBinding
import com.idz.colman24class2.model.Student

class StudentsRecyclerAdapter(private var students: List<Student>?): RecyclerView.Adapter<StudentViewHolder>() {

        var listener: OnItemClickListener? = null

        fun set(students: List<Student>?) {
            this.students = students
        }

        override fun getItemCount(): Int = students?.size ?: 0

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
            val inflator = LayoutInflater.from(parent.context)
            val binding = StudentListRowBinding.inflate(inflator, parent, false)
            return StudentViewHolder(binding, listener)
        }

        override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
            holder.bind(students?.get(position), position)
        }
    }