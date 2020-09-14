package com.example.bromander

import android.app.Activity
import android.app.Fragment
import android.content.ComponentCallbacks2
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.GestureDetector
import android.view.KeyEvent
import android.view.View
import android.view.View.INVISIBLE
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.view.MotionEvent
import android.view.View.OnLongClickListener
import android.widget.*
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    //Variables for tap gestures
    //lateinit var gestureDetector: GestureDetector
    //var doubleTapped = false
    val doubleTapTimeout = 300
    var lastClickTime = 0

    //Variables for XML elements of activity_main.xml
    lateinit var endTurn: Button
    /*
    lateinit var player1Text: TextView
    lateinit var player2Text: TextView
    lateinit var player3Text: TextView
    lateinit var player4Text: TextView
    lateinit var plus1: Button
    lateinit var plus2: Button
    lateinit var plus3: Button
    lateinit var plus4: Button
    lateinit var minus1: Button
    lateinit var minus2: Button
    lateinit var minus3: Button
    lateinit var minus4: Button
     */
    lateinit var player1Background: View
    lateinit var player2Background: View
    lateinit var player3Background: View
    lateinit var player4Background: View
    lateinit var hiddenPlus1: Button
    lateinit var hiddenPlus2: Button
    lateinit var hiddenPlus3: Button
    lateinit var hiddenPlus4: Button
    lateinit var hiddenMinus1: Button
    lateinit var hiddenMinus2: Button
    lateinit var hiddenMinus3: Button
    lateinit var hiddenMinus4: Button
    lateinit var life1: TextView
    lateinit var life2: TextView
    lateinit var life3: TextView
    lateinit var life4: TextView
    lateinit var white1: Button
    lateinit var blue1: Button
    lateinit var black1: Button
    lateinit var red1: Button
    lateinit var green1: Button
    lateinit var white2: Button
    lateinit var blue2: Button
    lateinit var black2: Button
    lateinit var red2: Button
    lateinit var green2: Button
    lateinit var white3: Button
    lateinit var blue3: Button
    lateinit var black3: Button
    lateinit var red3: Button
    lateinit var green3: Button
    lateinit var white4: Button
    lateinit var blue4: Button
    lateinit var black4: Button
    lateinit var red4: Button
    lateinit var green4: Button
    lateinit var white1down: Button
    lateinit var blue1down: Button
    lateinit var black1down: Button
    lateinit var red1down: Button
    lateinit var green1down: Button
    lateinit var white2down: Button
    lateinit var blue2down: Button
    lateinit var black2down: Button
    lateinit var red2down: Button
    lateinit var green2down: Button
    lateinit var white3down: Button
    lateinit var blue3down: Button
    lateinit var black3down: Button
    lateinit var red3down: Button
    lateinit var green3down: Button
    lateinit var white4down: Button
    lateinit var blue4down: Button
    lateinit var black4down: Button
    lateinit var red4down: Button
    lateinit var green4down: Button
    lateinit var white1Counter: TextView
    lateinit var blue1Counter: TextView
    lateinit var black1Counter: TextView
    lateinit var red1Counter: TextView
    lateinit var green1Counter: TextView
    lateinit var white2Counter: TextView
    lateinit var blue2Counter: TextView
    lateinit var black2Counter: TextView
    lateinit var red2Counter: TextView
    lateinit var green2Counter: TextView
    lateinit var white3Counter: TextView
    lateinit var blue3Counter: TextView
    lateinit var black3Counter: TextView
    lateinit var red3Counter: TextView
    lateinit var green3Counter: TextView
    lateinit var white4Counter: TextView
    lateinit var blue4Counter: TextView
    lateinit var black4Counter: TextView
    lateinit var red4Counter: TextView
    lateinit var green4Counter: TextView
    lateinit var progressBar: CircleProgressBar

    //Additional global variables
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
    var lifeHeld: Boolean = false
    var turnStatus: Int = 0
    val handler = Handler()
    var player1TimeRemaining: Int = 10
    var player2TimeRemaining: Int = 10
    var player3TimeRemaining: Int = 10
    var player4TimeRemaining: Int = 10
    var playerTimer: Int = 10
    var currentPlayer: Int = 1
    val endTurnString: String = "END"
    val skipTurnString: String = "SKIP"

    //Variable for turn timer object
    var timeOutRemoveTimer = object : CountDownTimer(playerTimer*1000L, 10) {
        override fun onFinish() {
            progressBar.progress = 1f
            turnStatus = playerTimer
            endTurn.setTextColor(Color.parseColor("#ffffff"))
            endTurn.text = endTurnString
            if (currentPlayer == 1) {
                player1Background.setBackgroundColor(Color.parseColor("#f440e4"))
                endTurn.rotation = 90f
            } else if (currentPlayer == 2) {
                player2Background.setBackgroundColor(Color.parseColor("#f440e4"))
                endTurn.rotation = 270f
            } else if (currentPlayer == 3) {
                player3Background.setBackgroundColor(Color.parseColor("#f440e4"))
                endTurn.rotation = 270f
            } else {
                player4Background.setBackgroundColor(Color.parseColor("#f440e4"))
                endTurn.rotation = 90f
            }
        }

        override fun onTick(millisUntilFinished: Long) {
            progressBar.progress = (playerTimer*1000L - millisUntilFinished).toFloat()/(playerTimer*1000L)
            if((playerTimer*1000L - millisUntilFinished)/1000 > turnStatus){
                turnStatus++
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize variables for XML elements
        life1 = findViewById(R.id.life1)
        life2 = findViewById(R.id.life2)
        life3 = findViewById(R.id.life3)
        life4 = findViewById(R.id.life4)
        player1Background = findViewById(R.id.player1Background)
        player2Background = findViewById(R.id.player2Background)
        player3Background = findViewById(R.id.player3Background)
        player4Background = findViewById(R.id.player4Background)
        hiddenPlus1 = findViewById(R.id.hiddenPlus1)
        hiddenPlus2 = findViewById(R.id.hiddenPlus2)
        hiddenPlus3 = findViewById(R.id.hiddenPlus3)
        hiddenPlus4 = findViewById(R.id.hiddenPlus4)
        hiddenMinus1 = findViewById(R.id.hiddenMinus1)
        hiddenMinus2 = findViewById(R.id.hiddenMinus2)
        hiddenMinus3 = findViewById(R.id.hiddenMinus3)
        hiddenMinus4 = findViewById(R.id.hiddenMinus4)
        white1 = findViewById(R.id.white1)
        blue1 = findViewById(R.id.blue1)
        black1 = findViewById(R.id.black1)
        red1 = findViewById(R.id.red1)
        green1 = findViewById(R.id.green1)
        white2 = findViewById(R.id.white2)
        blue2 = findViewById(R.id.blue2)
        black2 = findViewById(R.id.black2)
        red2 = findViewById(R.id.red2)
        green2 = findViewById(R.id.green2)
        white3 = findViewById(R.id.white3)
        blue3 = findViewById(R.id.blue3)
        black3 = findViewById(R.id.black3)
        red3 = findViewById(R.id.red3)
        green3 = findViewById(R.id.green3)
        white4 = findViewById(R.id.white4)
        blue4 = findViewById(R.id.blue4)
        black4 = findViewById(R.id.black4)
        red4 = findViewById(R.id.red4)
        green4 = findViewById(R.id.green4)
        white1down = findViewById(R.id.white1down)
        blue1down = findViewById(R.id.blue1down)
        black1down = findViewById(R.id.black1down)
        red1down = findViewById(R.id.red1down)
        green1down = findViewById(R.id.green1down)
        white2down = findViewById(R.id.white2down)
        blue2down = findViewById(R.id.blue2down)
        black2down = findViewById(R.id.black2down)
        red2down = findViewById(R.id.red2down)
        green2down = findViewById(R.id.green2down)
        white3down = findViewById(R.id.white3down)
        blue3down = findViewById(R.id.blue3down)
        black3down = findViewById(R.id.black3down)
        red3down = findViewById(R.id.red3down)
        green3down = findViewById(R.id.green3down)
        white4down = findViewById(R.id.white4down)
        blue4down = findViewById(R.id.blue4down)
        black4down = findViewById(R.id.black4down)
        red4down = findViewById(R.id.red4down)
        green4down = findViewById(R.id.green4down)
        white1Counter = findViewById(R.id.white1Counter)
        blue1Counter = findViewById(R.id.blue1Counter)
        black1Counter = findViewById(R.id.black1Counter)
        red1Counter = findViewById(R.id.red1Counter)
        green1Counter = findViewById(R.id.green1Counter)
        white2Counter = findViewById(R.id.white2Counter)
        blue2Counter = findViewById(R.id.blue2Counter)
        black2Counter = findViewById(R.id.black2Counter)
        red2Counter = findViewById(R.id.red2Counter)
        green2Counter = findViewById(R.id.green2Counter)
        white3Counter = findViewById(R.id.white3Counter)
        blue3Counter = findViewById(R.id.blue3Counter)
        black3Counter = findViewById(R.id.black3Counter)
        red3Counter = findViewById(R.id.red3Counter)
        green3Counter = findViewById(R.id.green3Counter)
        white4Counter = findViewById(R.id.white4Counter)
        blue4Counter = findViewById(R.id.blue4Counter)
        black4Counter = findViewById(R.id.black4Counter)
        red4Counter = findViewById(R.id.red4Counter)
        green4Counter = findViewById(R.id.green4Counter)
        endTurn = findViewById(R.id.endTurn)
        progressBar = findViewById(R.id.progressBar)


        //Run turn timer in its own thread
        thread{
            timeOutRemoveTimer.start()
        }


        //Set onClickListeners for life buttons
        hiddenPlus1.setOnClickListener {
            lifeTotal1++
            life1.text = lifeTotal1.toString()
        }
        hiddenPlus2.setOnClickListener {
            lifeTotal2++
            life2.text = lifeTotal2.toString()
        }
        hiddenPlus3.setOnClickListener {
            lifeTotal3++
            life3.text = lifeTotal3.toString()
        }
        hiddenPlus4.setOnClickListener {
            lifeTotal4++
            life4.text = lifeTotal4.toString()
        }
        hiddenMinus1.setOnClickListener {
            if (lifeTotal1 != 0) {
                lifeTotal1--
                life1.text = lifeTotal1.toString()
            }
        }
        hiddenMinus2.setOnClickListener {
            if (lifeTotal2 != 0) {
                lifeTotal2--
                life2.text = lifeTotal2.toString()
            }
        }
        hiddenMinus3.setOnClickListener {
            if (lifeTotal3 != 0) {
                lifeTotal3--
                life3.text = lifeTotal3.toString()
            }
        }
        hiddenMinus4.setOnClickListener {
            if (lifeTotal4 != 0) {
                lifeTotal4--
                life4.text = lifeTotal4.toString()
            }
        }


        //Set onClickListener for ending the turn
        endTurn.setOnClickListener {
            timeOutRemoveTimer.cancel()

            if (currentPlayer == 1){
                player1TimeRemaining += (player1TimeRemaining-turnStatus)/2
                currentPlayer = 2
                playerTimer = player2TimeRemaining
                player1Background.setBackgroundColor(Color.parseColor("#77ff8c00"))
                player2Background.setBackgroundColor(Color.parseColor("#77f440e4"))
                endTurn.rotation = 270f
                progressBar.rotation = 270f
            }
            else if (currentPlayer == 2){
                player2TimeRemaining += (player2TimeRemaining-turnStatus)/2
                currentPlayer = 3
                playerTimer = player3TimeRemaining
                player2Background.setBackgroundColor(Color.parseColor("#77ff8c00"))
                player3Background.setBackgroundColor(Color.parseColor("#77f440e4"))
                endTurn.rotation = 270f
                progressBar.rotation = 270f
            }
            else if (currentPlayer == 3){
                player3TimeRemaining += (player3TimeRemaining-turnStatus)/2
                currentPlayer = 4
                playerTimer = player4TimeRemaining
                player3Background.setBackgroundColor(Color.parseColor("#77ff8c00"))
                player4Background.setBackgroundColor(Color.parseColor("#77f440e4"))
                endTurn.rotation = 90f
                progressBar.rotation = 90f
            }
            else {
                player4TimeRemaining += (player4TimeRemaining-turnStatus)/2
                currentPlayer = 1
                playerTimer = player1TimeRemaining
                player4Background.setBackgroundColor(Color.parseColor("#77ff8c00"))
                player1Background.setBackgroundColor(Color.parseColor("#77f440e4"))
                endTurn.rotation = 90f
                progressBar.rotation = 90f
            }

            if (playerTimer > 300){
                playerTimer = 300
            }

            endTurn.setTextColor(Color.parseColor("#ffffff"))
            endTurn.text = skipTurnString

            timeOutRemoveTimer = object : CountDownTimer(playerTimer*1000L, 10) {
                override fun onFinish() {
                    progressBar.progress = 1f
                    turnStatus = playerTimer
                    endTurn.setTextColor(Color.parseColor("#ffffff"))
                    endTurn.text = endTurnString
                    if (currentPlayer == 1) {
                        player1Background.setBackgroundColor(Color.parseColor("#f440e4"))
                        endTurn.rotation = 90f
                    } else if (currentPlayer == 2) {
                        player2Background.setBackgroundColor(Color.parseColor("#f440e4"))
                        endTurn.rotation = 270f
                    } else if (currentPlayer == 3) {
                        player3Background.setBackgroundColor(Color.parseColor("#f440e4"))
                        endTurn.rotation = 270f
                    } else {
                        player4Background.setBackgroundColor(Color.parseColor("#f440e4"))
                        endTurn.rotation = 90f
                    }
                }

                override fun onTick(millisUntilFinished: Long) {
                    progressBar.progress = (playerTimer*1000L - millisUntilFinished).toFloat()/(playerTimer*1000L)
                    if((playerTimer*1000L - millisUntilFinished)/1000 > turnStatus){
                        turnStatus++
                    }
                }
            }

            thread{
                timeOutRemoveTimer.start()
            }
        }


        //Set onClickListeners for mana counters
        white1.setOnClickListener {
            if (white1CounterInt < 0) {
                white1CounterInt = 0
            }
            if (white1CounterInt >= 0){
                white1CounterInt++
                white1Counter.text = white1CounterInt.toString()
            }
            else {
                white1Counter.text = ""
            }
        }
        white1down.setOnClickListener {
            if (white1CounterInt > 0) {
                white1CounterInt--
            }
            if (white1CounterInt == 0){
                white1Counter.text = ""
            }
            else {
                white1Counter.text = white1CounterInt.toString()
            }
        }

        blue1.setOnClickListener {
            if (blue1CounterInt < 0) {
                blue1CounterInt = 0
            }
            if (blue1CounterInt >= 0){
                blue1CounterInt++
                blue1Counter.text = blue1CounterInt.toString()
            }
            else {
                blue1Counter.text = ""
            }
        }
        blue1down.setOnClickListener {
            if (blue1CounterInt > 0) {
                blue1CounterInt--
            }
            if (blue1CounterInt == 0){
                blue1Counter.text = ""
            }
            else {
                blue1Counter.text = blue1CounterInt.toString()
            }
        }

        black1.setOnClickListener {
            if (black1CounterInt < 0) {
                black1CounterInt = 0
            }
            if (black1CounterInt >= 0){
                black1CounterInt++
                black1Counter.text = black1CounterInt.toString()
            }
            else {
                black1Counter.text = ""
            }
        }
        black1down.setOnClickListener {
            if (black1CounterInt > 0) {
                black1CounterInt--
            }
            if (black1CounterInt == 0){
                black1Counter.text = ""
            }
            else {
                black1Counter.text = black1CounterInt.toString()
            }
        }

        red1.setOnClickListener {
            if (red1CounterInt < 0) {
                red1CounterInt = 0
            }
            if ( red1CounterInt >= 0){
                red1CounterInt++
                red1Counter.text = red1CounterInt.toString()
            }
            else {
                red1Counter.text = ""
            }
        }
        red1down.setOnClickListener {
            if (red1CounterInt > 0) {
                red1CounterInt--
            }
            if (red1CounterInt == 0){
                red1Counter.text = ""
            }
            else {
                red1Counter.text = red1CounterInt.toString()
            }
        }

        green1.setOnClickListener {
            if (green1CounterInt < 0) {
                green1CounterInt = 0
            }
            if ( green1CounterInt >= 0){
                green1CounterInt++
                green1Counter.text = green1CounterInt.toString()
            }
            else {
                green1Counter.text = ""
            }
        }
        green1down.setOnClickListener {
            if (green1CounterInt > 0) {
                green1CounterInt--
            }
            if (green1CounterInt == 0){
                green1Counter.text = ""
            }
            else {
                green1Counter.text = green1CounterInt.toString()
            }
        }

        white2.setOnClickListener {
            if (white2CounterInt < 0) {
                white2CounterInt = 0
            }
            if (white2CounterInt >= 0){
                white2CounterInt++
                white2Counter.text = white2CounterInt.toString()
            }
            else {
                white2Counter.text = ""
            }
        }
        white2down.setOnClickListener {
            if (white2CounterInt > 0) {
                white2CounterInt--
            }
            if (white2CounterInt == 0){
                white2Counter.text = ""
            }
            else {
                white2Counter.text = white2CounterInt.toString()
            }
        }

        blue2.setOnClickListener {
            if (blue2CounterInt < 0) {
                blue2CounterInt = 0
            }
            if (blue2CounterInt >= 0){
                blue2CounterInt++
                blue2Counter.text = blue2CounterInt.toString()
            }
            else {
                blue2Counter.text = ""
            }
        }
        blue2down.setOnClickListener {
            if (blue2CounterInt > 0) {
                blue2CounterInt--
            }
            if (blue2CounterInt == 0){
                blue2Counter.text = ""
            }
            else {
                blue2Counter.text = blue2CounterInt.toString()
            }
        }

        black2.setOnClickListener {
            if (black2CounterInt < 0) {
                black2CounterInt = 0
            }
            if (black2CounterInt >= 0){
                black2CounterInt++
                black2Counter.text = black2CounterInt.toString()
            }
            else {
                black2Counter.text = ""
            }
        }
        black2down.setOnClickListener {
            if (black2CounterInt > 0) {
                black2CounterInt--
            }
            if (black2CounterInt == 0){
                black2Counter.text = ""
            }
            else {
                black2Counter.text = black2CounterInt.toString()
            }
        }

        red2.setOnClickListener {
            if (red2CounterInt < 0) {
                red2CounterInt = 0
            }
            if ( red2CounterInt >= 0){
                red2CounterInt++
                red2Counter.text = red2CounterInt.toString()
            }
            else {
                red2Counter.text = ""
            }
        }
        red2down.setOnClickListener {
            if (red2CounterInt > 0) {
                red2CounterInt--
            }
            if (red2CounterInt == 0){
                red2Counter.text = ""
            }
            else {
                red2Counter.text = red2CounterInt.toString()
            }
        }

        green2.setOnClickListener {
            if (green2CounterInt < 0) {
                green2CounterInt = 0
            }
            if ( green2CounterInt >= 0){
                green2CounterInt++
                green2Counter.text = green2CounterInt.toString()
            }
            else {
                green2Counter.text = ""
            }
        }
        green2down.setOnClickListener {
            if (green2CounterInt > 0) {
                green2CounterInt--
            }
            if (green2CounterInt == 0){
                green2Counter.text = ""
            }
            else {
                green2Counter.text = green2CounterInt.toString()
            }
        }

        white3.setOnClickListener {
            if (white3CounterInt < 0) {
                white3CounterInt = 0
            }
            if (white3CounterInt >= 0){
                white3CounterInt++
                white3Counter.text = white3CounterInt.toString()
            }
            else {
                white3Counter.text = ""
            }
        }
        white3down.setOnClickListener {
            if (white3CounterInt > 0) {
                white3CounterInt--
            }
            if (white3CounterInt == 0){
                white3Counter.text = ""
            }
            else {
                white3Counter.text = white3CounterInt.toString()
            }
        }

        blue3.setOnClickListener {
            if (blue3CounterInt < 0) {
                blue3CounterInt = 0
            }
            if (blue3CounterInt >= 0){
                blue3CounterInt++
                blue3Counter.text = blue3CounterInt.toString()
            }
            else {
                blue3Counter.text = ""
            }
        }
        blue3down.setOnClickListener {
            if (blue3CounterInt > 0) {
                blue3CounterInt--
            }
            if (blue3CounterInt == 0){
                blue3Counter.text = ""
            }
            else {
                blue3Counter.text = blue3CounterInt.toString()
            }
        }

        black3.setOnClickListener {
            if (black3CounterInt < 0) {
                black3CounterInt = 0
            }
            if (black3CounterInt >= 0){
                black3CounterInt++
                black3Counter.text = black3CounterInt.toString()
            }
            else {
                black3Counter.text = ""
            }
        }
        black3down.setOnClickListener {
            if (black3CounterInt > 0) {
                black3CounterInt--
            }
            if (black3CounterInt == 0){
                black3Counter.text = ""
            }
            else {
                black3Counter.text = black3CounterInt.toString()
            }
        }

        red3.setOnClickListener {
            if (red3CounterInt < 0) {
                red3CounterInt = 0
            }
            if ( red3CounterInt >= 0){
                red3CounterInt++
                red3Counter.text = red3CounterInt.toString()
            }
            else {
                red3Counter.text = ""
            }
        }
        red3down.setOnClickListener {
            if (red3CounterInt > 0) {
                red3CounterInt--
            }
            if (red3CounterInt == 0){
                red3Counter.text = ""
            }
            else {
                red3Counter.text = red3CounterInt.toString()
            }
        }

        green3.setOnClickListener {
            if (green3CounterInt < 0) {
                green3CounterInt = 0
            }
            if ( green3CounterInt >= 0){
                green3CounterInt++
                green3Counter.text = green3CounterInt.toString()
            }
            else {
                green3Counter.text = ""
            }
        }
        green3down.setOnClickListener {
            if (green3CounterInt > 0) {
                green3CounterInt--
            }
            if (green3CounterInt == 0){
                green3Counter.text = ""
            }
            else {
                green3Counter.text = green3CounterInt.toString()
            }
        }

        white4.setOnClickListener {
            if (white4CounterInt < 0) {
                white4CounterInt = 0
            }
            if (white4CounterInt >= 0){
                white4CounterInt++
                white4Counter.text = white4CounterInt.toString()
            }
            else {
                white4Counter.text = ""
            }
        }
        white4down.setOnClickListener {
            if (white4CounterInt > 0) {
                white4CounterInt--
            }
            if (white4CounterInt == 0){
                white4Counter.text = ""
            }
            else {
                white4Counter.text = white4CounterInt.toString()
            }
        }

        blue4.setOnClickListener {
            if (blue4CounterInt < 0) {
                blue4CounterInt = 0
            }
            if (blue4CounterInt >= 0){
                blue4CounterInt++
                blue4Counter.text = blue4CounterInt.toString()
            }
            else {
                blue4Counter.text = ""
            }
        }
        blue4down.setOnClickListener {
            if (blue4CounterInt > 0) {
                blue4CounterInt--
            }
            if (blue4CounterInt == 0){
                blue4Counter.text = ""
            }
            else {
                blue4Counter.text = blue4CounterInt.toString()
            }
        }

        black4.setOnClickListener {
            if (black4CounterInt < 0) {
                black4CounterInt = 0
            }
            if (black4CounterInt >= 0){
                black4CounterInt++
                black4Counter.text = black4CounterInt.toString()
            }
            else {
                black4Counter.text = ""
            }
        }
        black4down.setOnClickListener {
            if (black4CounterInt > 0) {
                black4CounterInt--
            }
            if (black4CounterInt == 0){
                black4Counter.text = ""
            }
            else {
                black4Counter.text = black4CounterInt.toString()
            }
        }

        red4.setOnClickListener {
            if (red4CounterInt < 0) {
                red4CounterInt = 0
            }
            if ( red4CounterInt >= 0){
                red4CounterInt++
                red4Counter.text = red4CounterInt.toString()
            }
            else {
                red4Counter.text = ""
            }
        }
        red4down.setOnClickListener {
            if (red4CounterInt > 0) {
                red4CounterInt--
            }
            if (red4CounterInt == 0){
                red4Counter.text = ""
            }
            else {
                red4Counter.text = red4CounterInt.toString()
            }
        }

        green4.setOnClickListener {
            if (green4CounterInt < 0) {
                green4CounterInt = 0
            }
            if ( green4CounterInt >= 0){
                green4CounterInt++
                green4Counter.text = green4CounterInt.toString()
            }
            else {
                green4Counter.text = ""
            }
        }
        green4down.setOnClickListener {
            if (green4CounterInt > 0) {
                green4CounterInt--
            }
            if (green4CounterInt == 0){
                green4Counter.text = ""
            }
            else {
                green4Counter.text = green4CounterInt.toString()
            }
        }


        //Set textChangeListeners for mana counters
        white1Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#f9faf4"))
                endTurn.rotation = 90f
                endTurn.text = white1Counter.text.toString()
            }
        })
        white2Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#f9faf4"))
                endTurn.rotation = 270f
                endTurn.text = white2Counter.text.toString()
            }
        })
        white3Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#f9faf4"))
                endTurn.rotation = 270f
                endTurn.text = white3Counter.text.toString()
            }
        })
        white4Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#f9faf4"))
                endTurn.rotation = 90f
                endTurn.text = white4Counter.text.toString()
            }
        })
        blue1Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#0e68ab"))
                endTurn.rotation = 90f
                endTurn.text = blue1Counter.text.toString()
            }
        })
        blue2Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#0e68ab"))
                endTurn.rotation = 270f
                endTurn.text = blue2Counter.text.toString()
            }
        })
        blue3Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#0e68ab"))
                endTurn.rotation = 270f
                endTurn.text = blue3Counter.text.toString()
            }
        })
        blue4Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#0e68ab"))
                endTurn.rotation = 90f
                endTurn.text = blue4Counter.text.toString()
            }
        })
        black1Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#150b00"))
                endTurn.rotation = 90f
                endTurn.text = black1Counter.text.toString()
            }
        })
        black2Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#150b00"))
                endTurn.rotation = 270f
                endTurn.text = black2Counter.text.toString()
            }
        })
        black3Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#150b00"))
                endTurn.rotation = 270f
                endTurn.text = black3Counter.text.toString()
            }
        })
        black4Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#150b00"))
                endTurn.rotation = 90f
                endTurn.text = black4Counter.text.toString()
            }
        })
        red1Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#d3202a"))
                endTurn.rotation = 90f
                endTurn.text = red1Counter.text.toString()
            }
        })
        red2Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#d3202a"))
                endTurn.rotation = 270f
                endTurn.text = red2Counter.text.toString()
            }
        })
        red3Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#d3202a"))
                endTurn.rotation = 270f
                endTurn.text = red3Counter.text.toString()
            }
        })
        red4Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#d3202a"))
                endTurn.rotation = 90f
                endTurn.text = red4Counter.text.toString()
            }
        })
        green1Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#00733e"))
                endTurn.rotation = 90f
                endTurn.text = green1Counter.text.toString()
            }
        })
        green2Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#00733e"))
                endTurn.rotation = 270f
                endTurn.text = green2Counter.text.toString()
            }
        })
        green3Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#00733e"))
                endTurn.rotation = 270f
                endTurn.text = green3Counter.text.toString()
            }
        })
        green4Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                endTurn.setTextColor(Color.parseColor("#00733e"))
                endTurn.rotation = 90f
                endTurn.text = green4Counter.text.toString()
            }
        })


        //Set RepeatListeners for mana counters
        white1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            white1CounterInt++
            white1Counter.text = white1CounterInt.toString()
        }))
        white1down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            white1CounterInt--
            if (white1CounterInt <= 0){
                white1CounterInt = 0
                white1Counter.text = ""
            }
            else {
                white1Counter.text = white1CounterInt.toString()
            }
        }))
        white2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            white2CounterInt++
            white2Counter.text = white2CounterInt.toString()
        }))
        white2down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            white2CounterInt--
            if (white2CounterInt <= 0){
                white2CounterInt = 0
                white2Counter.text = ""
            }
            else {
                white2Counter.text = white2CounterInt.toString()
            }
        }))
        white3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            white3CounterInt++
            white3Counter.text = white3CounterInt.toString()
        }))
        white3down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            white3CounterInt--
            if (white3CounterInt <= 0){
                white3CounterInt = 0
                white3Counter.text = ""
            }
            else {
                white3Counter.text = white3CounterInt.toString()
            }
        }))
        white4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            white4CounterInt++
            white4Counter.text = white4CounterInt.toString()
        }))
        white4down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            white4CounterInt--
            if (white4CounterInt <= 0){
                white4CounterInt = 0
                white4Counter.text = ""
            }
            else {
                white4Counter.text = white4CounterInt.toString()
            }
        }))
        blue1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            blue1CounterInt++
            blue1Counter.text = blue1CounterInt.toString()
        }))
        blue1down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            blue1CounterInt--
            if (blue1CounterInt <= 0){
                blue1CounterInt = 0
                blue1Counter.text = ""
            }
            else {
                blue1Counter.text = blue1CounterInt.toString()
            }
        }))
        blue2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            blue2CounterInt++
            blue2Counter.text = blue2CounterInt.toString()
        }))
        blue2down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            blue2CounterInt--
            if (blue2CounterInt <= 0){
                blue2CounterInt = 0
                blue2Counter.text = ""
            }
            else {
                blue2Counter.text = blue2CounterInt.toString()
            }
        }))
        blue3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            blue3CounterInt++
            blue3Counter.text = blue3CounterInt.toString()
        }))
        blue3down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            blue3CounterInt--
            if (blue3CounterInt <= 0){
                blue3CounterInt = 0
                blue3Counter.text = ""
            }
            else {
                blue3Counter.text = blue3CounterInt.toString()
            }
        }))
        blue4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            blue4CounterInt++
            blue4Counter.text = blue4CounterInt.toString()
        }))
        blue4down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            blue4CounterInt--
            if (blue4CounterInt <= 0){
                blue4CounterInt = 0
                blue4Counter.text = ""
            }
            else {
                blue4Counter.text = blue4CounterInt.toString()
            }
        }))
        black1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            black1CounterInt++
            black1Counter.text = black1CounterInt.toString()
        }))
        black1down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            black1CounterInt--
            if (black1CounterInt <= 0){
                black1CounterInt = 0
                black1Counter.text = ""
            }
            else {
                black1Counter.text = black1CounterInt.toString()
            }
        }))
        black2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            black2CounterInt++
            black2Counter.text = black2CounterInt.toString()
        }))
        black2down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            black2CounterInt--
            if (black2CounterInt <= 0){
                black2CounterInt = 0
                black2Counter.text = ""
            }
            else {
                black2Counter.text = black2CounterInt.toString()
            }
        }))
        black3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            black3CounterInt++
            black3Counter.text = black3CounterInt.toString()
        }))
        black3down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            black3CounterInt--
            if (black3CounterInt <= 0){
                black3CounterInt = 0
                black3Counter.text = ""
            }
            else {
                black3Counter.text = black3CounterInt.toString()
            }
        }))
        black4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            black4CounterInt++
            black4Counter.text = black4CounterInt.toString()
        }))
        black4down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            black4CounterInt--
            if (black4CounterInt <= 0){
                black4CounterInt = 0
                black4Counter.text = ""
            }
            else {
                black4Counter.text = black4CounterInt.toString()
            }
        }))
        red1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            red1CounterInt++
            red1Counter.text = red1CounterInt.toString()
        }))
        red1down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            red1CounterInt--
            if (red1CounterInt <= 0){
                red1CounterInt = 0
                red1Counter.text = ""
            }
            else {
                red1Counter.text = red1CounterInt.toString()
            }
        }))
        red2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            red2CounterInt++
            red2Counter.text = red2CounterInt.toString()
        }))
        red2down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            red2CounterInt--
            if (red2CounterInt <= 0){
                red2CounterInt = 0
                red2Counter.text = ""
            }
            else {
                red2Counter.text = red2CounterInt.toString()
            }
        }))
        red3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            red3CounterInt++
            red3Counter.text = red3CounterInt.toString()
        }))
        red3down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            red3CounterInt--
            if (red3CounterInt <= 0){
                red3CounterInt = 0
                red3Counter.text = ""
            }
            else {
                red3Counter.text = red3CounterInt.toString()
            }
        }))
        red4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            red4CounterInt++
            red4Counter.text = red4CounterInt.toString()
        }))
        red4down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            red4CounterInt--
            if (red4CounterInt <= 0){
                red4CounterInt = 0
                red4Counter.text = ""
            }
            else {
                red4Counter.text = red4CounterInt.toString()
            }
        }))
        green1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            green1CounterInt++
            green1Counter.text = green1CounterInt.toString()
        }))
        green1down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            green1CounterInt--
            if (green1CounterInt <= 0){
                green1CounterInt = 0
                green1Counter.text = ""
            }
            else {
                green1Counter.text = green1CounterInt.toString()
            }
        }))
        green2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            green2CounterInt++
            green2Counter.text = green2CounterInt.toString()
        }))
        green2down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            green2CounterInt--
            if (green2CounterInt <= 0){
                green2CounterInt = 0
                green2Counter.text = ""
            }
            else {
                green2Counter.text = green2CounterInt.toString()
            }
        }))
        green3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            green3CounterInt++
            green3Counter.text = green3CounterInt.toString()
        }))
        green3down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            green3CounterInt--
            if (green3CounterInt <= 0){
                green3CounterInt = 0
                green3Counter.text = ""
            }
            else {
                green3Counter.text = green3CounterInt.toString()
            }
        }))
        green4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            green4CounterInt++
            green4Counter.text = green4CounterInt.toString()
        }))
        green4down.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            green4CounterInt--
            if (green4CounterInt <= 0){
                green4CounterInt = 0
                green4Counter.text = ""
            }
            else {
                green4Counter.text = green4CounterInt.toString()
            }
        }))

        
        //Set RepeatListeners for life counter increases
        hiddenMinus1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            if (lifeTotal1 > 0){
                lifeTotal1--
            }
            life1.text = lifeTotal1.toString()
        }))
        hiddenPlus1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            lifeTotal1++
            life1.text = lifeTotal1.toString()
        }))

        hiddenMinus2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            if (lifeTotal2 > 0){
                lifeTotal2--
            }
            life2.text = lifeTotal2.toString()
        }))
        hiddenPlus2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            lifeTotal2++
            life2.text = lifeTotal2.toString()
        }))

        hiddenMinus3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            if (lifeTotal3 > 0){
                lifeTotal3--
            }
            life3.text = lifeTotal3.toString()
        }))
        hiddenPlus3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            lifeTotal3++
            life3.text = lifeTotal3.toString()
        }))

        hiddenMinus4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            if (lifeTotal4 > 0){
                lifeTotal4--
            }
            life4.text = lifeTotal4.toString()
        }))
        hiddenPlus4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            lifeTotal4++
            life4.text = lifeTotal4.toString()
        }))
    }
}
