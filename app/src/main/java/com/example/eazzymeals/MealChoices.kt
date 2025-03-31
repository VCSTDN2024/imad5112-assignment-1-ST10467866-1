package com.example.eazzymeals

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text


class MealChoicesActivity : AppCompatActivity() {
    private var timeOfDayDisplay: TextView? = null
    private var mealOptionsDisplay: TextView? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_choices)


        val timeOfDayDisplay = findViewById<TextView>(R.id.timeOfDayDisplay)
        val mealOptionsDisplay = findViewById<TextView>(R.id.mealOptionsDisplay)

        // Get the Intent that started this activity
        val intent = intent

        // Get the time of day from the Intent's extras
        val timeOfDay = intent.getStringExtra("TIME_OF_DAY")

        // Log the timeOfDay value for debugging
        Log.d("MealChoicesActivity", "timeOfDay: $timeOfDay")

        // Check if timeOfDay is null or empty
        if (timeOfDay.isNullOrEmpty()) {
            // Handle the case where no time of day was provided
            timeOfDayDisplay.text = "Time of Day: Not specified"

            mealOptionsDisplay.text = "Meal Options: Unable to determine"
        } else {
            // Display the time of day
            timeOfDayDisplay.text = "Time of Day: $timeOfDay"

            // Determine meal options based on the time of day
            val mealOptions = getMealOptions(timeOfDay)

            // Display the meal options
            mealOptionsDisplay.text = "Meal Options: $mealOptions"
        }
    }

    private fun getMealOptions(timeOfDay: String?): String {
        return when (timeOfDay?.lowercase()) {
            "morning" -> "Eggs, Toast, Cereal"
            "lunch" -> "Salad, Sandwich, Soup"
            "afternoon" -> "Sandwich, Salad, Soup"
            "evening" -> "Pasta, Chicken, Pizza"
            else -> "Snacks, Fruits" // Default for unknown times
        }
    }
}
