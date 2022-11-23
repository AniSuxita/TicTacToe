package com.example.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Entername : AppCompatActivity() {

    private lateinit var name1 : EditText
    private lateinit var name2 : EditText
    private lateinit var start : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entername)

        name1 = findViewById(R.id.entername1)
        name2 = findViewById(R.id.entername2)
        start = findViewById(R.id.start)

            starting()

        }
    private fun starting() {


        start.setOnClickListener{
            if (name1.text.toString() ==""||name2.text.toString()=="" ){

                Toast.makeText( applicationContext,"გთხოვთ ჩაწეროთ სახელი", Toast.LENGTH_LONG).show()
            } else if (name1.text.toString().length>10||name2.text.toString().length>10) {
                Toast.makeText( applicationContext,"ჩაწერილი სახელი ძალიან გრძელია", Toast.LENGTH_LONG).show()
            } else {
            var name1= name1.text.toString()
            var name2= name2.text.toString()

            val intent = Intent(this,MainActivity::class.java).also {
                it.putExtra("player 1",name1)
                it.putExtra("player 2",name2)

                startActivity(it)
            }

        }
    }
}
}