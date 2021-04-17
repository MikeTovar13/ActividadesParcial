package com.example.actividadesparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.actividadesparcial.adapter.StudentAdapter
import com.example.actividadesparcial.data.Student
import com.example.actividadesparcial.dialog.StudentDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_student.*

class MainActivity : AppCompatActivity() {

    // lateinit asegura a android que se inicializara adelante
    private lateinit var adapter: StudentAdapter
    lateinit var students: MutableList<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Call functions
        this.callButtons()
        this.setupList()
    }

    private fun setupList(){
        students = mutableListOf<Student>()

        adapter = StudentAdapter(students) { student ->
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.title_delete))
            builder.setMessage(getString(R.string.subtitle_delete))
            builder.setPositiveButton(R.string.agree) { _, _ ->
                this.deleteStudent(student)
            }
            builder.setNegativeButton(getString(R.string.cancel), null)
            builder.setCancelable(false)
            builder.show()


        }
        main_rv_students.adapter = adapter
        main_rv_students.layoutManager = LinearLayoutManager(this)
    }


    private fun callButtons() {
        main_bnt_add.setOnClickListener {
            val dialog = StudentDialog(this) { cc, name, lastName, phone ->
                this.addStudent(cc, name, lastName, phone)
            }
            dialog.setCancelable(false)
            dialog.show()
        }

        main_btn_fragments.setOnClickListener {
            val intent = Intent(this, HomeFragments::class.java)
            startActivity(intent)
        }
    }

    private fun addStudent(cc: String, name: String, lastName: String, phone: String) {
        val student = Student(cc, name, lastName, phone)
        adapter.addStudent(student)
    }

    private fun deleteStudent(student: Student) {
        adapter.deleteStudent(student)
    }

}