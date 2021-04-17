package com.example.actividadesparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_home_fragments.*

class HomeFragments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_fragments)

        this.showFragment(TimeFragment())  // Load fragment default "time dialog fragment"

        // Buttons home
        home_btn_time.setOnClickListener {
            this.showFragment(name = TimeFragment())  // Fragment "time dialog fragment"
        }

        home_btn_image.setOnClickListener {
            this.showFragment(name = ImageFragment()) // Fragment "image dialog fragment"
        }

        home_btn_back.setOnClickListener {
            finish() // Close activity
        }

    }

    private fun showFragment(name: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.home_container, name, null)
        transaction.commit()
    }
}