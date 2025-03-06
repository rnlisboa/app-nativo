package com.example.app_primeiro_projeto

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textViewResult = findViewById<TextView>(R.id.textView_result)

        val convertedValue = intent.getDoubleExtra("convertedValue", 0.0)
        val inputScale = intent.getStringExtra("inputScale")
        val outputScale = intent.getStringExtra("outputScale")


        val resultText = "Resultado: $convertedValue $outputScale\n\n" +
                "Conversão de $inputScale para $outputScale."

        textViewResult.text = resultText
    }
}
