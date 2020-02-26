package mx.edu.ittepic.ladm_u2_ejercicio2

import kotlinx.android.synthetic.main.activity_main.*

class HiloControl (p:MainActivity) : Thread(){
    private var iniciado = false
    private var puntero = p
    private var pausa = false

    override fun run() {
        super.run()
        iniciado = true
        while(iniciado){
            sleep(200)
            if(!pausa){
                puntero.runOnUiThread {
                    puntero.textView.setText(puntero.contador.toString())
                    puntero.contador++
                }
            }
        }

    }

    fun estaIniciado(): Boolean {
        return iniciado
    }

    fun pausar() {
        pausa = true
    }

    fun despausar() {
        pausa = false
    }

    fun detener() {
        iniciado = false
    }
}