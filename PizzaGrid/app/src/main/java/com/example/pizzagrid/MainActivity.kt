package com.example.pizzagrid

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridView = findViewById<GridView>(R.id.gridView)
        val adapter = PizzaAdapter(this)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            val nombres = arrayOf(
                "Americana", "Chicken BBQ", "Hawaiana",
                "Margarita", "Pepperoni", "Vegetariana"
            )
            Toast.makeText(this, "Pizza ${nombres[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}