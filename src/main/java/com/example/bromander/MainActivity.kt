package com.example.bromander

import android.app.Activity
import android.app.Fragment
import android.content.ComponentCallbacks2
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.KeyEvent
import android.view.View
import android.view.View.INVISIBLE
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.view.MotionEvent
import android.widget.Toast
import android.view.View.OnLongClickListener





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

    //Additional global variables
    var lifeTotal1: Int = 40
    var lifeTotal2: Int = 40
    var lifeTotal3: Int = 40
    var lifeTotal4: Int = 40
    var white1Counter: Int = 0
    var blue1Counter: Int = 0
    var black1Counter: Int = 0
    var red1Counter: Int = 0
    var green1Counter: Int = 0
    var white2Counter: Int = 0
    var blue2Counter: Int = 0
    var black2Counter: Int = 0
    var red2Counter: Int = 0
    var green2Counter: Int = 0
    var white3Counter: Int = 0
    var blue3Counter: Int = 0
    var black3Counter: Int = 0
    var red3Counter: Int = 0
    var green3Counter: Int = 0
    var white4Counter: Int = 0
    var blue4Counter: Int = 0
    var black4Counter: Int = 0
    var red4Counter: Int = 0
    var green4Counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //gestureDetector = GestureDetector(this, GestureListener())

        //Initialize variables for XML elements
        /*
        player1Text = findViewById(R.id.player1Text)
        player2Text = findViewById(R.id.player2Text)
        player3Text = findViewById(R.id.player3Text)
        player4Text = findViewById(R.id.player4Text)
        plus1 = findViewById(R.id.plus1)
        plus2 = findViewById(R.id.plus2)
        plus3 = findViewById(R.id.plus3)
        plus4 = findViewById(R.id.plus4)
        minus1 = findViewById(R.id.minus1)
        minus2 = findViewById(R.id.minus2)
        minus3 = findViewById(R.id.minus3)
        minus4 = findViewById(R.id.minus4)
        */
        life1 = findViewById(R.id.life1)
        life2 = findViewById(R.id.life2)
        life3 = findViewById(R.id.life3)
        life4 = findViewById(R.id.life4)
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
        endTurn = findViewById(R.id.endTurn)

        //Make life buttons nonexistent
        /*
        plus1.visibility = INVISIBLE
        plus2.visibility = INVISIBLE
        plus3.visibility = INVISIBLE
        plus4.visibility = INVISIBLE
        minus1.visibility = INVISIBLE
        minus2.visibility = INVISIBLE
        minus3.visibility = INVISIBLE
        minus4.visibility = INVISIBLE
        */

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

        //Set onClickListeners for mana counters
        /*
        white1.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (white1Counter < 0) {
                    white1Counter = 0
                }
                if (white1Counter >= 0){
                    white1Counter++
                    white1.text = white1Counter.toString()
                }
                else {
                    white1.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (white1Counter > 0) {
                    white1Counter--
                    if (white1Counter <= 0) {
                        white1Counter = 0
                        white1.text = ""
                    }
                    else {
                        white1.text = white1Counter.toString()
                    }
                }
                else {
                    white1Counter = 0
                    white1.text = ""
                }
            }
        })

         */
        white1.setOnLongClickListener(View.OnLongClickListener(){
            white1Counter = 0
            white1.text = ""
            true
        })
/*
        blue1.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (blue1Counter < 0) {
                    blue1Counter = 0
                }
                if (blue1Counter >= 0){
                    blue1Counter++
                    blue1.text = blue1Counter.toString()
                }
                else {
                    blue1.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (blue1Counter > 0) {
                    blue1Counter--
                    if (blue1Counter <= 0) {
                        blue1Counter = 0
                        blue1.text = ""
                    }
                    else {
                        blue1.text = blue1Counter.toString()
                    }
                }
                else {
                    blue1Counter = 0
                    blue1.text = ""
                }
            }
        })

         */
        blue1.setOnLongClickListener(View.OnLongClickListener(){
            blue1Counter = 0
            blue1.text = ""
            true
        })
