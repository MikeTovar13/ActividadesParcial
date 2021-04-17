package com.example.actividadesparcial

import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.fragment_image.*
import kotlinx.android.synthetic.main.fragment_time.*
import java.time.LocalTime

/**
 * A simple [Fragment] subclass.
 * Use the [ImageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ImageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    private val images = mapOf<Int, Int>(
            1 to R.drawable.img_1,
            2 to R.drawable.img_2,
            3 to R.drawable.img_3,
            4 to R.drawable.img_4
    )

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image_image_button.setOnClickListener {

            var numImage = image_image_src.tooltipText.toString().toInt()
            numImage++  // Next image count

            if (numImage > 4) numImage = 1

            image_image_src.setImageResource(images[numImage]!!)
            image_image_src.tooltipText = numImage.toString()

        }

    }
}