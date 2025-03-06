package com.example.app_primeiro_projeto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class InputValueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_value)

        val buttonConvert = findViewById<Button>(R.id.button_convert)
        val editTextValue = findViewById<EditText>(R.id.editText_value)


        val inputScale = intent.getStringExtra("inputScale") ?: "Celsius"
        val outputScale = intent.getStringExtra("outputScale") ?: "Fahrenheit"

        buttonConvert.setOnClickListener {
            val valorDigitado = editTextValue.text.toString().toDoubleOrNull()

            if (valorDigitado != null) {
                val convertedValue = convertTemperature(valorDigitado, inputScale, outputScale)

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("convertedValue", convertedValue)
                intent.putExtra("inputScale", inputScale)
                intent.putExtra("outputScale", outputScale)
                startActivity(intent)
            }
        }
    }

    private fun convertTemperature(value: Double, fromScale: String, toScale: String): Double {
        return when {
            fromScale == "Celsius" && toScale == "Fahrenheit" -> (value * 9/5) + 32
            fromScale == "Celsius" && toScale == "Kelvin" -> value + 273.15

            fromScale == "Fahrenheit" && toScale == "Celsius" -> (value - 32) * 5/9
            fromScale == "Fahrenheit" && toScale == "Kelvin" -> (value - 32) * 5/9 + 273.15

            fromScale == "Kelvin" && toScale == "Celsius" -> value - 273.15
            fromScale == "Kelvin" && toScale == "Fahrenheit" -> (value - 273.15) * 9/5 + 32

            else -> value
        }
    }
}
