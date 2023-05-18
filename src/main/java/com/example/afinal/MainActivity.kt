package com.example.afinal


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

var inputword = ""
var inputclue = ""
var hsw=""
var hs=""


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hs = findViewById<TextView>(R.id.tvhs)
        hs.text = hsw
        var hi = findViewById<TextView>(R.id.tvhigh)


        val word = findViewById<EditText>(R.id.etword)
        val clue = findViewById<EditText>(R.id.etclue)
        val startbutton = findViewById<Button>(R.id.btnstart)
        startbutton.setOnClickListener {
            inputword = word.text.toString()
            inputclue = clue.text.toString()
            if (inputword == "" || inputclue == "") {
                Toast.makeText(
                    this@MainActivity,
                    "Please, Enter the required fields!",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (inputword.length > 16) {
                Toast.makeText(
                    this@MainActivity,
                    "Enter a word with less that 16 letters!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
        }

            val sharedPreferences = getSharedPreferences("MY", Context.MODE_PRIVATE)
            val hsw = sharedPreferences.getString("highscore", "").toString()
            hs.text = hsw




    }
}
