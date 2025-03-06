package com.example.app_primeiro_projeto

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerInput = findViewById<Spinner>(R.id.spinner_input_scale)
        val spinnerOutput = findViewById<Spinner>(R.id.spinner_output_scale)
        val buttonNext = findViewById<Button>(R.id.button_next)

        ArrayAdapter.createFromResource(
            this,
            R.array.scales,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerInput.adapter = adapter
            spinnerOutput.adapter = adapter
        }


        buttonNext.setOnClickListener {
            val inputScale = spinnerInput.selectedItem.toString()
            val outputScale = spinnerOutput.selectedItem.toString()

            val intent = Intent(this, InputValueActivity::class.java)
            intent.putExtra("inputScale", inputScale)
            intent.putExtra("outputScale", outputScale)
            startActivity(intent)
        }
    }
}