/*
        black1.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (black1Counter < 0) {
                    black1Counter = 0
                }
                if (black1Counter >= 0){
                    black1Counter++
                    black1.text = black1Counter.toString()
                }
                else {
                    black1.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (black1Counter > 0) {
                    black1Counter--
                    if (black1Counter <= 0) {
                        black1Counter = 0
                        black1.text = ""
                    }
                    else {
                        black1.text = black1Counter.toString()
                    }
                }
                else {
                    black1Counter = 0
                    black1.text = ""
                }
            }
        })

         */
        black1.setOnLongClickListener(View.OnLongClickListener(){
            black1Counter = 0
            black1.text = ""
            true
        })
/*
        red1.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (red1Counter < 0) {
                    red1Counter = 0
                }
                if (red1Counter >= 0){
                    red1Counter++
                    red1.text = red1Counter.toString()
                }
                else {
                    red1.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (red1Counter > 0) {
                    red1Counter--
                    if (red1Counter <= 0) {
                        red1Counter = 0
                        red1.text = ""
                    }
                    else {
                        red1.text = red1Counter.toString()
                    }
                }
                else {
                    red1Counter = 0
                    red1.text = ""
                }
            }
        })

         */
        red1.setOnLongClickListener(View.OnLongClickListener(){
            red1Counter = 0
            red1.text = ""
            true
        })
/*
        green1.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (green1Counter < 0) {
                    green1Counter = 0
                }
                if (green1Counter >= 0){
                    green1Counter++
                    green1.text = green1Counter.toString()
                }
                else {
                    green1.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (green1Counter > 0) {
                    green1Counter--
                    if (green1Counter <= 0) {
                        green1Counter = 0
                        green1.text = ""
                    }
                    else {
                        green1.text = green1Counter.toString()
                    }
                }
                else {
                    green1Counter = 0
                    green1.text = ""
                }
            }
        })

         */
        green1.setOnLongClickListener(View.OnLongClickListener(){
            green1Counter = 0
            green1.text = ""
            true
        })
/*
        white2.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (white2Counter < 0) {
                    white2Counter = 0
                }
                if (white2Counter >= 0){
                    white2Counter++
                    white2.text = white2Counter.toString()
                }
                else {
                    white2.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (white2Counter > 0) {
                    white2Counter--
                    if (white2Counter <= 0) {
                        white2Counter = 0
                        white2.text = ""
                    }
                    else {
                        white2.text = white2Counter.toString()
                    }
                }
                else {
                    white2Counter = 0
                    white2.text = ""
                }
            }
        })

         */
        white2.setOnLongClickListener(View.OnLongClickListener(){
            white2Counter = 0
            white2.text = ""
            true
        })
/*
        blue2.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (blue2Counter < 0) {
                    blue2Counter = 0
                }
                if (blue2Counter >= 0){
                    blue2Counter++
                    blue2.text = blue2Counter.toString()
                }
                else {
                    blue2.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (blue2Counter > 0) {
                    blue2Counter--
                    if (blue2Counter <= 0) {
                        blue2Counter = 0
                        blue2.text = ""
                    }
                    else {
                        blue2.text = blue2Counter.toString()
                    }
                }
                else {
                    blue2Counter = 0
                    blue2.text = ""
                }
            }
        })

         */
        blue2.setOnLongClickListener(View.OnLongClickListener(){
            blue2Counter = 0
            blue2.text = ""
            true
        })
/*
        black2.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (black2Counter < 0) {
                    black2Counter = 0
                }
                if (black2Counter >= 0){
                    black2Counter++
                    black2.text = black2Counter.toString()
                }
                else {
                    black2.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (black2Counter > 0) {
                    black2Counter--
                    if (black2Counter <= 0) {
                        black2Counter = 0
                        black2.text = ""
                    }
                    else {
                        black2.text = black2Counter.toString()
                    }
                }
                else {
                    black2Counter = 0
                    black2.text = ""
                }
            }
        })

         */
        black2.setOnLongClickListener(View.OnLongClickListener(){
            black2Counter = 0
            black2.text = ""
            true
        })
