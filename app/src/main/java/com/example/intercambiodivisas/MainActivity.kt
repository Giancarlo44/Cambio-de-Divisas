package com.example.intercambiodivisas

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Vinculando los elementos del layout con el código
        val inputAmount = findViewById<EditText>(R.id.etMonto)
        val convertButton = findViewById<Button>(R.id.btnConvertir)
        val resultView = findViewById<TextView>(R.id.tvResultado)

        // Acción del botón de conversión
        convertButton.setOnClickListener {
            val amount = inputAmount.text.toString().toDoubleOrNull()
            if (amount != null) {
                val resultDollars = convertToDollars(amount)  // Conversión a Dólares
                val resultEuros = convertToEuros(amount)      // Conversión a Euros
                val resultPesosMx = convertToPesosMx(amount)  // Conversión a Pesos Mexicanos

                resultView.text = "Resultado:\n" +
                        "Dólares: $resultDollars\n" +
                        "Euros: $resultEuros\n" +
                        "Pesos MX: $resultPesosMx"
            } else {
                resultView.text = "Por favor, ingrese una cantidad válida"
            }
        }
    }

    // Función para convertir Soles a Dólares
    private fun convertToDollars(amount: Double): Double {
        val conversionRate = 0.27  // Ejemplo: 1 Sol = 0.27 USD
        return amount * conversionRate
    }

    // Función para convertir Soles a Euros
    private fun convertToEuros(amount: Double): Double {
        val conversionRate = 0.24  // Ejemplo: 1 Sol = 0.24 EUR
        return amount * conversionRate
    }

    // Función para convertir Soles a Pesos Mexicanos
    private fun convertToPesosMx(amount: Double): Double {
        val conversionRate = 5.28  // Ejemplo: 1 Sol = 5.28 MXN
        return amount * conversionRate
    }
}

