package com.example.pizzagrid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class PizzaAdapter(private val context: Context) : BaseAdapter() {

    private val nombres = arrayOf(
        "Americana", "Chicken BBQ", "Hawaiana",
        "Margarita", "Pepperoni", "Vegetariana"
    )

    private val imagenes = intArrayOf(
        R.drawable.pizza_americana,
        R.drawable.pizza_chicken_bbq,
        R.drawable.pizza_hawaiana,
        R.drawable.pizza_margarita,
        R.drawable.pizza_pepperoni,
        R.drawable.pizza_vegetariana
    )

    override fun getCount() = nombres.size
    override fun getItem(position: Int) = nombres[position]
    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_pizza, parent, false)

        view.findViewById<ImageView>(R.id.imagePizza).setImageResource(imagenes[position])
        view.findViewById<TextView>(R.id.textPizza).text = nombres[position]

        return view
    }
}