package com.example.daltonism

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class TesteActivity : AppCompatActivity() {

    lateinit var testeImageview: ImageView
    lateinit var cancelarButton: Button
    lateinit var enviarButton: Button
    lateinit var respostaEditTextNumber:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teste)


        val param:Bundle? = intent.extras
        var receipt:String? = param?.getString("IMAGEM")



        testeImageview = findViewById(R.id.testeImageView)
        cancelarButton = findViewById(R.id.cancelarButton)
        respostaEditTextNumber = findViewById(R.id.respostaEditTextNumber)
        enviarButton = findViewById(R.id.enviarButton)

        when(receipt){
            "teste1" -> testeImageview.setImageResource(R.drawable.teste1)
            "teste2" -> testeImageview.setImageResource(R.drawable.teste2)
            "teste3" -> testeImageview.setImageResource(R.drawable.teste3)
        }

        cancelarButton.setOnClickListener {

            finish()

        }

        enviarButton.setOnClickListener {
            val i = Intent()
            if(!(respostaEditTextNumber.text.isEmpty())) {
                i.putExtra("RESULTADO", Integer.parseInt(respostaEditTextNumber.text.toString()))
                setResult(Activity.RESULT_OK, i)
                finish()
            }else{
                Toast.makeText(this, "Espaço vazio, favor preencher.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