/*
        red2.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (red2Counter < 0) {
                    red2Counter = 0
                }
                if (red2Counter >= 0){
                    red2Counter++
                    red2.text = red2Counter.toString()
                }
                else {
                    red2.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (red2Counter > 0) {
                    red2Counter--
                    if (red2Counter <= 0) {
                        red2Counter = 0
                        red2.text = ""
                    }
                    else {
                        red2.text = red2Counter.toString()
                    }
                }
                else {
                    red2Counter = 0
                    red2.text = ""
                }
            }
        })

         */
        red2.setOnLongClickListener(View.OnLongClickListener(){
            red2Counter = 0
            red2.text = ""
            true
        })
/*
        green2.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (green2Counter < 0) {
                    green2Counter = 0
                }
                if (green2Counter >= 0){
                    green2Counter++
                    green2.text = green2Counter.toString()
                }
                else {
                    green2.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (green2Counter > 0) {
                    green2Counter--
                    if (green2Counter <= 0) {
                        green2Counter = 0
                        green2.text = ""
                    }
                    else {
                        green2.text = green2Counter.toString()
                    }
                }
                else {
                    green2Counter = 0
                    green2.text = ""
                }
            }
        })

         */
        green2.setOnLongClickListener(View.OnLongClickListener(){
            green2Counter = 0
            green2.text = ""
            true
        })
/*
        white3.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (white3Counter < 0) {
                    white3Counter = 0
                }
                if (white3Counter >= 0){
                    white3Counter++
                    white3.text = white3Counter.toString()
                }
                else {
                    white3.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (white3Counter > 0) {
                    white3Counter--
                    if (white3Counter <= 0) {
                        white3Counter = 0
                        white3.text = ""
                    }
                    else {
                        white3.text = white3Counter.toString()
                    }
                }
                else {
                    white3Counter = 0
                    white3.text = ""
                }
            }
        })

         */
        white3.setOnLongClickListener(View.OnLongClickListener(){
            white3Counter = 0
            white3.text = ""
            true
        })
/*
        blue3.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (blue3Counter < 0) {
                    blue3Counter = 0
                }
                if (blue3Counter >= 0){
                    blue3Counter++
                    blue3.text = blue3Counter.toString()
                }
                else {
                    blue3.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (blue3Counter > 0) {
                    blue3Counter--
                    if (blue3Counter <= 0) {
                        blue3Counter = 0
                        blue3.text = ""
                    }
                    else {
                        blue3.text = blue3Counter.toString()
                    }
                }
                else {
                    blue3Counter = 0
                    blue3.text = ""
                }
            }
        })

         */
        blue3.setOnLongClickListener(View.OnLongClickListener(){
            blue3Counter = 0
            blue3.text = ""
            true
        })
/*
        black3.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (black3Counter < 0) {
                    black3Counter = 0
                }
                if (black3Counter >= 0){
                    black3Counter++
                    black3.text = black3Counter.toString()
                }
                else {
                    black3.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (black3Counter > 0) {
                    black3Counter--
                    if (black3Counter <= 0) {
                        black3Counter = 0
                        black3.text = ""
                    }
                    else {
                        black3.text = black3Counter.toString()
                    }
                }
                else {
                    black3Counter = 0
                    black3.text = ""
                }
            }
        })

         */
        black3.setOnLongClickListener(View.OnLongClickListener(){
            black3Counter = 0
            black3.text = ""
            true
        })
/*
        red3.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (red3Counter < 0) {
                    red3Counter = 0
                }
                if (red3Counter >= 0){
                    red3Counter++
                    red3.text = red3Counter.toString()
                }
                else {
                    red3.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (red3Counter > 0) {
                    red3Counter--
                    if (red3Counter <= 0) {
                        red3Counter = 0
                        red3.text = ""
                    }
                    else {
                        red3.text = red3Counter.toString()
                    }
                }
                else {
                    red3Counter = 0
                    red3.text = ""
                }
            }
        })

         */
        red3.setOnLongClickListener(View.OnLongClickListener(){
            red3Counter = 0
            red3.text = ""
            true
        })
