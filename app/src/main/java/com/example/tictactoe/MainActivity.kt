package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var buttonReset: Button
    private lateinit var buttonEnd: Button
    private lateinit var nameplayer1: TextView
    private lateinit var nameplayer2: TextView
    private lateinit var score1: TextView
    private lateinit var score2: TextView


    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()
    private var score1i = 0
    private var score2i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        score1 = findViewById(R.id.score1)
        score2 = findViewById(R.id.score2)
        nameplayer1=findViewById(R.id.nameplayer1)
        nameplayer2=findViewById(R.id.nameplayer2)

        nameplayer1.apply {
          text = intent.getStringExtra("player 1")+" : "
        }
        nameplayer2.apply {
            text = intent.getStringExtra("player 2")+" : "
        }


        init()
    }

    private fun init() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonReset = findViewById(R.id.buttonReset)
        buttonEnd = findViewById(R.id.buttonEnd)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        buttonReset.setOnClickListener(this)
        buttonEnd.setOnClickListener(this)
    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            var buttonNumber = 0
            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }
            if (buttonNumber != 0) {
                playGame(clickedView, buttonNumber)
            }

        }

    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {

        if (activePlayer == 1) {
            clickedView.text = "X"
            //clickedView.setTextColor(Color.BLUE)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        } else if (activePlayer == 2) {
            clickedView.text = "O"
            //clickedView.setTextColor(Color.MAGENTA)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }


        clickedView.isEnabled = false
        check()
        reset(clickedView)
        end()


    }



    private fun check() {
        var winnerPlayer = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (winnerPlayer == 1) {
            Toast.makeText(this, "Moigo pirvelma motamashem", Toast.LENGTH_LONG).show()
            score1i += 1
            score1.text=score1i.toString()

        }
        if (winnerPlayer == 2) {
            Toast.makeText(this, "Moigo meore motamashem", Toast.LENGTH_LONG).show()

            score2i += 1
            score2.text=score2i.toString()
        }
        if (firstPlayer.size + secondPlayer.size == 9 && winnerPlayer == 0) {
            Toast.makeText(this, "frea", Toast.LENGTH_LONG).show()

        }


    }

    private fun reset(clickedView:Button) {
        buttonReset.setOnClickListener {
            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""
            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = true
            button4.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button8.isEnabled = true
            button9.isEnabled = true
            buttonReset.isEnabled = true
            activePlayer = 1
            firstPlayer = ArrayList()
            secondPlayer = ArrayList()

        }
    }

    private fun end() {
        buttonEnd.setOnClickListener{button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""
            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = true
            button4.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button8.isEnabled = true
            button9.isEnabled = true
            buttonReset.isEnabled = true
            activePlayer = 1
            firstPlayer = ArrayList()
            secondPlayer = ArrayList()

            val intent2=Intent(this,EndGame::class.java).also {
                it.putExtra("p1",nameplayer1.text.dropLast(3))
                it.putExtra("p2",nameplayer2.text.dropLast(3))
                it.putExtra("s1",score1i)
                it.putExtra("s2",score2i)

                startActivity(it)
            }

        }
    }


}