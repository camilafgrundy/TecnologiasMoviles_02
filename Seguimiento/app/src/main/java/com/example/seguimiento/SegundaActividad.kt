package com.example.seguimiento

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SegundaActividad : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_actividad)

        progressBar = findViewById(R.id.progressBar)

        cargarBarra()
    }

    private fun cargarBarra() {
        val handler = Handler(Looper.getMainLooper())
        var progreso = 0

        val runnable = object : Runnable {
            override fun run() {
                if (progreso <= 100) {
                    progressBar.progress = progreso
                    progreso += 10
                    handler.postDelayed(this, 100)
                } else {
                    Toast.makeText(this@SegundaActividad, "Carga completa :)", Toast.LENGTH_SHORT).show()
                }
            }
        }

        handler.post(runnable)
    }
}