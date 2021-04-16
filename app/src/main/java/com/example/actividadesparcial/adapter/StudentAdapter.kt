package com.example.actividadesparcial.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.actividadesparcial.R
import com.example.actividadesparcial.data.Student
import kotlinx.android.synthetic.main.item_student.view.*

class StudentAdapter(private val students: MutableList<Student>, private val callback: (Student) -> Unit): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View, val callback: (Student) -> Unit): RecyclerView.ViewHolder(itemView) {
        fun bind(student: Student) {
            itemView.cc_student.text = student.cc
            itemView.name_student.text = student.name
            itemView.lastName_student.text = student.lastName
            itemView.phone_student.text = student.phone
            itemView.delete_student.setOnClickListener {
                callback(student)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students[position])
    }

    override fun getItemCount(): Int {
        return students.size
    }

    fun addStudent(student: Student) {
        students.add(student)
        notifyDataSetChanged()
    }

    fun deleteStudent(student: Student) {
        students.remove(student)
        notifyDataSetChanged()
    }
}