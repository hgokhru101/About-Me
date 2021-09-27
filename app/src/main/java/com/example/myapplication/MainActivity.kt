package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val doneButton : Button = findViewById(R.id.doneButton)
        val nickText  = findViewById<EditText>(R.id.nickname)
        val nameText = findViewById<TextView>(R.id.name)
        doneButton.setOnClickListener{
            addNickname(it)
        }
        nameText.setOnClickListener {
            updateNickname(it)
        }

    }
    /**
     * Click handler for the nickname TextView.
     * Displays the EditText and the DONE button.
     * Hides the nickname TextView.
     */
    private fun updateNickname(view:View){
        val nickText  = findViewById<EditText>(R.id.nickname)
        val nameText = findViewById<TextView>(R.id.name)
        nameText.text = nickText.text
        nickText.visibility = View.VISIBLE
        nameText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        // Set the focus to the edit text.
        nickText.requestFocus()
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(nickText, 0)
    }
    private fun addNickname(view: View) {
        val nickText  = findViewById<EditText>(R.id.nickname)
        val nameText = findViewById<TextView>(R.id.name)
        nameText.text = nickText.text
        nickText.visibility = View.VISIBLE
        nameText.visibility = View.VISIBLE
        doneButton.visibility = View.GONE
        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
