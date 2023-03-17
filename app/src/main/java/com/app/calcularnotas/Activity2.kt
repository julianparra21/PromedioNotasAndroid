package com.app.calcularnotas

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Activity2 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_average_notes2)

        val name = findViewById<TextView>(R.id.txtNombreFin)
        val subject= findViewById<TextView>(R.id.txtMateriaFin)
        val note1 = findViewById<TextView>(R.id.txtNote1)
        val note2 = findViewById<TextView>(R.id.txtNote2)
        val note3 = findViewById<TextView>(R.id.txtNote3)
        val average = findViewById<TextView>(R.id.txtPromedio)
        var color = ""

        var miBundle : Bundle? = this.intent.extras

        if (miBundle != null) {
            name.text = "${miBundle.getString("Nombre",)} "
            subject.text = "${miBundle.getString("Materia",)} "
            note1.text = "${miBundle.getString("Nota #1",)} "
            note2.text = "${miBundle.getString("Nota #2",)} "
            note3.text = "${miBundle.getString("Nota #3",)} "
            average.text = "${miBundle.getString("Resultado",)} "
            color= "${miBundle.getString("Color")}"


            if (color.equals("GANA")) {
                average.setTextColor(Color.GREEN)

            }else {
                average.setTextColor(Color.RED)

            }


        }

        val buttonsalir : Button = findViewById(R.id.btnSalir)
        buttonsalir.setOnClickListener{ onclick() }

    }

    private fun onclick() {
        finish()
    }


}