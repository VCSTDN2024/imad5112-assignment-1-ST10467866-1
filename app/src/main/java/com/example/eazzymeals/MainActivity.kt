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

//References:
//https://eur03.safelinks.protection.outlook.com/?url=https%3A%2F%2Fwww.canva.com%2Fdesign%2FDAGi2Bf8IUM%2Fs7Gu_Sn0SgclhG4edsm7XQ%2Fedit%3Futm_content%3DDAGi2Bf8IUM%26utm_campaign%3Ddesignshare%26utm_medium%3Dlink2%26utm_source%3Dsharebutton&data=05%7C02%7Cst10467866%40vcconnect.edu.za%7C394981933b834c8e81bd08dd71bf164c%7Ce10c8f44f469448fbc0dd781288ff01b%7C0%7C0%7C638791787749307820%7CUnknown%7CTWFpbGZsb3d8eyJFbXB0eU1hcGkiOnRydWUsIlYiOiIwLjAuMDAwMCIsIlAiOiJXaW4zMiIsIkFOIjoiTWFpbCIsIldUIjoyfQ%3D%3D%7C0%7C%7C%7C&sdata=AoPi3dpDJuw0sDB1kIlHkfhGJh%2FPLuxXllt81JC1pwg%3D&reserved=0


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
