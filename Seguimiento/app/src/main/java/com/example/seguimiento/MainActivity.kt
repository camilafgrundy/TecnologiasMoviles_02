package com.example.seguimiento

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    fun abrirTercera(view: View) {
        val intent = Intent(this, TerceraActividad::class.java)
        startActivity(intent)
    }

    fun abrirCuarta(view: View) {
        val intent = Intent(this, CuartaActividad::class.java)
        startActivity(intent)
    }
    private val eti = "Ciclo de Vida"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(eti, "En el evento onCreate()")
    }

    fun onClick(view: View) {
        val intent = Intent(this, SegundaActividad::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d(eti, "En el evento onStart()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(eti, "En el evento onRestart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(eti, "En el evento onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(eti, "En el evento onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(eti, "En el evento onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(eti, "En el evento onDestroy()")
    }
}