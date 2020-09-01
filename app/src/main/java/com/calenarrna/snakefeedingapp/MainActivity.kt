package com.calenarrna.snakefeedingapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.calc_button).setOnClickListener {
            printPreySize(it)
        }
        findViewById<Button>(R.id.recalc_button).setOnClickListener {
            reCalculate(it)
        }
    }


    private fun printPreySize(button: View) {
        val text = findViewById<TextView>(R.id.prey_size_text)
        val input = findViewById<EditText>(R.id.snake_weight)
        val reCalc = findViewById<Button>(R.id.recalc_button)
        val calculator = getCalculator("boa")
        val weight = input.text.toString().toInt()
        val preySize: String = calculator.calculate(weight)
        text.text = "Your ideal prey-size is: $preySize"

        text.visibility = View.VISIBLE
        input.visibility = View.GONE
        button.visibility = View.GONE
        reCalc.visibility = View.VISIBLE

        // Hide the keyboard.
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(button.windowToken, 0)
    }

    private fun getCalculator(snakeSpecies: String): Calculator {
        return BoaConstrictorCalculator();
    }

    private fun reCalculate(reCalc: View) {
        val button = findViewById<Button>(R.id.calc_button)
        val text = findViewById<TextView>(R.id.prey_size_text)
        val input = findViewById<EditText>(R.id.snake_weight)

        text.visibility = View.GONE
        input.visibility = View.VISIBLE
        button.visibility = View.VISIBLE
        reCalc.visibility = View.GONE

        input.requestFocus()
        //show the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(input, 0)
    }
}