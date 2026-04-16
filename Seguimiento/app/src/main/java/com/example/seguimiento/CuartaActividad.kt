package com.example.seguimiento

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class CuartaActividad : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuarta_actividad)

        progressBar = findViewById(R.id.progressBar)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_inicio -> {
                    Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_perfil -> {
                    Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_configuracion -> {
                    Toast.makeText(this, "Configuración", Toast.LENGTH_SHORT).show()
                }
            }
            drawerLayout.closeDrawers()
            true
        }

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
                    Toast.makeText(this@CuartaActividad, "Carga completa :)", Toast.LENGTH_SHORT).show()
                }
            }
        }

        handler.post(runnable)
    }
}