/*
        green3.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (green3Counter < 0) {
                    green3Counter = 0
                }
                if (green3Counter >= 0){
                    green3Counter++
                    green3.text = green3Counter.toString()
                }
                else {
                    green3.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (green3Counter > 0) {
                    green3Counter--
                    if (green3Counter <= 0) {
                        green3Counter = 0
                        green3.text = ""
                    }
                    else {
                        green3.text = green3Counter.toString()
                    }
                }
                else {
                    green3Counter = 0
                    green3.text = ""
                }
            }
        })

         */
        green3.setOnLongClickListener(View.OnLongClickListener(){
            green3Counter = 0
            green3.text = ""
            true
        })
/*
        white4.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (white4Counter < 0) {
                    white4Counter = 0
                }
                if (white4Counter >= 0){
                    white4Counter++
                    white4.text = white4Counter.toString()
                }
                else {
                    white4.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (white4Counter > 0) {
                    white4Counter--
                    if (white4Counter <= 0) {
                        white4Counter = 0
                        white4.text = ""
                    }
                    else {
                        white4.text = white4Counter.toString()
                    }
                }
                else {
                    white4Counter = 0
                    white4.text = ""
                }
            }
        })

         */
        white4.setOnLongClickListener(View.OnLongClickListener(){
            white4Counter = 0
            white4.text = ""
            true
        })
/*
        blue4.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (blue4Counter < 0) {
                    blue4Counter = 0
                }
                if (blue4Counter >= 0){
                    blue4Counter++
                    blue4.text = blue4Counter.toString()
                }
                else {
                    blue4.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (blue4Counter > 0) {
                    blue4Counter--
                    if (blue4Counter <= 0) {
                        blue4Counter = 0
                        blue4.text = ""
                    }
                    else {
                        blue4.text = blue4Counter.toString()
                    }
                }
                else {
                    blue4Counter = 0
                    blue4.text = ""
                }
            }
        })

         */
        blue4.setOnLongClickListener(View.OnLongClickListener(){
            blue4Counter = 0
            blue4.text = ""
            true
        })
/*
        black4.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (black4Counter < 0) {
                    black4Counter = 0
                }
                if (black4Counter >= 0){
                    black4Counter++
                    black4.text = black4Counter.toString()
                }
                else {
                    black4.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (black4Counter > 0) {
                    black4Counter--
                    if (black4Counter <= 0) {
                        black4Counter = 0
                        black4.text = ""
                    }
                    else {
                        black4.text = black4Counter.toString()
                    }
                }
                else {
                    black4Counter = 0
                    black4.text = ""
                }
            }
        })
         */
        black4.setOnLongClickListener(View.OnLongClickListener(){
            black4Counter = 0
            black4.text = ""
            true
        })
/*
        red4.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (red4Counter < 0) {
                    red4Counter = 0
                }
                if (red4Counter >= 0){
                    red4Counter++
                    red4.text = red4Counter.toString()
                }
                else {
                    red4.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (red4Counter > 0) {
                    red4Counter--
                    if (red4Counter <= 0) {
                        red4Counter = 0
                        red4.text = ""
                    }
                    else {
                        red4.text = red4Counter.toString()
                    }
                }
                else {
                    red4Counter = 0
                    red4.text = ""
                }
            }
        })
         */
        red4.setOnLongClickListener(View.OnLongClickListener(){
            red4Counter = 0
            red4.text = ""
            true
        })
