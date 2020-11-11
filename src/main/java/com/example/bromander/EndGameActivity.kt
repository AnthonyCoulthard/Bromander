package com.example.bromander

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EndGameActivity: AppCompatActivity() {

    //Variables for scorekeeping
    var points1: Int = 420
    var points2: Int = 420
    var points3: Int = 420
    var points4: Int = 420

    //Variables for layout elements
    lateinit var player1Text: TextView
    lateinit var player2Text: TextView
    lateinit var player3Text: TextView
    lateinit var player4Text: TextView
    lateinit var player1Points: EditText
    lateinit var player2Points: EditText
    lateinit var player3Points: EditText
    lateinit var player4Points: EditText
    lateinit var resumeGame: Button
    lateinit var endGame: Button

    //Variables from saved game state of MainActivity
    var lifeTotal1: Int = 40
    var lifeTotal2: Int = 40
    var lifeTotal3: Int = 40
    var lifeTotal4: Int = 40
    var white1CounterInt: Int = 0
    var blue1CounterInt: Int = 0
    var black1CounterInt: Int = 0
    var red1CounterInt: Int = 0
    var green1CounterInt: Int = 0
    var white2CounterInt: Int = 0
    var blue2CounterInt: Int = 0
    var black2CounterInt: Int = 0
    var red2CounterInt: Int = 0
    var green2CounterInt: Int = 0
    var white3CounterInt: Int = 0
    var blue3CounterInt: Int = 0
    var black3CounterInt: Int = 0
    var red3CounterInt: Int = 0
    var green3CounterInt: Int = 0
    var white4CounterInt: Int = 0
    var blue4CounterInt: Int = 0
    var black4CounterInt: Int = 0
    var red4CounterInt: Int = 0
    var green4CounterInt: Int = 0
    var player1Counter2Int: Int = 0
    var player1Counter3Int: Int = 0
    var player1Counter4Int: Int = 0
    var player2Counter3Int: Int = 0
    var player2Counter4Int: Int = 0
    var player2Counter1Int: Int = 0
    var player3Counter4Int: Int = 0
    var player3Counter1Int: Int = 0
    var player3Counter2Int: Int = 0
    var player4Counter1Int: Int = 0
    var player4Counter2Int: Int = 0
    var player4Counter3Int: Int = 0
    var turnStatus: Int = 0
    var additionalTime: Int = 0
    var player1TimeRemaining: Int = 300
    var player2TimeRemaining: Int = 300
    var player3TimeRemaining: Int = 300
    var player4TimeRemaining: Int = 300
    var playerTimer: Int = 300
    var currentPlayer: Int = 1
    var endTurnString: String = "END"
    var skipTurnString: String = "SKIP"
    var displayManaCounters1: Boolean = false
    var displayManaCounters2: Boolean = false
    var displayManaCounters3: Boolean = false
    var displayManaCounters4: Boolean = false
    var displayDamageCounters1: Boolean = false
    var displayDamageCounters2: Boolean = false
    var displayDamageCounters3: Boolean = false
    var displayDamageCounters4: Boolean = false
    var displayShiftedLifeTotal1: Boolean = false
    var displayShiftedLifeTotal2: Boolean = false
    var displayShiftedLifeTotal3: Boolean = false
    var displayShiftedLifeTotal4: Boolean = false
    var isPaused: Boolean = true
    
    //Create activity
    override fun onCreate(savedInstanceState: Bundle?) {
        //Load activity
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game_landscape)

        //Initiate layout elements
        player1Text = findViewById(R.id.player1Text)
        player2Text = findViewById(R.id.player2Text)
        player3Text = findViewById(R.id.player3Text)
        player4Text = findViewById(R.id.player4Text)
        player1Points = findViewById(R.id.player1Points)
        player2Points = findViewById(R.id.player2Points)
        player3Points = findViewById(R.id.player3Points)
        player4Points = findViewById(R.id.player4Points)
        resumeGame = findViewById(R.id.resumeGame)
        endGame = findViewById(R.id.endGame)

        //Load values into points text
        /*
        player1Points.setText(points1.toString())
        player2Points.setText(points2.toString())
        player3Points.setText(points3.toString())
        player4Points.setText(points4.toString())

         */

        //Set onClickListener to resume game
        resumeGame.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent, savedInstanceState)
        }

        //Set onChangedListeners for changing points values
        player1Points.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int) {
                try {
                    points1 = player1Points.text.toString().toInt()
                }
                catch (e: Exception){
                    Toast.makeText(this@EndGameActivity, "MissingNo.", Toast.LENGTH_SHORT).show()
                    player1Points.setText(points1.toString())
                }
            }
        })
        player2Points.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int) {
                try {
                    points2 = player2Points.text.toString().toInt()
                }
                catch (e: Exception){
                    Toast.makeText(this@EndGameActivity, "MissingNo.", Toast.LENGTH_SHORT).show()
                    player2Points.setText(points2.toString())
                }
            }
        })
        player3Points.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int) {
                try {
                    points3 = player3Points.text.toString().toInt()
                }
                catch (e: Exception){
                    Toast.makeText(this@EndGameActivity, "MissingNo.", Toast.LENGTH_SHORT).show()
                    player3Points.setText(points3.toString())
                }
            }
        })
        player4Points.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int) {
                try {
                    points4 = player4Points.text.toString().toInt()
                }
                catch (e: Exception){
                    Toast.makeText(this@EndGameActivity, "MissingNo.", Toast.LENGTH_SHORT).show()
                    player4Points.setText(points4.toString())
                }
            }
        })
    }

    //Save instantiated variables from EndGameActivity
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        //Load saved bundle
        super.onSaveInstanceState(savedInstanceState)

        //Put variables in the bundle
        savedInstanceState.putInt("lifeTotal1", lifeTotal1)
        savedInstanceState.putInt("lifeTotal2", lifeTotal2)
        savedInstanceState.putInt("lifeTotal3", lifeTotal3)
        savedInstanceState.putInt("lifeTotal4", lifeTotal4)
        savedInstanceState.putInt("white1CounterInt", white1CounterInt)
        savedInstanceState.putInt("blue1CounterInt", blue1CounterInt)
        savedInstanceState.putInt("black1CounterInt", black1CounterInt)
        savedInstanceState.putInt("red1CounterInt", red1CounterInt)
        savedInstanceState.putInt("green1CounterInt", green1CounterInt)
        savedInstanceState.putInt("white2CounterInt", white2CounterInt)
        savedInstanceState.putInt("blue2CounterInt", blue2CounterInt)
        savedInstanceState.putInt("black2CounterInt", black2CounterInt)
        savedInstanceState.putInt("red2CounterInt", red2CounterInt)
        savedInstanceState.putInt("green2CounterInt", green2CounterInt)
        savedInstanceState.putInt("white3CounterInt", white3CounterInt)
        savedInstanceState.putInt("blue3CounterInt", blue3CounterInt)
        savedInstanceState.putInt("black3CounterInt", black3CounterInt)
        savedInstanceState.putInt("red3CounterInt", red3CounterInt)
        savedInstanceState.putInt("green3CounterInt", green3CounterInt)
        savedInstanceState.putInt("white4CounterInt", white4CounterInt)
        savedInstanceState.putInt("blue4CounterInt", blue4CounterInt)
        savedInstanceState.putInt("black4CounterInt", black4CounterInt)
        savedInstanceState.putInt("red4CounterInt", red4CounterInt)
        savedInstanceState.putInt("green4CounterInt", green4CounterInt)
        savedInstanceState.putInt("player1Counter2Int", player1Counter2Int)
        savedInstanceState.putInt("player1Counter3Int", player1Counter3Int)
        savedInstanceState.putInt("player1Counter4Int", player1Counter4Int)
        savedInstanceState.putInt("player2Counter3Int", player2Counter3Int)
        savedInstanceState.putInt("player2Counter4Int", player2Counter4Int)
        savedInstanceState.putInt("player2Counter1Int", player2Counter1Int)
        savedInstanceState.putInt("player3Counter4Int", player3Counter4Int)
        savedInstanceState.putInt("player3Counter1Int", player3Counter1Int)
        savedInstanceState.putInt("player3Counter2Int", player3Counter2Int)
        savedInstanceState.putInt("player4Counter1Int", player4Counter1Int)
        savedInstanceState.putInt("player4Counter2Int", player4Counter2Int)
        savedInstanceState.putInt("player4Counter3Int", player4Counter3Int)
        savedInstanceState.putInt("turnStatus", turnStatus)
        savedInstanceState.putInt("additionalTime", additionalTime)
        savedInstanceState.putInt("player1TimeRemaining", player1TimeRemaining)
        savedInstanceState.putInt("player2TimeRemaining", player2TimeRemaining)
        savedInstanceState.putInt("player3TimeRemaining", player3TimeRemaining)
        savedInstanceState.putInt("player4TimeRemaining", player4TimeRemaining)
        savedInstanceState.putInt("playerTimer", playerTimer)
        savedInstanceState.putInt("currentPlayer", currentPlayer)
        savedInstanceState.putString("endTurnString", endTurnString)
        savedInstanceState.putString("skipTurnString", skipTurnString)
        savedInstanceState.putBoolean("displayManaCounters1", displayManaCounters1)
        savedInstanceState.putBoolean("displayManaCounters2", displayManaCounters2)
        savedInstanceState.putBoolean("displayManaCounters3", displayManaCounters3)
        savedInstanceState.putBoolean("displayManaCounters4", displayManaCounters4)
        savedInstanceState.putBoolean("displayDamageCounters1", displayDamageCounters1)
        savedInstanceState.putBoolean("displayDamageCounters2", displayDamageCounters2)
        savedInstanceState.putBoolean("displayDamageCounters3", displayDamageCounters3)
        savedInstanceState.putBoolean("displayDamageCounters4", displayDamageCounters4)
        savedInstanceState.putBoolean("displayShiftedLifeTotal1", displayShiftedLifeTotal1)
        savedInstanceState.putBoolean("displayShiftedLifeTotal2", displayShiftedLifeTotal2)
        savedInstanceState.putBoolean("displayShiftedLifeTotal3", displayShiftedLifeTotal3)
        savedInstanceState.putBoolean("displayShiftedLifeTotal4", displayShiftedLifeTotal4)
        savedInstanceState.putBoolean("isPaused", isPaused)
        savedInstanceState.putInt("points1", points1)
        savedInstanceState.putInt("points2", points2)
        savedInstanceState.putInt("points3", points3)
        savedInstanceState.putInt("points4", points4)
    }

    //Restore instantiated variables from MainActivity
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        //Load saved bundle
        super.onRestoreInstanceState(savedInstanceState)

        //Assign to variables
        lifeTotal1 = savedInstanceState.getInt("lifeTotal1")
        player1Points.setText(points1.toString())
        lifeTotal2 = savedInstanceState.getInt("lifeTotal2")
        lifeTotal3 = savedInstanceState.getInt("lifeTotal3")
        lifeTotal4 = savedInstanceState.getInt("lifeTotal4")
        white1CounterInt = savedInstanceState.getInt("white1CounterInt")
        blue1CounterInt = savedInstanceState.getInt("blue1CounterInt")
        black1CounterInt = savedInstanceState.getInt("black1CounterInt")
        red1CounterInt = savedInstanceState.getInt("red1CounterInt")
        green1CounterInt = savedInstanceState.getInt("green1CounterInt")
        white2CounterInt = savedInstanceState.getInt("white2CounterInt")
        blue2CounterInt = savedInstanceState.getInt("blue2CounterInt")
        black2CounterInt = savedInstanceState.getInt("black2CounterInt")
        red2CounterInt = savedInstanceState.getInt("red2CounterInt")
        green2CounterInt = savedInstanceState.getInt("green2CounterInt")
        white3CounterInt = savedInstanceState.getInt("white3CounterInt")
        blue3CounterInt = savedInstanceState.getInt("blue3CounterInt")
        black3CounterInt = savedInstanceState.getInt("black3CounterInt")
        red3CounterInt = savedInstanceState.getInt("red3CounterInt")
        green3CounterInt = savedInstanceState.getInt("green3CounterInt")
        white4CounterInt = savedInstanceState.getInt("white4CounterInt")
        blue4CounterInt = savedInstanceState.getInt("blue4CounterInt")
        black4CounterInt = savedInstanceState.getInt("black4CounterInt")
        red4CounterInt = savedInstanceState.getInt("red4CounterInt")
        green4CounterInt = savedInstanceState.getInt("green4CounterInt")
        player1Counter2Int = savedInstanceState.getInt("player1Counter2Int")
        player1Counter3Int = savedInstanceState.getInt("player1Counter3Int")
        player1Counter4Int = savedInstanceState.getInt("player1Counter4Int")
        player2Counter3Int = savedInstanceState.getInt("player2Counter3Int")
        player2Counter4Int = savedInstanceState.getInt("player2Counter4Int")
        player2Counter1Int = savedInstanceState.getInt("player2Counter1Int")
        player3Counter4Int = savedInstanceState.getInt("player3Counter4Int")
        player3Counter1Int = savedInstanceState.getInt("player3Counter1Int")
        player3Counter2Int = savedInstanceState.getInt("player3Counter2Int")
        player4Counter1Int = savedInstanceState.getInt("player4Counter1Int")
        player4Counter2Int = savedInstanceState.getInt("player4Counter2Int")
        player4Counter3Int = savedInstanceState.getInt("player4Counter3Int")
        turnStatus = savedInstanceState.getInt("turnStatus")
        additionalTime = savedInstanceState.getInt("additionalTime")
        player1TimeRemaining = savedInstanceState.getInt("player1TimeRemaining")
        player2TimeRemaining = savedInstanceState.getInt("player2TimeRemaining")
        player3TimeRemaining = savedInstanceState.getInt("player3TimeRemaining")
        player4TimeRemaining = savedInstanceState.getInt("player4TimeRemaining")
        playerTimer = savedInstanceState.getInt("playerTimer")
        currentPlayer = savedInstanceState.getInt("currentPlayer")
        endTurnString = savedInstanceState.getString("endTurnString")
        skipTurnString = savedInstanceState.getString("skipTurnString")
        displayManaCounters1 = savedInstanceState.getBoolean("displayManaCounters1")
        displayManaCounters2 = savedInstanceState.getBoolean("displayManaCounters2")
        displayManaCounters3 = savedInstanceState.getBoolean("displayManaCounters3")
        displayManaCounters4 = savedInstanceState.getBoolean("displayManaCounters4")
        displayDamageCounters1 = savedInstanceState.getBoolean("displayDamageCounters1")
        displayDamageCounters2 = savedInstanceState.getBoolean("displayDamageCounters2")
        displayDamageCounters3 = savedInstanceState.getBoolean("displayDamageCounters3")
        displayDamageCounters4 = savedInstanceState.getBoolean("displayDamageCounters4")
        displayShiftedLifeTotal1 = savedInstanceState.getBoolean("displayShiftedLifeTotal1")
        displayShiftedLifeTotal2 = savedInstanceState.getBoolean("displayShiftedLifeTotal2")
        displayShiftedLifeTotal3 = savedInstanceState.getBoolean("displayShiftedLifeTotal3")
        displayShiftedLifeTotal4 = savedInstanceState.getBoolean("displayShiftedLifeTotal4")
        isPaused = savedInstanceState.getBoolean("isPaused")
        points1 = savedInstanceState.getInt("points1")
        points2 = savedInstanceState.getInt("points2")
        points3 = savedInstanceState.getInt("points3")
        points4 = savedInstanceState.getInt("points4")

        Log.i("MainActivity", "> EndGameActivity")
    }
}