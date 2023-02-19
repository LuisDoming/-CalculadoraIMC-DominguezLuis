package mx.itson.edu.asignacion4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pesoK: TextView = findViewById(R.id.txtPeso)
        val alturaE: TextView = findViewById(R.id.txtAltura)
        val imc: TextView = findViewById(R.id.txtResultado)
        val rango: TextView = findViewById(R.id.txtEstado)
        val calcular: Button = findViewById(R.id.btnCalcular)

        calcular.setOnClickListener{
            //convertir los kilos y la altura a Double
            var peso: Double = 0.0
            var estatura: Double = 0.0

            try{
                peso = pesoK.text.toString().toDouble()
                estatura = alturaE.text.toString().toDouble()
            }catch (e: java.lang.Exception){
                imc.setText("Debe ingresar valores reales")
                println(e)
            }
            var resultado = calcularIMC(estatura, peso)
            val formattedNumber = "%.2f".format(resultado)
            imc.setText(formattedNumber)

            var salud: String
            var color: Int

            when{
                resultado < 18.5 ->{
                    salud = "Bajo peso"
                    color = R.color.colorGreen
                }
                resultado >= 18.5 && resultado <=24.9 ->{
                    salud = "Saludable"
                    color = R.color.colorGreenish
                }
                resultado > 25 && resultado<=29.9 ->{
                    salud = "Sobrepeso"
                    color = R.color.colorYellow
                }
                resultado > 30 && resultado <= 34.9 ->{
                    salud = "Obesidad grado 1"
                    color = R.color.colorOrange
                }
                resultado >= 35 && resultado <= 39.9 ->{
                    salud = "Obesidad grado 3"
                    color = R.color.colorBrown
                }
                resultado >= 40 ->{
                    salud = "Obesidad grado 3"
                    color = R.color.colorRed
                }
                else ->{
                    salud = "Error"
                    color = 0
                }
            }

            rango.setBackgroundResource(color)
            rango.setText(salud)
        }
    }

    fun calcularIMC(height:Double, weigth:Double):Double{
        return weigth / (height * weigth)
    }
}