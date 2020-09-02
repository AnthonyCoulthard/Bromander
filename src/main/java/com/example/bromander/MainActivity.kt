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

        //Set onClickListener for ending the turn
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

        //Set onClickListeners for mana counters
        white1.setOnLongClickListener(View.OnLongClickListener(){
            white1CounterInt = 0
            white1Counter.text = ""
            true
        })
        white1down.setOnLongClickListener(View.OnLongClickListener(){
            white1CounterInt = 0
            white1Counter.text = ""
            true
        })

        blue1.setOnLongClickListener(View.OnLongClickListener(){
            blue1CounterInt = 0
            blue1Counter.text = ""
            true
        })
        blue1down.setOnLongClickListener(View.OnLongClickListener(){
            blue1CounterInt = 0
            blue1Counter.text = ""
            true
        })

        black1.setOnLongClickListener(View.OnLongClickListener(){
            black1CounterInt = 0
            black1Counter.text = ""
            true
        })
        black1down.setOnLongClickListener(View.OnLongClickListener(){
            black1CounterInt = 0
            black1Counter.text = ""
            true
        })

        red1.setOnLongClickListener(View.OnLongClickListener(){
            red1CounterInt = 0
            red1Counter.text = ""
            true
        })
        red1down.setOnLongClickListener(View.OnLongClickListener(){
            red1CounterInt = 0
            red1Counter.text = ""
            true
        })

        green1.setOnLongClickListener(View.OnLongClickListener(){
            green1CounterInt = 0
            green1Counter.text = ""
            true
        })
        green1down.setOnLongClickListener(View.OnLongClickListener(){
            green1CounterInt = 0
            green1Counter.text = ""
            true
        })

        white2.setOnLongClickListener(View.OnLongClickListener(){
            white2CounterInt = 0
            white2Counter.text = ""
            true
        })
        white2down.setOnLongClickListener(View.OnLongClickListener(){
            white2CounterInt = 0
            white2Counter.text = ""
            true
        })

        blue2.setOnLongClickListener(View.OnLongClickListener(){
            blue2CounterInt = 0
            blue2Counter.text = ""
            true
        })
        blue2down.setOnLongClickListener(View.OnLongClickListener(){
            blue2CounterInt = 0
            blue2Counter.text = ""
            true
        })

        black2.setOnLongClickListener(View.OnLongClickListener(){
            black2CounterInt = 0
            black2Counter.text = ""
            true
        })
        black2down.setOnLongClickListener(View.OnLongClickListener(){
            black2CounterInt = 0
            black2Counter.text = ""
            true
        })

        red2.setOnLongClickListener(View.OnLongClickListener(){
            red2CounterInt = 0
            red2Counter.text = ""
            true
        })
        red2down.setOnLongClickListener(View.OnLongClickListener(){
            red2CounterInt = 0
            red2Counter.text = ""
            true
        })

        green2.setOnLongClickListener(View.OnLongClickListener(){
            green2CounterInt = 0
            green2Counter.text = ""
            true
        })
        green2down.setOnLongClickListener(View.OnLongClickListener(){
            green2CounterInt = 0
            green2Counter.text = ""
            true
        })

        white3.setOnLongClickListener(View.OnLongClickListener(){
            white3CounterInt = 0
            white3Counter.text = ""
            true
        })
        white3down.setOnLongClickListener(View.OnLongClickListener(){
            white3CounterInt = 0
            white3Counter.text = ""
            true
        })

        blue3.setOnLongClickListener(View.OnLongClickListener(){
            blue3CounterInt = 0
            blue3Counter.text = ""
            true
        })
        blue3down.setOnLongClickListener(View.OnLongClickListener(){
            blue3CounterInt = 0
            blue3Counter.text = ""
            true
        })

        black3.setOnLongClickListener(View.OnLongClickListener(){
            black3CounterInt = 0
            black3Counter.text = ""
            true
        })
        black3down.setOnLongClickListener(View.OnLongClickListener(){
            black3CounterInt = 0
            black3Counter.text = ""
            true
        })

        red3.setOnLongClickListener(View.OnLongClickListener(){
            red3CounterInt = 0
            red3Counter.text = ""
            true
        })
        red3down.setOnLongClickListener(View.OnLongClickListener(){
            red3CounterInt = 0
            red3Counter.text = ""
            true
        })

        green3.setOnLongClickListener(View.OnLongClickListener(){
            green3CounterInt = 0
            green3Counter.text = ""
            true
        })
        green3down.setOnLongClickListener(View.OnLongClickListener(){
            green3CounterInt = 0
            green3Counter.text = ""
            true
        })

        white4.setOnLongClickListener(View.OnLongClickListener(){
            white4CounterInt = 0
            white4Counter.text = ""
            true
        })
        white4down.setOnLongClickListener(View.OnLongClickListener(){
            white4CounterInt = 0
            white4Counter.text = ""
            true
        })

        blue4.setOnLongClickListener(View.OnLongClickListener(){
            blue4CounterInt = 0
            blue4Counter.text = ""
            true
        })
        blue4down.setOnLongClickListener(View.OnLongClickListener(){
            blue4CounterInt = 0
            blue4Counter.text = ""
            true
        })

        black4.setOnLongClickListener(View.OnLongClickListener(){
            black4CounterInt = 0
            black4Counter.text = ""
            true
        })
        black4down.setOnLongClickListener(View.OnLongClickListener(){
            black4CounterInt = 0
            black4Counter.text = ""
            true
        })

        red4.setOnLongClickListener(View.OnLongClickListener(){
            red4CounterInt = 0
            red4Counter.text = ""
            true
        })
        red4down.setOnLongClickListener(View.OnLongClickListener(){
            red4CounterInt = 0
            red4Counter.text = ""
            true
        })

        green4.setOnLongClickListener(View.OnLongClickListener(){
            green4CounterInt = 0
            green4Counter.text = ""
            true
        })
        green4down.setOnLongClickListener(View.OnLongClickListener(){
            green4CounterInt = 0
            green4Counter.text = ""
            true
        })

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
        
        
        //Set RepeatListeners for life counter increases
        hiddenMinus1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            if (lifeTotal1 > 0){
                lifeTotal1--
            }
            life1.text = lifeTotal1.toString()
            /*
            if (!lifeHeld) {
                if (lifeTotal1 > 0){
                    lifeTotal1--
                }
                life1.text = lifeTotal1.toString()
                lifeHeld = true
            }
            else {
                lifeTotal1 -= 5
                if (lifeTotal1 < 0) {
                    lifeTotal1 = 0
                }
                life1.text = lifeTotal1.toString()
                lifeHeld = true
            }
            if (lifeHeld){
                lifeHeld = false
            }
             */
        }))
        hiddenPlus1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            lifeTotal1++
            life1.text = lifeTotal1.toString()
            /*
            if (!lifeHeld) {
                if (lifeTotal1 >= 0){
                    lifeTotal1++
                }
                else {
                    lifeTotal1 = 0
                }
                life1.text = lifeTotal1.toString()
                lifeHeld = true
            }
            else {
                lifeTotal1 += 5
                if (lifeTotal1 < 0) {
                    lifeTotal1 = 0
                }
                life1.text = lifeTotal1.toString()
                lifeHeld = true
            }
            if (lifeHeld){
                lifeHeld = false
            }
             */
        }))

        hiddenMinus2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            if (lifeTotal2 > 0){
                lifeTotal2--
            }
            life2.text = lifeTotal2.toString()
            /*
            if (!lifeHeld) {
                if (lifeTotal2 > 0){
                    lifeTotal2--
                }
                life2.text = lifeTotal2.toString()
                lifeHeld = true
            }
            else {
                lifeTotal2 -= 5
                if (lifeTotal2 < 0) {
                    lifeTotal2 = 0
                }
                life2.text = lifeTotal2.toString()
                lifeHeld = true
            }
            if (lifeHeld){
                lifeHeld = false
            }
             */
        }))
        hiddenPlus2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            lifeTotal2++
            life2.text = lifeTotal2.toString()
            /*
            if (!lifeHeld) {
                if (lifeTotal2 >= 0){
                    lifeTotal2++
                }
                else {
                    lifeTotal2 = 0
                }
                life2.text = lifeTotal2.toString()
                lifeHeld = true
            }
            else {
                lifeTotal2 += 5
                if (lifeTotal2 < 0) {
                    lifeTotal2 = 0
                }
                life2.text = lifeTotal2.toString()
                lifeHeld = true
            }
            if (lifeHeld){
                lifeHeld = false
            }
             */
        }))

        hiddenMinus3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            if (lifeTotal3 > 0){
                lifeTotal3--
            }
            life3.text = lifeTotal3.toString()
            /*
            if (!lifeHeld) {
                if (lifeTotal3 > 0){
                    lifeTotal3--
                }
                life3.text = lifeTotal3.toString()
                lifeHeld = true
            }
            else {
                lifeTotal3 -= 5
                if (lifeTotal3 < 0) {
                    lifeTotal3 = 0
                }
                life3.text = lifeTotal3.toString()
                lifeHeld = true
            }
            if (lifeHeld){
                lifeHeld = false
            }
             */
        }))
        hiddenPlus3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            lifeTotal3++
            life3.text = lifeTotal3.toString()
            /*
            if (!lifeHeld) {
                if (lifeTotal3 >= 0){
                    lifeTotal3++
                }
                else {
                    lifeTotal3 = 0
                }
                life3.text = lifeTotal3.toString()
                lifeHeld = true
            }
            else {
                lifeTotal3 += 5
                if (lifeTotal3 < 0) {
                    lifeTotal3 = 0
                }
                life3.text = lifeTotal3.toString()
                lifeHeld = true
            }
            if (lifeHeld){
                lifeHeld = false
            }
             */
        }))

        hiddenMinus4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            if (lifeTotal4 > 0){
                lifeTotal4--
            }
            life4.text = lifeTotal4.toString()
            /*
            if (!lifeHeld) {
                if (lifeTotal4 > 0){
                    lifeTotal4--
                }
                life4.text = lifeTotal4.toString()
                lifeHeld = true
            }
            else {
                lifeTotal4 -= 5
                if (lifeTotal4 < 0) {
                    lifeTotal4 = 0
                }
                life4.text = lifeTotal4.toString()
                lifeHeld = true
            }
            if (lifeHeld){
                lifeHeld = false
            }
             */
        }))
        hiddenPlus4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            lifeTotal4++
            life4.text = lifeTotal4.toString()
            /*
            if (!lifeHeld) {
                if (lifeTotal4 >= 0){
                    lifeTotal4++
                }
                else {
                    lifeTotal4 = 0
                }
                life4.text = lifeTotal4.toString()
                lifeHeld = true
            }
            else {
                lifeTotal4 += 5
                if (lifeTotal4 < 0) {
                    lifeTotal4 = 0
                }
                life4.text = lifeTotal4.toString()
                lifeHeld = true
            }
            if (lifeHeld){
                lifeHeld = false
            }
             */
        }))
        
        
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
