package com.example.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class EndGame : AppCompatActivity() {

    private lateinit var wplayer : TextView
    private lateinit var playagain : Button
    private var qula1 = 0
    private var qula2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)

        wplayer = findViewById(R.id.playerx)
        playagain = findViewById(R.id.playagain)

        qula1 = intent.getIntExtra("s1",0)
        qula2 = intent.getIntExtra("s2",0)

        if(qula1 > qula2){
            wplayer.text = intent.getStringExtra("p1")
        } else if(qula2 > qula1){
            wplayer.text = intent.getStringExtra("p2")

        } else if (qula1==qula2){
           wplayer.text = "Friendship"
        }

        again()

    }

    private fun again() {
        playagain.setOnClickListener{
            val inetnt= Intent(this,Entername::class.java).also {
                startActivity(it)
            }
        }
    }
}