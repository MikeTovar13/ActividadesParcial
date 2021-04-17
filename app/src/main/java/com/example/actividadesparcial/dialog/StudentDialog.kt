package com.example.actividadesparcial.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.example.actividadesparcial.R
import kotlinx.android.synthetic.main.dialog_student.*

class StudentDialog (context: Context, val callback: (String, String, String, String) -> Unit): Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_student)

        dialog_btn_student.setOnClickListener {
            val cc = dialog_cc_student.text.toString()
            val name = dialog_name_student.text.toString()
            val lastName = dialog_lastName_student.text.toString()
            val phone = dialog_phone_student.text.toString()

            if (cc.isNotEmpty() && name.isNotEmpty() && lastName.isNotEmpty() && phone.isNotEmpty()) {
                callback(cc, name, lastName, phone)
                dismiss()
            } else {
                Toast.makeText(context, R.string.validation_add_student, Toast.LENGTH_LONG).show()
            }
        }
    }
}