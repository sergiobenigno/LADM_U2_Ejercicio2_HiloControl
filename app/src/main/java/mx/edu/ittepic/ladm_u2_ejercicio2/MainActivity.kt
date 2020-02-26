package mx.edu.ittepic.ladm_u2_ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var contador = 0
    var hiloControl : HiloControl?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hiloControl = HiloControl(this)
        setTitle("ESTADO: "+hiloControl!!.isAlive)

        button.setOnClickListener {
            try {
                if(hiloControl!!.estaIniciado()){
                    Mensaje("Error, hilo ya está iniciado")
                    return@setOnClickListener
                }
                hiloControl?.start()
                setTitle("ESTADO: "+hiloControl!!.isAlive)
            }catch (e:Exception){
                setTitle("ESTADO: "+hiloControl!!.isAlive)
                Mensaje("EXCEPCION: Hilo ya fue detenido")
            }
        }

        button2.setOnClickListener {
            hiloControl?.pausar()
        }

        button3.setOnClickListener {
            hiloControl?.despausar()
        }

        button4.setOnClickListener {
            contador = 0
        }

        button5.setOnClickListener {
            hiloControl!!.detener()
            setTitle("ESTADO: "+hiloControl!!.isAlive)
        }
    }

    private fun Mensaje(s: String) {
        AlertDialog.Builder(this)
            .setMessage(s)
            .setTitle("ATENCION")
            .setPositiveButton("OK"){d,i->}
            .show()
    }
}


