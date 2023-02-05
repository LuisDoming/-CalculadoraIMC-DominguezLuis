package com.example.asignacion4_calculadoraimc_dominguez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imc: TextView = findViewById(R.id.tvResultado)
        var txtEstado: TextView = findViewById(R.id.tvEstado)
        val etEstatura: EditText = findViewById(R.id.estatura)
        val etPeso: EditText = findViewById(R.id.peso)
        val btnCalcular: Button = findViewById(R.id.calcular)

        //Convertir los kilos y estatura a double
        btnCalcular.setOnClickListener{
            var peso: Double = 0.0
            var estatura: Double = 0.0

            try {
                peso = etPeso.text.toString().toDouble()
                estatura = etEstatura.text.toString().toDouble()
            }catch (e:java.lang.Exception){
                imc.setText("Debe ingresar valores reales")
                println(e)
            }

            var resultado = calcularIMC(estatura,peso)
            val formattedNumber = "%.2f".format(resultado)
            imc.setText(formattedNumber)

            var salud: String
            var color: Int

            when{
                resultado < 18.5->{
                    salud = "Bajo peso"
                    color = R.color.colorGreenish
                }
                resultado < 18.5->{
                    salud = "Saludable"
                    color = R.color.colorGreen
                }
                resultado < 18.5->{
                    salud = "Sobrepeso"
                    color = R.color.colorYellow
                }
                resultado < 18.5->{
                    salud = "Obesidad  grado 1"
                    color = R.color.colorOrange
                }
                resultado < 18.5->{
                    salud = "Obesidad grado 2"
                    color = R.color.colorRed
                }
                resultado < 18.5->{
                    salud = "Obesidad grado 3"
                    color = R.color.colorBrown
                }
                else ->{
                    salud = "Error"
                    color = 0
                }
            }

            txtEstado.setBackgroundResource(color)
            txtEstado.setText(salud)
        }
    }

    fun calcularIMC(altura:Double, peso:Double):Double{
        return peso / (altura * altura)
    }
}