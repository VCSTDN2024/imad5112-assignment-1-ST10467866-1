package com.example.eazzymeals

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var timeOfDay: EditText
    private lateinit var enterbtn: Button
    private lateinit var clearbtn: Button
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        timeOfDay = findViewById(R.id.timeOfDay)
        enterbtn = findViewById(R.id.enterbtn)
        clearbtn = findViewById(R.id.clearbtn)
        result = findViewById(R.id.result)

        clearbtn.setOnClickListener {
            timeOfDay.text = null
            result.text = null
        }

        enterbtn.setOnClickListener {
            val timeOfDayValue = timeOfDay.text.toString() // Get the text from timeOfDay EditText
            val intent = Intent(this, MealChoices::class.java)
            intent.putExtra("TIME_OF_DAY", timeOfDayValue) // Add the value as an extra
            startActivity(intent)
        }
    }
}