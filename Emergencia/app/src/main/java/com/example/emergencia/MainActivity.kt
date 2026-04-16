package com.example.emergencia

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spTipo: Spinner
    private lateinit var spPrioridad: Spinner
    private lateinit var btnReportar: Button
    private lateinit var btnVerReporte: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spTipo = findViewById(R.id.spTipo)
        spPrioridad = findViewById(R.id.spPrioridad)
        btnReportar = findViewById(R.id.btnReportar)
        btnVerReporte = findViewById(R.id.btnVerReporte)

        // Spinner de tipos de emergencia
        val adapterTipo = ArrayAdapter.createFromResource(
            this,
            R.array.tipos_emergencia,
            android.R.layout.simple_spinner_item
        )
        adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spTipo.adapter = adapterTipo

        // Spinner de prioridades
        val adapterPrioridad = ArrayAdapter.createFromResource(
            this,
            R.array.prioridades,
            android.R.layout.simple_spinner_item
        )
        adapterPrioridad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spPrioridad.adapter = adapterPrioridad

        btnReportar.setOnClickListener {
            val tipoSeleccionado = spTipo.selectedItem.toString()
            val prioridadSeleccionada = spPrioridad.selectedItem.toString()

            val nuevoReporte = ReporteEmergencia(tipoSeleccionado, prioridadSeleccionada)
            DataStore.reportes.add(nuevoReporte)

            Toast.makeText(
                this,
                "Emergencia reportada: $tipoSeleccionado - Prioridad $prioridadSeleccionada",
                Toast.LENGTH_SHORT
            ).show()
        }

        btnVerReporte.setOnClickListener {
            val intent = Intent(this, ReporteActivity::class.java)
            startActivity(intent)
        }
    }
}