/*
        green4.setOnClickListener(object:DoubleClickListener() {
            override fun onSingleClick(v:View) {
                if (green4Counter < 0) {
                    green4Counter = 0
                }
                if (green4Counter >= 0){
                    green4Counter++
                    green4.text = green4Counter.toString()
                }
                else {
                    green4.text = ""
                }
            }
            override fun onDoubleClick(v:View) {
                if (green4Counter > 0) {
                    green4Counter--
                    if (green4Counter <= 0) {
                        green4Counter = 0
                        green4.text = ""
                    }
                    else {
                        green4.text = green4Counter.toString()
                    }
                }
                else {
                    green4Counter = 0
                    green4.text = ""
                }
            }
        })
         */
        green4.setOnLongClickListener(View.OnLongClickListener(){
            green4Counter = 0
            green4.text = ""
            true
        })

        white1.setOnClickListener {
            if (white1Counter < 0) {
                white1Counter = 0
            }
            if (white1Counter >= 0){
                white1Counter++
                white1.text = white1Counter.toString()
			}
			else {
                white1.text = ""
			}
        }

        blue1.setOnClickListener {
            if (blue1Counter < 0) {
                blue1Counter = 0
            }
            if (blue1Counter >= 0){
                blue1Counter++
				blue1.text = blue1Counter.toString()
			}
			else {
                blue1.text = ""
			}
        }

        black1.setOnClickListener {
            if (black1Counter < 0) {
                black1Counter = 0
            }
            if (black1Counter >= 0){
                black1Counter++
				black1.text = black1Counter.toString()
			}
			else {
                black1.text = ""
			}
        }

        red1.setOnClickListener {
            if (red1Counter < 0) {
                red1Counter = 0
            }
            if ( red1Counter >= 0){
                red1Counter++
				red1.text = red1Counter.toString()
			}
			else {
                red1.text = ""
			}
        }

        green1.setOnClickListener {
            if (green1Counter < 0) {
                green1Counter = 0
            }
            if ( green1Counter >= 0){
                green1Counter++
				green1.text = green1Counter.toString()
			}
			else {
                green1.text = ""
			}
        }

        white2.setOnClickListener {
            if (white2Counter < 0) {
                white2Counter = 0
            }
            if ( white2Counter >= 0){
                white2Counter++
				white2.text = white2Counter.toString()
			}
			else {
                white2.text = ""
			}
        }

        blue2.setOnClickListener {
            if (blue2Counter < 0) {
                blue2Counter = 0
            }
            if ( blue2Counter >= 0){
                blue2Counter++
				blue2.text = blue2Counter.toString()
			}
			else {
                blue2.text = ""
			}
        }

        black2.setOnClickListener {
            if (black2Counter < 0) {
                black2Counter = 0
            }
            if ( black2Counter >= 0){
                black2Counter++
				black2.text = black2Counter.toString()
			}
			else {
                black2.text = ""
			}
        }

        red2.setOnClickListener {
            if (red2Counter < 0) {
                red2Counter = 0
            }
            if ( red2Counter >= 0){
                red2Counter++
				red2.text = red2Counter.toString()
			}
			else {
                red2.text = ""
			}
        }

        green2.setOnClickListener {
            if (green2Counter < 0) {
                green2Counter = 0
            }
            if ( green2Counter >= 0){
                green2Counter++
				green2.text = green2Counter.toString()
			}
			else {
                green2.text = ""
			}
        }

        white3.setOnClickListener {
            if (white3Counter < 0) {
                white3Counter = 0
            }
            if ( white3Counter >= 0){
                white3Counter++
                white3.text = white3Counter.toString()
			}
			else {
                white3.text = ""
			}
        }

        blue3.setOnClickListener {
            if (blue3Counter < 0) {
                blue3Counter = 0
            }
            if ( blue3Counter >= 0){
                blue3Counter++
				blue3.text = blue3Counter.toString()
			}
			else {
                blue3.text = ""
			}
        }

        black3.setOnClickListener {
            if (black3Counter < 0) {
                black3Counter = 0
            }
            if ( black3Counter >= 0){
                black3Counter++
				black3.text = black3Counter.toString()
			}
			else {
                black3.text = ""
			}
        }

        red3.setOnClickListener {
            if (red3Counter < 0) {
                red3Counter = 0
            }
            if ( red3Counter >= 0){
                red3Counter++
				red3.text = red3Counter.toString()
			}
			else {
                red3.text = ""
			}
        }

        green3.setOnClickListener {
            if (green3Counter < 0) {
                green3Counter = 0
            }
            if ( green3Counter >= 0){
                green3Counter++
				green3.text = green3Counter.toString()
			}
			else {
                green3.text = ""
			}
        }

        white4.setOnClickListener {
            if (white4Counter < 0) {
                white4Counter = 0
            }
            if ( white4Counter >= 0){
                white4Counter++
				white4.text = white4Counter.toString()
			}
			else {
                white4.text = ""
			}
        }

        blue4.setOnClickListener {
            if (blue4Counter < 0) {
                blue4Counter = 0
            }
            if ( blue4Counter >= 0){
                blue4Counter++
				blue4.text = blue4Counter.toString()
			}
			else {
                blue4.text = ""
			}
        }

        black4.setOnClickListener {
            if (black4Counter < 0) {
                black4Counter = 0
            }
            if ( black4Counter >= 0){
                black4Counter++
				black4.text = black4Counter.toString()
			}
			else {
                black4.text = ""
			}
        }

        red4.setOnClickListener {
            if (red4Counter < 0) {
                red4Counter = 0
            }
            if ( red4Counter >= 0){
                red4Counter++
				red4.text = red4Counter.toString()
			}
			else {
                red4.text = ""
			}
        }

        green4.setOnClickListener {
            if (green4Counter < 0) {
                green4Counter = 0
            }
            if ( green4Counter >= 0){
                green4Counter++
				green4.text = green4Counter.toString()
			}
			else {
                green4.text = ""
			}
        }

        //Hide keyboards
        /*
        player1Text.setOnKeyListener(View.OnKeyListener { v: View, keyCode: Int, event: KeyEvent ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                player1Text.clearFocus()
                player1Text.rootView.requestFocus()
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
                return@OnKeyListener true
            }
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                player1Text.clearFocus()
                player1Text.rootView.requestFocus()
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
                return@OnKeyListener true
            }
            false})

        player2Text.setOnKeyListener(View.OnKeyListener { v: View, keyCode: Int, event: KeyEvent ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                player2Text.clearFocus()
                player1Text.rootView.requestFocus()
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
                return@OnKeyListener true
            }
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                player2Text.clearFocus()
                player1Text.rootView.requestFocus()
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
                return@OnKeyListener true
            }
            false})

        player3Text.setOnKeyListener(View.OnKeyListener { v: View, keyCode: Int, event: KeyEvent ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                player3Text.clearFocus()
                player1Text.rootView.requestFocus()
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
                return@OnKeyListener true
            }
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                player3Text.clearFocus()
                player1Text.rootView.requestFocus()
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
                return@OnKeyListener true
            }
            false})

        player4Text.setOnKeyListener(View.OnKeyListener { v: View, keyCode: Int, event: KeyEvent ->
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                player4Text.clearFocus()
                player1Text.rootView.requestFocus()
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
                return@OnKeyListener true
            }
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                player4Text.clearFocus()
                player1Text.rootView.requestFocus()
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
                return@OnKeyListener true
            }
            false})
         */

        //Set onClickListeners
        endTurn.setOnClickListener {
            lifeTotal1 = 40
            lifeTotal2 = 40
            lifeTotal3 = 40
            lifeTotal4 = 40
            life1.text = lifeTotal1.toString()
            life2.text = lifeTotal2.toString()
            life3.text = lifeTotal3.toString()
            life4.text = lifeTotal4.toString()
        }
    }

    //Function to pass to gesture detector
    /*
    override fun onTouchEvent(e:MotionEvent):Boolean {
        return gestureDetector.onTouchEvent(e)
    }

    //Override functions for tap gestures
    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        // event when double tap occurs
        override fun onDoubleTap(e: MotionEvent): Boolean {
            val x = e.x
            val y = e.y

            Log.d("Double Tap", "Tapped at: ($x,$y)")

            doubleTapped = true

            return true
        }
    }
     */

    //Functions to hide the keyboard
    fun Fragment.hideKeyboard() {
        //view?.let { activity?.hideKeyboard(it) }
    }

    fun Activity.hideKeyboard() {
        //hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        //val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
