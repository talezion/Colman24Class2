package com.idz.colman24class2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // TODO: 1 - Set up project
        // TODO: 2 - Create nav_graph.xml and connect to nav host
        // TODO: 3 - Connect list fragment with blue fragment action with back button
        // TODO: 4 - Set navArgs for blue fragment
        // TODO: 5 -
        // TODO: 6 -
        // TODO: 7 -


    }
}