package com.example.eazzymeals

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MealChoices : AppCompatActivity() {

    private lateinit var MealChoices: TextView
    private lateinit var backbtn: Button
    private lateinit var timeOfDay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_meal_choices)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        MealChoices = findViewById(R.id.Mealchoices)
        backbtn = findViewById(R.id.backbtn)

        val backbtn = findViewById<Button>(R.id.backbtn)

        backbtn.setOnClickListener {
            val intent = Intent( this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}