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
    private var backbtn: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_choices)


        val timeOfDayDisplay = findViewById<TextView>(R.id.timeOfDayDisplay)
        val mealOptionsDisplay = findViewById<TextView>(R.id.mealOptionsDisplay)
        val backbtn = findViewById<Button>(R.id.backbtn)


        backbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
            val timeOfDay = intent.getStringExtra("TIME_OF_DAY")


            // Log the timeOfDay for debugging
            Log.d("MealChoicesActivity", "timeOfDay: $timeOfDay")


            if (timeOfDay.isNullOrEmpty()) {
                // Handle where no time of day was provided
                timeOfDayDisplay.text = "Time of Day: Not specified"

                mealOptionsDisplay.text = "Meal Options: Unable to determine"
            } else {

                timeOfDayDisplay.text = "Time of Day:\n $timeOfDay"

                val mealOptions = getMealOptions(timeOfDay)

                mealOptionsDisplay.text = "Meal Options:\n $mealOptions"
            }
        }
        // Function to determine meal options based on the time of day
        fun getMealOptions(timeOfDay: String?): String {
            return when (timeOfDay?.lowercase()) {
                "morning" -> "English breakfast \n Oatmeal \n Breakfast burrito"
                "mid-morning" -> "Muslei with yogurt \n Fruit salad \n Smoothie"
                "lunch" -> "Sandwich \n Burger \n Wrap"
                "afternoon snack" -> "Popcorn \n Nuts \n Crackers and cheese"
                "dinner" -> "Pasta \n Curry \n Spicy rice and chicken"
                "evening snack" -> "Ice cream \n Smores \n Tea and cake"
                else -> "Please enter either : breakfast, mid-morning, lunch, afternoon snack, dinner, or evening snack"
            }
        }
    }
