package com.example.eazzymeals

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    private var timeOfDayInput: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeOfDayInput = findViewById<EditText>(R.id.timeOfDayInput)
        val showMealsButton = findViewById<Button>(R.id.showMealsButton)

        showMealsButton.setOnClickListener {
            val timeOfDay = timeOfDayInput.text.toString().trim() // Trim whitespace

            if (timeOfDay.isEmpty()) {
                // Show a message to the user
                Toast.makeText(this, "Please enter the time of day", Toast.LENGTH_SHORT).show()
            } else {
                // Create an Intent to start MealChoicesActivity
                val intent = Intent(this, MealChoicesActivity::class.java)

                // Add the time of day as an extra to the Intent
                intent.putExtra("TIME_OF_DAY", timeOfDay)

                // Start the MealChoicesActivity
                startActivity(intent)
            }
        }
    }
}

