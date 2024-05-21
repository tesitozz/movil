package com.example.appcomida

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //declarar atributos de segun los controles que estan en la pantalla
    private lateinit var spnProducto:Spinner
    private lateinit var edtCantidad:EditText
    private lateinit var tvPrecio:TextView
    private lateinit var tvTotal:TextView
    private lateinit var chkDelivery:CheckBox
    private lateinit var tvDescuento:TextView
    private lateinit var tvPagar:TextView
    private lateinit var btnCalcular:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //referencar los atributos con los controles
        spnProducto=findViewById(R.id.spnProducto)
        edtCantidad=findViewById(R.id.edtCantidad)
        tvPrecio=findViewById(R.id.tvPrecio)
        tvTotal=findViewById(R.id.tvTotal)
        chkDelivery=findViewById(R.id.chkDelivery)
        tvDescuento=findViewById(R.id.tvDescuento)
        tvPagar=findViewById(R.id.tvTotalPagar)
        btnCalcular=findViewById(R.id.btnCalcular)

        //asignar eventd click al atributo "btnCalcular"
        btnCalcular.setOnClickListener { calcular() }
    }
    //Crear funcion calcular
    fun calcular(){
        //variables
        var posProd:Int
        var can:Int
        var deli=0
        var pre:Double
        var total:Double
        var des:Int=0
        var pagar:Double

        //entrada
        posProd=spnProducto.selectedItemPosition
        can=edtCantidad.text.toString().toInt()

        //proceso
        when(posProd){
            0-> pre=0.0
            1-> pre=65.5
            2-> pre=34.5
            3-> pre=18.5
            4-> pre=17.5
            else -> pre=21.5
        }
        total=pre*can
        if (chkDelivery.isChecked)
            deli=10
        if(total>60)
            des=5
        pagar=(total+deli)-des

        //salida
        tvPrecio.setText("S/. "+pre)
        tvTotal.setText("S/. "+total)
        tvDescuento.setText("S/. "+des)
        tvPagar.setText("S/. "+pagar)
    }
}
