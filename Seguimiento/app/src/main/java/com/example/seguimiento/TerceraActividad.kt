package com.example.seguimiento

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar

class TerceraActividad : AppCompatActivity() {

    lateinit var progressBar: ProgressBar
    lateinit var editTextMonto: EditText
    lateinit var spinnerOrigen: Spinner
    lateinit var spinnerDestino: Spinner
    lateinit var btnConvertir: Button
    lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tercera_actividad)

        progressBar = findViewById(R.id.progressBar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editTextMonto = findViewById(R.id.editTextMonto)
        spinnerOrigen = findViewById(R.id.spinnerOrigen)
        spinnerDestino = findViewById(R.id.spinnerDestino)
        btnConvertir = findViewById(R.id.btnConvertir)
        textViewResultado = findViewById(R.id.textViewConversion)

        val monedas = arrayOf("USD", "PEN", "EUR", "GBP", "INR", "BRL", "MXN", "CNY", "JPY")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, monedas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerOrigen.adapter = adapter
        spinnerDestino.adapter = adapter

        btnConvertir.setOnClickListener {
            val montoTexto = editTextMonto.text.toString()

            if (montoTexto.isEmpty()) {
                Toast.makeText(this, "Ingrese un monto", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            progressBar.progress = 0
            cargarBarraYConvertir(montoTexto)
        }
    }

    private fun cargarBarraYConvertir(montoTexto: String) {
        val handler = Handler(Looper.getMainLooper())
        var progreso = 0

        val runnable = object : Runnable {
            override fun run() {
                if (progreso <= 100) {
                    progressBar.progress = progreso
                    progreso += 10
                    handler.postDelayed(this, 100)
                } else {
                    val monto = montoTexto.toDouble()
                    val origen = spinnerOrigen.selectedItem.toString()
                    val destino = spinnerDestino.selectedItem.toString()

                    val resultado = convertir(origen, destino, monto)
                    textViewResultado.text = "💰 %.2f %s".format(resultado, destino)

                    Toast.makeText(this@TerceraActividad, "Carga completa :)" +
                            "", Toast.LENGTH_SHORT).show()
                }
            }
        }

        handler.post(runnable)
    }

    private fun convertir(origen: String, destino: String, monto: Double): Double {
        val tasasUSD = mapOf(
            "USD" to 1.0,
            "PEN" to 3.8,
            "EUR" to 0.92,
            "GBP" to 0.79,
            "INR" to 83.0,
            "BRL" to 5.0,
            "MXN" to 17.0,
            "CNY" to 7.2,
            "JPY" to 150.0
        )

        val montoEnUSD = monto / tasasUSD[origen]!!
        return montoEnUSD * tasasUSD[destino]!!
    }
}