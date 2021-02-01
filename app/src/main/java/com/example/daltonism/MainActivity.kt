package com.example.daltonism

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var teste1Button: Button
    lateinit var teste2Button: Button
    lateinit var teste3Button: Button
    lateinit var verificarButton: Button
    lateinit var resposta1TextView: TextView
    lateinit var resposta2TextView: TextView
    lateinit var resposta3TextView: TextView
    lateinit var resultadoTextView: TextView
    var resposta_1:Int? = 0
    var resposta_2:Int? = 0
    var resposta_3:Int? = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resposta1TextView = findViewById(R.id.resposta1TextView)
        resposta2TextView = findViewById(R.id.resposta2TextView)
        resposta3TextView = findViewById(R.id.resposta3TextView)
        resultadoTextView = findViewById(R.id.resultadoTextView)
        teste1Button = findViewById(R.id.teste1Button)
        teste2Button = findViewById(R.id.teste2Button)
        teste3Button = findViewById(R.id.teste3Button)
        verificarButton = findViewById(R.id.verificarButton)

        resposta1TextView.setText(resposta_1.toString())
        resposta2TextView.setText(resposta_2.toString())
        resposta3TextView.setText(resposta_3.toString())

        resultadoTextView.setText("")

        teste1Button.setOnClickListener {
            val intent = Intent(this, TesteActivity::class.java)
            val param = Bundle()
            val requestCode = 1

            param.putString("IMAGEM", "teste1")
            intent.putExtras(param)
            startActivityForResult(intent, requestCode)
        }

        teste2Button.setOnClickListener {
            val intent = Intent(this, TesteActivity::class.java)
            val param = Bundle()
            val requestCode = 2

            param.putString("IMAGEM", "teste2")
            intent.putExtras(param)
            startActivityForResult(intent,requestCode)
        }

        teste3Button.setOnClickListener {
            val intent = Intent(this, TesteActivity::class.java)
            val param = Bundle()
            val requestCode = 3

            param.putString("IMAGEM", "teste3")
            intent.putExtras(param)
            startActivityForResult(intent,requestCode)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1 -> {
                when(resultCode){
                    Activity.RESULT_OK ->{
                        val param:Bundle? = data?.extras
                        this.resposta_1 = param?.getInt("RESULTADO")
                        resposta1TextView.setText(resposta_1.toString())
                        Toast.makeText(this, "Resposta 1 recebida!", Toast.LENGTH_SHORT).show()
                    }
                    Activity.RESULT_CANCELED ->{
                        Toast.makeText(this, "Cancelado pelo usuário.", Toast.LENGTH_SHORT).show()
                    }

                }
            }
            2 -> {
                when(resultCode){
                    Activity.RESULT_OK ->{
                        val param:Bundle? = data?.extras
                        this.resposta_2 = param?.getInt("RESULTADO")
                        resposta2TextView.setText(resposta_2.toString())
                        Toast.makeText(this, "Resposta 2 recebida!", Toast.LENGTH_SHORT).show()
                    }
                    Activity.RESULT_CANCELED ->{
                        Toast.makeText(this, "Cancelado pelo usuário.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            3 -> {
                when(resultCode){
                    Activity.RESULT_OK ->{
                        val param:Bundle? = data?.extras
                        this.resposta_3 = param?.getInt("RESULTADO")
                        resposta3TextView.setText(resposta_3.toString())
                        Toast.makeText(this, "Resposta 3 recebida!", Toast.LENGTH_SHORT).show()
                    }
                    Activity.RESULT_CANCELED ->{
                        Toast.makeText(this, "Cancelado pelo usuário.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        verificarButton.setOnClickListener {
            if (resposta_1 == 29 && resposta_2 == 74 && resposta_3 == 2){
                resultadoTextView.setText("Visão normal.")
            }else{
                resultadoTextView.setText("Possivelmente Daltônico, recomenda-se atenção médica.")
            }
        }
    }
}