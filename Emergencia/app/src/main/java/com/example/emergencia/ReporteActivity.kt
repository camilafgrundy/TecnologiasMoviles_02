package com.example.emergencia

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ReporteActivity : AppCompatActivity() {

    private lateinit var listViewReportes: ListView
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reporte)

        listViewReportes = findViewById(R.id.listViewReportes)
        btnRegresar = findViewById(R.id.btnRegresar)

        val reportesOrdenados = DataStore.reportes.sortedWith(compareBy {
            when (it.prioridad) {
                "Alta" -> 1
                "Media" -> 2
                "Baja" -> 3
                else -> 4
            }
        })

        val listaTexto = reportesOrdenados.map {
            "Tipo: ${it.tipo} - Prioridad: ${it.prioridad}"
        }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listaTexto
        )

        listViewReportes.adapter = adapter

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}