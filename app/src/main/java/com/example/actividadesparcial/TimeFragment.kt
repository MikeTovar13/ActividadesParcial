package com.example.actividadesparcial

import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.fragment_time.*
import java.time.LocalTime
import kotlin.math.min

/**
 * A simple [Fragment] subclass.
 * Use the [TimeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TimeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time, container, false)
    }

    var hour = 0
    var minute = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        time_time_button.setOnClickListener {
            val dialog = TimePickerDialog(requireContext(),{ _, hours, minutes ->
                hour = hours
                minute = minutes
                val time = LocalTime.of(hours, minutes)
                time_time_value.text = time.toString()
            },hour, minute,false)
            dialog.show()
        }

    }
}