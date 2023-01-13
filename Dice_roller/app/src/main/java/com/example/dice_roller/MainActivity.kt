package com.example.dice_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.Math.random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonRoll: Button = findViewById(R.id.button)
        //If buttonRoll with id: button is clicked, call dice roll
        buttonRoll.setOnClickListener {
            diceRoll()
        }
    }



    //This function create a Dice object with arg 6, and change the resultView.text with the return of the method roll of the Dice object
    private fun diceRoll() {
        val dice = Dice(6)
        val resultView: TextView = findViewById(R.id.textView)
        if ( dice.roll() == dice.luckyNumber()){
            resultView.text = "Congratulations, you won \n${dice.roll()}"
        }
        else{
            resultView.text = "Sorry, you lose \n${dice.roll()}"
        }

    }
}

//Class Dice, has a private arg, type int
//has a method roll, search a random number between 1 and numSides

class Dice(private val numSides: Int) {

    fun luckyNumber(): Int{
        return (1..numSides).random()
    }

    fun roll(): Int {
        return (1..numSides).random()
    }
}