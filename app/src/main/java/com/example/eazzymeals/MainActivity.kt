package com.example.eazzymeals

import android.annotation.SuppressLint
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
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {
    private var timeOfDayInput: EditText? = null
    private var result: TextView? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeOfDayInput = findViewById<EditText>(R.id.timeOfDayInput)
        val showMealsButton = findViewById<Button>(R.id.showMealsButton)
        val clearbtn = findViewById<Button>(R.id.clearbtn)
        val exitbtn = findViewById<Button>(R.id.exitbtn)


        //clear button used to clear data
        clearbtn.setOnClickListener {
            timeOfDayInput?.text?.clear()
            result?.text = ""
        }


        //exit button used to exit app
        exitbtn.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

        showMealsButton.setOnClickListener {
            val timeOfDay = timeOfDayInput.text.toString().trim() // Trim whitespace

            if (timeOfDay.isEmpty()) {
                // Show a message to the user
            } else {
                // Create an Intent to start MealChoicesActivity
                val intent = Intent(this, MealChoicesActivity::class.java)

                // Add the time of day as an extra to the Intent
                intent.putExtra("TIME_OF_DAY", timeOfDay)

                startActivity(intent)
            }


        }
    }
}
