package com.app.calcularnotas

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var fieldName : EditText? = null
    var fieldSubject : EditText? = null
    var fieldNote1 : EditText? = null
    var fieldNote2 : EditText? = null
    var fieldNote3 : EditText? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fieldName=findViewById(R.id.txtNombre)
        fieldSubject=findViewById(R.id.txtMateria)
        fieldNote1=findViewById(R.id.txtNota1)
        fieldNote2=findViewById(R.id.txtNota2)
        fieldNote3=findViewById(R.id.txtNota3)


        val buttonCalculate: Button = findViewById(R.id.button)
        buttonCalculate.setOnClickListener{onclick()}

    }

    private fun onclick() {

        val name: EditText = findViewById(R.id.txtNombre)
        val subject: EditText = findViewById(R.id.txtMateria)
        val notes1: EditText = findViewById(R.id.txtNota1)
        val notes2: EditText = findViewById(R.id.txtNota2)
        val notes3: EditText = findViewById(R.id.txtNota3)

        val NameStudents: String = name.text.toString()
        val SubjectStundent: String = subject.text.toString()
        val note1: Double = notes1.text.toString().toDouble()
        val note2: Double = notes2.text.toString().toDouble()
        val note3: Double = notes3.text.toString().toDouble()

        var prom: Double = (note1 + note2 + note3) / 3
        println("El promedio es :" + prom)
        Log.i("salida", "El promedio es $prom")

        var resultado = ""
        var resultadoColor = ""

        if (prom >= 3.5) {
            Log.i("Salida", resultado)
            resultado = "El estudiante Gano con un promedio de :  $prom"
            resultadoColor = "GANA"
            Toast.makeText(this,"$prom gana",Toast.LENGTH_LONG).show()

        } else{
            Log.i("salida", "El estudiante Perdio con un promedio de : $prom ")
            resultado = "Perdio con un promedio de : $prom"
            resultadoColor = "PIERDE"
            Toast.makeText(this,"$prom pierde",Toast.LENGTH_LONG).show()
        }

        val intent = Intent (  this, Activity2::class.java )

        val miBundle: Bundle = Bundle()
        miBundle.putString("Nombre", fieldName!!.text.toString())
        miBundle.putString("Materia", fieldSubject!!.text.toString())
        miBundle.putString("Nota #1", fieldNote1!!.text.toString())
        miBundle.putString("Nota #2", fieldNote2!!.text.toString())
        miBundle.putString("Nota #3", fieldNote3!!.text.toString())
        miBundle.putString("Resultado", resultado!!.toString())
        miBundle.putString("Color", resultadoColor!!.toString())




        intent.putExtras(miBundle)

        startActivity(intent)

    }
}