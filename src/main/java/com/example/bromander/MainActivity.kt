package com.example.bromander

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlarmManager
import android.app.Fragment
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.ContextMenu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.MotionEvent.INVALID_POINTER_ID
import android.view.View
import android.view.View.*
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MotionEventCompat
import java.util.*


class MainActivity : AppCompatActivity() {

    //Variables for tap gestures
    //lateinit var gestureDetector: GestureDetector
    //var doubleTapped = false
    val doubleTapTimeout = 300
    var lastClickTime = 0

    //Variables for XML elements of activity_main.xml
    lateinit var startButton: Button
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
    lateinit var white1: TextView
    lateinit var blue1: TextView
    lateinit var black1: TextView
    lateinit var red1: TextView
    lateinit var green1: TextView
    lateinit var storm1: TextView
    lateinit var white2: TextView
    lateinit var blue2: TextView
    lateinit var black2: TextView
    lateinit var red2: TextView
    lateinit var green2: TextView
    lateinit var storm2: TextView
    lateinit var white3: TextView
    lateinit var blue3: TextView
    lateinit var black3: TextView
    lateinit var red3: TextView
    lateinit var green3: TextView
    lateinit var storm3: TextView
    lateinit var white4: TextView
    lateinit var blue4: TextView
    lateinit var black4: TextView
    lateinit var red4: TextView
    lateinit var green4: TextView
    lateinit var storm4: TextView
    lateinit var player1Timer: Button
    lateinit var player2Timer: Button
    lateinit var player3Timer: Button
    lateinit var player4Timer: Button
    /*
    lateinit var player1TimerText: TextView
    lateinit var player2TimerText: TextView
    lateinit var player3TimerText: TextView
    lateinit var player4TimerText: TextView
    lateinit var player1Text: TextView
    lateinit var player2Text: TextView
    lateinit var player3Text: TextView
    lateinit var player4Text: TextView
     */
    lateinit var player1Area: View
    lateinit var player2Area: View
    lateinit var player3Area: View
    lateinit var player4Area: View
    lateinit var commanderIcon1: Button
    lateinit var manaIcon1: Button
    lateinit var optionsIcon1: Button
    lateinit var playIcon1: Button
    lateinit var commanderIcon2: Button
    lateinit var manaIcon2: Button
    lateinit var optionsIcon2: Button
    lateinit var playIcon2: Button
    lateinit var commanderIcon3: Button
    lateinit var manaIcon3: Button
    lateinit var optionsIcon3: Button
    lateinit var playIcon3: Button
    lateinit var commanderIcon4: Button
    lateinit var manaIcon4: Button
    lateinit var optionsIcon4: Button
    lateinit var playIcon4: Button
    lateinit var endTurn: Button
    lateinit var player1Background: View
    lateinit var player2Background: View
    lateinit var player3Background: View
    lateinit var player4Background: View
    lateinit var restart1: Button
    lateinit var rewind1: Button
    lateinit var restart2: Button
    lateinit var rewind2: Button
    lateinit var restart3: Button
    lateinit var rewind3: Button
    lateinit var restart4: Button
    lateinit var rewind4: Button
    lateinit var player1Damage2: TextView
    lateinit var player1Damage3: TextView
    lateinit var player1Damage4: TextView
    lateinit var player2Damage1: TextView
    lateinit var player2Damage3: TextView
    lateinit var player2Damage4: TextView
    lateinit var player3Damage2: TextView
    lateinit var player3Damage1: TextView
    lateinit var player3Damage4: TextView
    lateinit var player4Damage2: TextView
    lateinit var player4Damage3: TextView
    lateinit var player4Damage1: TextView

    //Additional global variables
    var lifeTotal1: Int = 40
    var lifeTotal2: Int = 40
    var lifeTotal3: Int = 40
    var lifeTotal4: Int = 40
    var white1Int: Int = 0
    var blue1Int: Int = 0
    var black1Int: Int = 0
    var red1Int: Int = 0
    var green1Int: Int = 0
    var storm1Int: Int = 0
    var white2Int: Int = 0
    var blue2Int: Int = 0
    var black2Int: Int = 0
    var red2Int: Int = 0
    var green2Int: Int = 0
    var storm2Int: Int = 0
    var white3Int: Int = 0
    var blue3Int: Int = 0
    var black3Int: Int = 0
    var red3Int: Int = 0
    var green3Int: Int = 0
    var storm3Int: Int = 0
    var white4Int: Int = 0
    var blue4Int: Int = 0
    var black4Int: Int = 0
    var red4Int: Int = 0
    var green4Int: Int = 0
    var storm4Int: Int = 0
    /*
        var commander1damage2: Int = 0
        var commander1damage3: Int = 0
        var commander1damage4: Int = 0
        var commander2damage1: Int = 0
        var commander2damage3: Int = 0
        var commander2damage4: Int = 0
        var commander3damage2: Int = 0
        var commander3damage1: Int = 0
        var commander3damage4: Int = 0
        var commander4damage2: Int = 0
        var commander4damage3: Int = 0
        var commander4damage1: Int = 0
         */
    var timer1: Int = 180
    var timer2: Int = 180
    var timer3: Int = 180
    var timer4: Int = 180
    var posX1: Float = 0.0f
    var posY1: Float = 0.0f
    var newPosX1: Float = 0.0f
    var newPosY1: Float = 0.0f
    var tempPosX1: Float = 0.0f
    var tempPosY1: Float = 0.0f
    var posX2: Float = 0.0f
    var posY2: Float = 0.0f
    var newPosX2: Float = 0.0f
    var newPosY2: Float = 0.0f
    var tempPosX2: Float = 0.0f
    var tempPosY2: Float = 0.0f
    var posX3: Float = 0.0f
    var posY3: Float = 0.0f
    var newPosX3: Float = 0.0f
    var newPosY3: Float = 0.0f
    var tempPosX3: Float = 0.0f
    var tempPosY3: Float = 0.0f
    var posX4: Float = 0.0f
    var posY4: Float = 0.0f
    var newPosX4: Float = 0.0f
    var newPosY4: Float = 0.0f
    var tempPosX4: Float = 0.0f
    var tempPosY4: Float = 0.0f
    var contextMenuHolder: Int = 1
    var currentPlayer: Int = 1
    var isPaused: Boolean = true
    var player1Color: String = "#ff63e5"
    var player2Color: String = "#59c8e9"
    var player3Color: String = "#9459f6"
    var player4Color: String = "#ff9d41"
    var isCommanderIcon1Pressed: Boolean = false
    var isManaIcon1Pressed: Boolean = false
    var isOptionsIcon1Pressed: Boolean = false
    var isPlayIcon1Pressed: Boolean = false
    var isCommanderIcon2Pressed: Boolean = false
    var isManaIcon2Pressed: Boolean = false
    var isOptionsIcon2Pressed: Boolean = false
    var isPlayIcon2Pressed: Boolean = false
    var isCommanderIcon3Pressed: Boolean = false
    var isManaIcon3Pressed: Boolean = false
    var isOptionsIcon3Pressed: Boolean = false
    var isPlayIcon3Pressed: Boolean = false
    var isCommanderIcon4Pressed: Boolean = false
    var isManaIcon4Pressed: Boolean = false
    var isOptionsIcon4Pressed: Boolean = false
    var isPlayIcon4Pressed: Boolean = false
    var isPlayerSelected: Boolean = false
    var timerAddition: Int = 150
    var player1Damage2Int: Int = 0
    var player1Damage3Int: Int = 0
    var player1Damage4Int: Int = 0
    var player2Damage1Int: Int = 0
    var player2Damage3Int: Int = 0
    var player2Damage4Int: Int = 0
    var player3Damage2Int: Int = 0
    var player3Damage1Int: Int = 0
    var player3Damage4Int: Int = 0
    var player4Damage2Int: Int = 0
    var player4Damage3Int: Int = 0
    var player4Damage1Int: Int = 0

    @SuppressLint("ClickableViewAccessibility")
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
        player1Area = findViewById(R.id.player1Area)
        player2Area = findViewById(R.id.player2Area)
        player3Area = findViewById(R.id.player3Area)
        player4Area = findViewById(R.id.player4Area)
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
        storm1 = findViewById(R.id.storm1)
        white2 = findViewById(R.id.white2)
        blue2 = findViewById(R.id.blue2)
        black2 = findViewById(R.id.black2)
        red2 = findViewById(R.id.red2)
        green2 = findViewById(R.id.green2)
        storm2 = findViewById(R.id.storm2)
        white3 = findViewById(R.id.white3)
        blue3 = findViewById(R.id.blue3)
        black3 = findViewById(R.id.black3)
        red3 = findViewById(R.id.red3)
        green3 = findViewById(R.id.green3)
        storm3 = findViewById(R.id.storm3)
        white4 = findViewById(R.id.white4)
        blue4 = findViewById(R.id.blue4)
        black4 = findViewById(R.id.black4)
        red4 = findViewById(R.id.red4)
        green4 = findViewById(R.id.green4)
        storm4 = findViewById(R.id.storm4)
        player1Timer = findViewById(R.id.player1Timer)
        player2Timer = findViewById(R.id.player2Timer)
        player3Timer = findViewById(R.id.player3Timer)
        player4Timer = findViewById(R.id.player4Timer)
        /*
        player1TimerText = findViewById(R.id.player1TimerText)
        player2TimerText = findViewById(R.id.player2TimerText)
        player3TimerText = findViewById(R.id.player3TimerText)
        player4TimerText = findViewById(R.id.player4TimerText)
        player1Text = findViewById(R.id.player1Text)
        player2Text = findViewById(R.id.player2Text)
        player3Text = findViewById(R.id.player3Text)
        player4Text = findViewById(R.id.player4Text)
        */
        startButton = findViewById(R.id.startButton)
        commanderIcon1 = findViewById(R.id.commanderIcon1)
        manaIcon1 = findViewById(R.id.manaIcon1)
        optionsIcon1 = findViewById(R.id.optionsIcon1)
        playIcon1 = findViewById(R.id.playIcon1)
        commanderIcon2 = findViewById(R.id.commanderIcon2)
        manaIcon2 = findViewById(R.id.manaIcon2)
        optionsIcon2 = findViewById(R.id.optionsIcon2)
        playIcon2 = findViewById(R.id.playIcon2)
        commanderIcon3 = findViewById(R.id.commanderIcon3)
        manaIcon3 = findViewById(R.id.manaIcon3)
        optionsIcon3 = findViewById(R.id.optionsIcon3)
        playIcon3 = findViewById(R.id.playIcon3)
        commanderIcon4 = findViewById(R.id.commanderIcon4)
        manaIcon4 = findViewById(R.id.manaIcon4)
        optionsIcon4 = findViewById(R.id.optionsIcon4)
        playIcon4 = findViewById(R.id.playIcon4)
        endTurn = findViewById(R.id.endTurn)
        player1Background = findViewById(R.id.player1Background)
        player2Background = findViewById(R.id.player2Background)
        player3Background = findViewById(R.id.player3Background)
        player4Background = findViewById(R.id.player4Background)
        restart1 = findViewById(R.id.restart1)
        rewind1 = findViewById(R.id.rewind1)
        restart2 = findViewById(R.id.restart2)
        rewind2 = findViewById(R.id.rewind2)
        restart3 = findViewById(R.id.restart3)
        rewind3 = findViewById(R.id.rewind3)
        restart4 = findViewById(R.id.restart4)
        rewind4 = findViewById(R.id.rewind4)
        player1Damage2 = findViewById(R.id.player1Damage2)
        player1Damage3 = findViewById(R.id.player1Damage3)
        player1Damage4 = findViewById(R.id.player1Damage4)
        player2Damage1 = findViewById(R.id.player2Damage1)
        player2Damage3 = findViewById(R.id.player2Damage3)
        player2Damage4 = findViewById(R.id.player2Damage4)
        player3Damage2 = findViewById(R.id.player3Damage2)
        player3Damage1 = findViewById(R.id.player3Damage1)
        player3Damage4 = findViewById(R.id.player3Damage4)
        player4Damage2 = findViewById(R.id.player4Damage2)
        player4Damage3 = findViewById(R.id.player4Damage3)
        player4Damage1 = findViewById(R.id.player4Damage1)

        //Set some views to invisible
        endTurn.visibility = GONE
        playIcon1.visibility = GONE
        playIcon2.visibility = GONE
        playIcon3.visibility = GONE
        playIcon4.visibility = GONE
        restart1.visibility = GONE
        rewind1.visibility = GONE
        restart2.visibility = GONE
        rewind2.visibility = GONE
        restart3.visibility = GONE
        rewind3.visibility = GONE
        restart4.visibility = GONE
        rewind4.visibility = GONE
        player1Damage2.visibility = GONE
        player1Damage3.visibility = GONE
        player1Damage4.visibility = GONE
        player2Damage1.visibility = GONE
        player2Damage3.visibility = GONE
        player2Damage4.visibility = GONE
        player3Damage2.visibility = GONE
        player3Damage1.visibility = GONE
        player3Damage4.visibility = GONE
        player4Damage2.visibility = GONE
        player4Damage3.visibility = GONE
        player4Damage1.visibility = GONE
        white1.visibility = GONE
        blue1.visibility = GONE
        black1.visibility = GONE
        red1.visibility = GONE
        green1.visibility = GONE
        storm1.visibility = GONE
        white2.visibility = GONE
        blue2.visibility = GONE
        black2.visibility = GONE
        red2.visibility = GONE
        green2.visibility = GONE
        storm2.visibility = GONE
        white3.visibility = GONE
        blue3.visibility = GONE
        black3.visibility = GONE
        red3.visibility = GONE
        green3.visibility = GONE
        storm3.visibility = GONE
        white4.visibility = GONE
        blue4.visibility = GONE
        black4.visibility = GONE
        red4.visibility = GONE
        green4.visibility = GONE
        storm4.visibility = GONE

        //Boot animation to decide starting player
        val bootThread: Thread = object : Thread() {
            @SuppressLint("ResourceAsColor")
            override fun run() {
                try {
                    while (!isPlayerSelected) {
                        val randomInt: Int = Random().nextInt(4)
                        runOnUiThread {
                            startButton.animate().apply {
                                duration = 5250
                                when (randomInt) {
                                    0 -> {
                                        rotation((360.0f * 5.0f) + 135.0f)
                                    }
                                    1 -> {
                                        rotation((360.0f * 5.0f) + 225.0f)
                                    }
                                    2 -> {
                                        rotation((360.0f * 5.0f) + 315.0f)
                                    }
                                    3 -> {
                                        rotation((360.0f * 5.0f) + 45.0f)
                                    }
                                }
                                rotationX(360.0f*5.0f)
                                rotationY(360.0f*5.0f)
                            }.start()
                        }
                        sleep(750)
                        life1.setTextColor(Color.parseColor(player1Color))
                        life2.setTextColor(Color.parseColor(player2Color))
                        life3.setTextColor(Color.parseColor(player3Color))
                        life4.setTextColor(Color.parseColor(player4Color))
                        sleep(1000)
                        life1.setTextColor(Color.parseColor("#ffffff"))
                        life2.setTextColor(Color.parseColor("#ffffff"))
                        life3.setTextColor(Color.parseColor("#ffffff"))
                        life4.setTextColor(Color.parseColor("#ffffff"))
                        sleep(750)
                        life1.setTextColor(Color.parseColor(player1Color))
                        life2.setTextColor(Color.parseColor(player2Color))
                        life3.setTextColor(Color.parseColor(player3Color))
                        life4.setTextColor(Color.parseColor(player4Color))
                        sleep(1000)
                        life1.setTextColor(Color.parseColor("#ffffff"))
                        life2.setTextColor(Color.parseColor("#ffffff"))
                        life3.setTextColor(Color.parseColor("#ffffff"))
                        life4.setTextColor(Color.parseColor("#ffffff"))
                        sleep(750)
                        life1.setTextColor(Color.parseColor(player1Color))
                        life2.setTextColor(Color.parseColor(player2Color))
                        life3.setTextColor(Color.parseColor(player3Color))
                        life4.setTextColor(Color.parseColor(player4Color))
                        sleep(1000)
                        life1.setTextColor(Color.parseColor("#ffffff"))
                        life2.setTextColor(Color.parseColor("#ffffff"))
                        life3.setTextColor(Color.parseColor("#ffffff"))
                        life4.setTextColor(Color.parseColor("#ffffff"))
                        when (randomInt) {
                            0 -> {
                                life1.setTextColor(Color.parseColor(player1Color))
                                startButton.setTextColor(Color.parseColor(player1Color))
                            }
                            1 -> {
                                life2.setTextColor(Color.parseColor(player2Color))
                                startButton.setTextColor(Color.parseColor(player2Color))
                            }
                            2 -> {
                                life3.setTextColor(Color.parseColor(player3Color))
                                startButton.setTextColor(Color.parseColor(player3Color))
                            }
                            3 -> {
                                life4.setTextColor(Color.parseColor(player4Color))
                                startButton.setTextColor(Color.parseColor(player4Color))
                            }
                        }
                        currentPlayer = randomInt + 1
                        isPlayerSelected = true
                        runOnUiThread {
                            endTurn.visibility = VISIBLE
                        }
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        bootThread.start()

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

        //Register for pop-up menus
        /*
        registerForContextMenu(player1Area)
        registerForContextMenu(player2Area)
        registerForContextMenu(player3Area)
        registerForContextMenu(player4Area)
         */

        //Listen for gestures on player areas
        var mActivePointerId = INVALID_POINTER_ID
        player1Area.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosX1 > newPosX1 + 20){
                        lifeTotal1++
                        life1.text = lifeTotal1.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    else if (tempPosX1 < newPosX1 - 20){
                        lifeTotal1--
                        if (lifeTotal1 <= 0){
                            lifeTotal1 = 0
                        }
                        life1.text = lifeTotal1.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosX1 > newPosX1 + 20){
                        lifeTotal1++
                        life1.text = lifeTotal1.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    else if (tempPosX1 < newPosX1 - 20){
                        lifeTotal1--
                        if (lifeTotal1 <= 0){
                            lifeTotal1 = 0
                        }
                        life1.text = lifeTotal1.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        player2Area.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosX2 < newPosX2 - 20){
                        lifeTotal2++
                        life2.text = lifeTotal2.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    else if (tempPosX2 > newPosX2 + 20){
                        lifeTotal2--
                        if (lifeTotal2 <= 0){
                            lifeTotal2 = 0
                        }
                        life2.text = lifeTotal2.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosX2 < newPosX2 - 20){
                        lifeTotal2++
                        life2.text = lifeTotal2.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    else if (tempPosX2 > newPosX2 + 20){
                        lifeTotal2--
                        if (lifeTotal2 <= 0){
                            lifeTotal2 = 0
                        }
                        life2.text = lifeTotal2.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        player3Area.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosX3 < newPosX3 - 20){
                        lifeTotal3++
                        life3.text = lifeTotal3.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    else if (tempPosX3 > newPosX3 + 20){
                        lifeTotal3--
                        if (lifeTotal3 <= 0){
                            lifeTotal3 = 0
                        }
                        life3.text = lifeTotal3.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosX3 < newPosX3 - 20){
                        lifeTotal3++
                        life3.text = lifeTotal3.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    else if (tempPosX3 > newPosX3 + 20){
                        lifeTotal3--
                        if (lifeTotal3 <= 0){
                            lifeTotal3 = 0
                        }
                        life3.text = lifeTotal3.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        player4Area.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosX4 > newPosX4 + 20){
                        lifeTotal4++
                        life4.text = lifeTotal4.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    else if (tempPosX4 < newPosX4 - 20){
                        lifeTotal4--
                        if (lifeTotal4 <= 0){
                            lifeTotal4 = 0
                        }
                        life4.text = lifeTotal4.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosX4 > newPosX4 + 20){
                        lifeTotal4++
                        life4.text = lifeTotal4.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    else if (tempPosX4 < newPosX4 - 20){
                        lifeTotal4--
                        if (lifeTotal4 <= 0){
                            lifeTotal4 = 0
                        }
                        life4.text = lifeTotal4.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        player1Damage2.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        player1Damage2Int++
                        player1Damage2.text = player1Damage2Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        player1Damage2Int--
                        if (player1Damage2Int <= 0){
                            player1Damage2Int = 0
                        }
                        player1Damage2.text = player1Damage2Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        player1Damage2Int++
                        player1Damage2.text = player1Damage2Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        player1Damage2Int--
                        if (player1Damage2Int <= 0){
                            player1Damage2Int = 0
                        }
                        player1Damage2.text = player1Damage2Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        player1Damage3.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        player1Damage3Int++
                        player1Damage3.text = player1Damage3Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        player1Damage3Int--
                        if (player1Damage3Int <= 0){
                            player1Damage3Int = 0
                        }
                        player1Damage3.text = player1Damage3Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        player1Damage3Int++
                        player1Damage3.text = player1Damage3Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        player1Damage3Int--
                        if (player1Damage3Int <= 0){
                            player1Damage3Int = 0
                        }
                        player1Damage3.text = player1Damage3Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        player1Damage4.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        player1Damage4Int++
                        player1Damage4.text = player1Damage4Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        player1Damage4Int--
                        if (player1Damage4Int <= 0){
                            player1Damage4Int = 0
                        }
                        player1Damage4.text = player1Damage4Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        player1Damage4Int++
                        player1Damage4.text = player1Damage4Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        player1Damage4Int--
                        if (player1Damage4Int <= 0){
                            player1Damage4Int = 0
                        }
                        player1Damage4.text = player1Damage4Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        player2Damage1.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        player2Damage1Int++
                        player2Damage1.text = player2Damage1Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        player2Damage1Int--
                        if (player2Damage1Int <= 0){
                            player2Damage1Int = 0
                        }
                        player2Damage1.text = player2Damage1Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        player2Damage1Int++
                        player2Damage1.text = player2Damage1Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        player2Damage1Int--
                        if (player2Damage1Int <= 0){
                            player2Damage1Int = 0
                        }
                        player2Damage1.text = player2Damage1Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        player2Damage3.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        player2Damage3Int++
                        player2Damage3.text = player2Damage3Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        player2Damage3Int--
                        if (player2Damage3Int <= 0){
                            player2Damage3Int = 0
                        }
                        player2Damage3.text = player2Damage3Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        player2Damage3Int++
                        player2Damage3.text = player2Damage3Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        player2Damage3Int--
                        if (player2Damage3Int <= 0){
                            player2Damage3Int = 0
                        }
                        player2Damage3.text = player2Damage3Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        player2Damage4.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        player2Damage4Int++
                        player2Damage4.text = player2Damage4Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        player2Damage4Int--
                        if (player2Damage4Int <= 0){
                            player2Damage4Int = 0
                        }
                        player2Damage4.text = player2Damage4Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        player2Damage4Int++
                        player2Damage4.text = player2Damage4Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        player2Damage4Int--
                        if (player2Damage4Int <= 0){
                            player2Damage4Int = 0
                        }
                        player2Damage4.text = player2Damage4Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        player3Damage1.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        player3Damage1Int++
                        player3Damage1.text = player3Damage1Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        player3Damage1Int--
                        if (player3Damage1Int <= 0){
                            player3Damage1Int = 0
                        }
                        player3Damage1.text = player3Damage1Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        player3Damage1Int++
                        player3Damage1.text = player3Damage1Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        player3Damage1Int--
                        if (player3Damage1Int <= 0){
                            player3Damage1Int = 0
                        }
                        player3Damage1.text = player3Damage1Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        player3Damage2.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        player3Damage2Int++
                        player3Damage2.text = player3Damage2Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        player3Damage2Int--
                        if (player3Damage2Int <= 0){
                            player3Damage2Int = 0
                        }
                        player3Damage2.text = player3Damage2Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        player3Damage2Int++
                        player3Damage2.text = player3Damage2Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        player3Damage2Int--
                        if (player3Damage2Int <= 0){
                            player3Damage2Int = 0
                        }
                        player3Damage2.text = player3Damage2Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        player3Damage4.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        player3Damage4Int++
                        player3Damage4.text = player3Damage4Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        player3Damage4Int--
                        if (player3Damage4Int <= 0){
                            player3Damage4Int = 0
                        }
                        player3Damage4.text = player3Damage4Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        player3Damage4Int++
                        player3Damage4.text = player3Damage4Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        player3Damage4Int--
                        if (player3Damage4Int <= 0){
                            player3Damage4Int = 0
                        }
                        player3Damage4.text = player3Damage4Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        player4Damage1.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        player4Damage1Int++
                        player4Damage1.text = player4Damage1Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        player4Damage1Int--
                        if (player4Damage1Int <= 0){
                            player4Damage1Int = 0
                        }
                        player4Damage1.text = player4Damage1Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        player4Damage1Int++
                        player4Damage1.text = player4Damage1Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        player4Damage1Int--
                        if (player4Damage1Int <= 0){
                            player4Damage1Int = 0
                        }
                        player4Damage1.text = player4Damage1Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        player4Damage2.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        player4Damage2Int++
                        player4Damage2.text = player4Damage2Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        player4Damage2Int--
                        if (player4Damage2Int <= 0){
                            player4Damage2Int = 0
                        }
                        player4Damage2.text = player4Damage2Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        player4Damage2Int++
                        player4Damage2.text = player4Damage2Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        player4Damage2Int--
                        if (player4Damage2Int <= 0){
                            player4Damage2Int = 0
                        }
                        player4Damage2.text = player4Damage2Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        player4Damage3.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        player4Damage3Int++
                        player4Damage3.text = player4Damage3Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        player4Damage3Int--
                        if (player4Damage3Int <= 0){
                            player4Damage3Int = 0
                        }
                        player4Damage3.text = player4Damage3Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        player4Damage3Int++
                        player4Damage3.text = player4Damage3Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        player4Damage3Int--
                        if (player4Damage3Int <= 0){
                            player4Damage3Int = 0
                        }
                        player4Damage3.text = player4Damage3Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        white1.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        white1Int++
                        white1.text = white1Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        white1Int--
                        if (white1Int <= 0){
                            white1Int = 0
                        }
                        white1.text = white1Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        white1Int++
                        white1.text = white1Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        white1Int--
                        if (white1Int <= 0){
                            white1Int = 0
                        }
                        white1.text = white1Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        blue1.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        blue1Int++
                        blue1.text = blue1Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        blue1Int--
                        if (blue1Int <= 0){
                            blue1Int = 0
                        }
                        blue1.text = blue1Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        blue1Int++
                        blue1.text = blue1Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        blue1Int--
                        if (blue1Int <= 0){
                            blue1Int = 0
                        }
                        blue1.text = blue1Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        black1.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        black1Int++
                        black1.text = black1Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        black1Int--
                        if (black1Int <= 0){
                            black1Int = 0
                        }
                        black1.text = black1Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        black1Int++
                        black1.text = black1Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        black1Int--
                        if (black1Int <= 0){
                            black1Int = 0
                        }
                        black1.text = black1Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        red1.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        red1Int++
                        red1.text = red1Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        red1Int--
                        if (red1Int <= 0){
                            red1Int = 0
                        }
                        red1.text = red1Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        red1Int++
                        red1.text = red1Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        red1Int--
                        if (red1Int <= 0){
                            red1Int = 0
                        }
                        red1.text = red1Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        green1.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        green1Int++
                        green1.text = green1Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        green1Int--
                        if (green1Int <= 0){
                            green1Int = 0
                        }
                        green1.text = green1Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        green1Int++
                        green1.text = green1Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        green1Int--
                        if (green1Int <= 0){
                            green1Int = 0
                        }
                        green1.text = green1Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        storm1.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        storm1Int++
                        storm1.text = storm1Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        storm1Int--
                        if (storm1Int <= 0){
                            storm1Int = 0
                        }
                        storm1.text = storm1Int.toString()
                        newPosX1 = tempPosX1
                        newPosY1 = tempPosY1
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX1 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY1 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY1 < newPosY1 - 20){
                        storm1Int++
                        storm1.text = storm1Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    else if (tempPosY1 > newPosY1 + 20){
                        storm1Int--
                        if (storm1Int <= 0){
                            storm1Int = 0
                        }
                        storm1.text = storm1Int.toString()
                        posX1 = newPosX1
                        posY1 = newPosY1
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        white2.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        white2Int++
                        white2.text = white2Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        white2Int--
                        if (white2Int <= 0){
                            white2Int = 0
                        }
                        white2.text = white2Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        white2Int++
                        white2.text = white2Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        white2Int--
                        if (white2Int <= 0){
                            white2Int = 0
                        }
                        white2.text = white2Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        blue2.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        blue2Int++
                        blue2.text = blue2Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        blue2Int--
                        if (blue2Int <= 0){
                            blue2Int = 0
                        }
                        blue2.text = blue2Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        blue2Int++
                        blue2.text = blue2Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        blue2Int--
                        if (blue2Int <= 0){
                            blue2Int = 0
                        }
                        blue2.text = blue2Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        black2.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        black2Int++
                        black2.text = black2Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        black2Int--
                        if (black2Int <= 0){
                            black2Int = 0
                        }
                        black2.text = black2Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        black2Int++
                        black2.text = black2Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        black2Int--
                        if (black2Int <= 0){
                            black2Int = 0
                        }
                        black2.text = black2Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        red2.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        red2Int++
                        red2.text = red2Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        red2Int--
                        if (red2Int <= 0){
                            red2Int = 0
                        }
                        red2.text = red2Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        red2Int++
                        red2.text = red2Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        red2Int--
                        if (red2Int <= 0){
                            red2Int = 0
                        }
                        red2.text = red2Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        green2.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        green2Int++
                        green2.text = green2Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        green2Int--
                        if (green2Int <= 0){
                            green2Int = 0
                        }
                        green2.text = green2Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        green2Int++
                        green2.text = green2Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        green2Int--
                        if (green2Int <= 0){
                            green2Int = 0
                        }
                        green2.text = green2Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        storm2.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        storm2Int++
                        storm2.text = storm2Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        storm2Int--
                        if (storm2Int <= 0){
                            storm2Int = 0
                        }
                        storm2.text = storm2Int.toString()
                        newPosX2 = tempPosX2
                        newPosY2 = tempPosY2
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX2 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY2 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY2 < newPosY2 - 20){
                        storm2Int++
                        storm2.text = storm2Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    else if (tempPosY2 > newPosY2 + 20){
                        storm2Int--
                        if (storm2Int <= 0){
                            storm2Int = 0
                        }
                        storm2.text = storm2Int.toString()
                        posX2 = newPosX2
                        posY2 = newPosY2
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        white3.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        white3Int++
                        white3.text = white3Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        white3Int--
                        if (white3Int <= 0){
                            white3Int = 0
                        }
                        white3.text = white3Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        white3Int++
                        white3.text = white3Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        white3Int--
                        if (white3Int <= 0){
                            white3Int = 0
                        }
                        white3.text = white3Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        blue3.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        blue3Int++
                        blue3.text = blue3Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        blue3Int--
                        if (blue3Int <= 0){
                            blue3Int = 0
                        }
                        blue3.text = blue3Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        blue3Int++
                        blue3.text = blue3Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        blue3Int--
                        if (blue3Int <= 0){
                            blue3Int = 0
                        }
                        blue3.text = blue3Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        black3.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        black3Int++
                        black3.text = black3Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        black3Int--
                        if (black3Int <= 0){
                            black3Int = 0
                        }
                        black3.text = black3Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        black3Int++
                        black3.text = black3Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        black3Int--
                        if (black3Int <= 0){
                            black3Int = 0
                        }
                        black3.text = black3Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        red3.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        red3Int++
                        red3.text = red3Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        red3Int--
                        if (red3Int <= 0){
                            red3Int = 0
                        }
                        red3.text = red3Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        red3Int++
                        red3.text = red3Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        red3Int--
                        if (red3Int <= 0){
                            red3Int = 0
                        }
                        red3.text = red3Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        green3.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        green3Int++
                        green3.text = green3Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        green3Int--
                        if (green3Int <= 0){
                            green3Int = 0
                        }
                        green3.text = green3Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        green3Int++
                        green3.text = green3Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        green3Int--
                        if (green3Int <= 0){
                            green3Int = 0
                        }
                        green3.text = green3Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        storm3.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        storm3Int++
                        storm3.text = storm3Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        storm3Int--
                        if (storm3Int <= 0){
                            storm3Int = 0
                        }
                        storm3.text = storm3Int.toString()
                        newPosX3 = tempPosX3
                        newPosY3 = tempPosY3
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX3 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY3 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY3 < newPosY3 - 20){
                        storm3Int++
                        storm3.text = storm3Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    else if (tempPosY3 > newPosY3 + 20){
                        storm3Int--
                        if (storm3Int <= 0){
                            storm3Int = 0
                        }
                        storm3.text = storm3Int.toString()
                        posX3 = newPosX3
                        posY3 = newPosY3
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        white4.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        white4Int++
                        white4.text = white4Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        white4Int--
                        if (white4Int <= 0){
                            white4Int = 0
                        }
                        white4.text = white4Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        white4Int++
                        white4.text = white4Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        white4Int--
                        if (white4Int <= 0){
                            white4Int = 0
                        }
                        white4.text = white4Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        blue4.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        blue4Int++
                        blue4.text = blue4Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        blue4Int--
                        if (blue4Int <= 0){
                            blue4Int = 0
                        }
                        blue4.text = blue4Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        blue4Int++
                        blue4.text = blue4Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        blue4Int--
                        if (blue4Int <= 0){
                            blue4Int = 0
                        }
                        blue4.text = blue4Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }
        
        black4.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        black4Int++
                        black4.text = black4Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        black4Int--
                        if (black4Int <= 0){
                            black4Int = 0
                        }
                        black4.text = black4Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        black4Int++
                        black4.text = black4Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        black4Int--
                        if (black4Int <= 0){
                            black4Int = 0
                        }
                        black4.text = black4Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        red4.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        red4Int++
                        red4.text = red4Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        red4Int--
                        if (red4Int <= 0){
                            red4Int = 0
                        }
                        red4.text = red4Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        red4Int++
                        red4.text = red4Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        red4Int--
                        if (red4Int <= 0){
                            red4Int = 0
                        }
                        red4.text = red4Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        green4.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        green4Int++
                        green4.text = green4Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        green4Int--
                        if (green4Int <= 0){
                            green4Int = 0
                        }
                        green4.text = green4Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        green4Int++
                        green4.text = green4Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        green4Int--
                        if (green4Int <= 0){
                            green4Int = 0
                        }
                        green4.text = green4Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        storm4.setOnTouchListener {v, event ->
            v.performClick()
            val action: Int = MotionEventCompat.getActionMasked(event)

            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        // Remember where we started (for dragging)
                        newPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        newPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }

                    // Save the ID of this pointer
                    mActivePointerId = MotionEventCompat.getPointerId(event, 0)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        storm4Int++
                        storm4.text = storm4Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        storm4Int--
                        if (storm4Int <= 0){
                            storm4Int = 0
                        }
                        storm4.text = storm4Int.toString()
                        newPosX4 = tempPosX4
                        newPosY4 = tempPosY4
                    }
                    true
                }
                MotionEvent.ACTION_UP -> {
                    
                    MotionEventCompat.getActionIndex(event).also { pointerIndex ->
                        tempPosX4 = MotionEventCompat.getX(event, pointerIndex)
                        tempPosY4 = MotionEventCompat.getY(event, pointerIndex)
                    }
                    if (tempPosY4 < newPosY4 - 20){
                        storm4Int++
                        storm4.text = storm4Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    else if (tempPosY4 > newPosY4 + 20){
                        storm4Int--
                        if (storm4Int <= 0){
                            storm4Int = 0
                        }
                        storm4.text = storm4Int.toString()
                        posX4 = newPosX4
                        posY4 = newPosY4
                    }
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }

        /*
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

        //Set onTouchListeners for life totals
        hiddenMinus4.setOnTouchListener { v, event ->
            v.performClick()

            var onTouchTimer: Timer = Timer()
            var usedLongClick: Boolean = false

            when (MotionEventCompat.getActionMasked(event)) {
                MotionEvent.ACTION_DOWN -> {
                    /*
                    onTouchTimer.schedule(object : TimerTask() {
                        override fun run() {
                            lifeTotal4 -= 5
                            if (lifeTotal4 <= 0){
                                lifeTotal4 = 0
                            }
                            //life4.text = lifeTotal4.toString()
                            usedLongClick = true
                        }
                    }, 1000, 1000)

                     */
                    while(event != MotionEvent.ACTION_UP)
                    
                    true
                }
                MotionEvent.ACTION_UP -> {
                    onTouchTimer.cancel()
                    //onTouchTimer.purge()
                    if (!usedLongClick) {
                        lifeTotal4--
                        if (lifeTotal4 <= 0){
                            lifeTotal4 = 0
                        }
                        life4.text = lifeTotal4.toString()
                    }
                    
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    onTouchTimer.cancel()
                    //onTouchTimer.purge()
                    
                    true
                }
                MotionEvent.ACTION_OUTSIDE -> {
                    
                    true
                }
                else -> super.onTouchEvent(event)
            }
        }
        
         */

        /*
        hiddenMinus4.setOnLongClickListener {
            lifeTotal4 -= 5
            if (lifeTotal4 <= 0){
                lifeTotal4 = 0
            }
            life4.text = lifeTotal4.toString()
            true
        }

        hiddenPlus4.setOnLongClickListener {
            lifeTotal4 += 5
            life4.text = lifeTotal4.toString()
            true
        }

         */

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
        white1.setOnLongClickListener(OnLongClickListener(){
            white1Counter = 0
            white1.text = ""
            true
        })

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
        blue1.setOnLongClickListener(OnLongClickListener(){
            blue1Counter = 0
            blue1.text = ""
            true
        })

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
        black1.setOnLongClickListener(OnLongClickListener(){
            black1Counter = 0
            black1.text = ""
            true
        })

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
        red1.setOnLongClickListener(OnLongClickListener(){
            red1Counter = 0
            red1.text = ""
            true
        })

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
        green1.setOnLongClickListener(OnLongClickListener(){
            green1Counter = 0
            green1.text = ""
            true
        })

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
        white2.setOnLongClickListener(OnLongClickListener(){
            white2Counter = 0
            white2.text = ""
            true
        })

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
        blue2.setOnLongClickListener(OnLongClickListener(){
            blue2Counter = 0
            blue2.text = ""
            true
        })

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
        black2.setOnLongClickListener(OnLongClickListener(){
            black2Counter = 0
            black2.text = ""
            true
        })

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
        red2.setOnLongClickListener(OnLongClickListener(){
            red2Counter = 0
            red2.text = ""
            true
        })

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
        green2.setOnLongClickListener(OnLongClickListener(){
            green2Counter = 0
            green2.text = ""
            true
        })

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
        white3.setOnLongClickListener(OnLongClickListener(){
            white3Counter = 0
            white3.text = ""
            true
        })

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
        blue3.setOnLongClickListener(OnLongClickListener(){
            blue3Counter = 0
            blue3.text = ""
            true
        })

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
        black3.setOnLongClickListener(OnLongClickListener(){
            black3Counter = 0
            black3.text = ""
            true
        })

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
        red3.setOnLongClickListener(OnLongClickListener(){
            red3Counter = 0
            red3.text = ""
            true
        })

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
        green3.setOnLongClickListener(OnLongClickListener(){
            green3Counter = 0
            green3.text = ""
            true
        })

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
        white4.setOnLongClickListener(OnLongClickListener(){
            white4Counter = 0
            white4.text = ""
            true
        })

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
        blue4.setOnLongClickListener(OnLongClickListener(){
            blue4Counter = 0
            blue4.text = ""
            true
        })

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
        black4.setOnLongClickListener(OnLongClickListener(){
            black4Counter = 0
            black4.text = ""
            true
        })

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
        red4.setOnLongClickListener(OnLongClickListener(){
            red4Counter = 0
            red4.text = ""
            true
        })

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
        green4.setOnLongClickListener(OnLongClickListener(){
            green4Counter = 0
            green4.text = ""
            true
        })
         */

        //Run timer in thread
        var timerHandler = Handler()
        val thread1: Thread = object : Thread() {
            override fun run() {
                try {
                    while (true) {
                        if (!isPaused) {
                            sleep(1000)
                            if (currentPlayer == 1) {
                                timer1--
                                if (timer1 <= 0) {
                                    timer1 = 0
                                }
                            }
                            else if (currentPlayer == 2) {
                                timer2--
                                if (timer2 <= 0) {
                                    timer2 = 0
                                }
                            }
                            else if (currentPlayer == 3) {
                                timer3--
                                if (timer3 <= 0) {
                                    timer3 = 0
                                }
                            }
                            else if (currentPlayer == 4) {
                                timer4--
                                if (timer4 <= 0) {
                                    timer4 = 0
                                }
                            }
                        }
                        //Uncomment section below to debug timers
                        /*
                        life1.text = timer1.toString()
                        life2.text = timer2.toString()
                        life3.text = timer3.toString()
                        life4.text = timer4.toString()
                        */
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }

        thread1.start()
        
        //Hide dev coloured counters
        /*
        white1.visibility = View.INVISIBLE
        white2.visibility = View.INVISIBLE
        white3.visibility = View.INVISIBLE
        white4.visibility = View.INVISIBLE
        blue1.visibility = View.INVISIBLE
        blue2.visibility = View.INVISIBLE
        blue3.visibility = View.INVISIBLE
        blue4.visibility = View.INVISIBLE
        black1.visibility = View.INVISIBLE
        black2.visibility = View.INVISIBLE
        black3.visibility = View.INVISIBLE
        black4.visibility = View.INVISIBLE
        red1.visibility = View.INVISIBLE
        red2.visibility = View.INVISIBLE
        red3.visibility = View.INVISIBLE
        red4.visibility = View.INVISIBLE
        green1.visibility = View.INVISIBLE
        green2.visibility = View.INVISIBLE
        green3.visibility = View.INVISIBLE
        green4.visibility = View.INVISIBLE
         */

        /*
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
         */

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
            
            isPaused = false
            playIcon1.background = this.getDrawable(R.drawable.pause_icon)
            playIcon2.background = this.getDrawable(R.drawable.pause_icon)
            playIcon3.background = this.getDrawable(R.drawable.pause_icon)
            playIcon4.background = this.getDrawable(R.drawable.pause_icon)
            if (!isCommanderIcon1Pressed && !isManaIcon1Pressed && !isOptionsIcon1Pressed) {
                playIcon1.visibility = VISIBLE
            }
            if (!isCommanderIcon2Pressed && !isManaIcon2Pressed && !isOptionsIcon2Pressed) {
                playIcon2.visibility = VISIBLE
            }
            if (!isCommanderIcon3Pressed && !isManaIcon3Pressed && !isOptionsIcon3Pressed) {
                playIcon3.visibility = VISIBLE
            }
            if (!isCommanderIcon4Pressed && !isManaIcon4Pressed && !isOptionsIcon4Pressed) {
                playIcon4.visibility = VISIBLE
            }
            if (startButton.text == "START") {
                startButton.text = ""
                when (currentPlayer) {
                    1 -> {
                        endTurn.background = this.getDrawable(R.drawable.tap_icon_1)
                        endTurn.rotation = 270.0f
                        commanderIcon1.backgroundTintList = this.getColorStateList(R.color.player1Color)
                        manaIcon1.backgroundTintList = this.getColorStateList(R.color.player1Color)
                        optionsIcon1.backgroundTintList = this.getColorStateList(R.color.player1Color)
                        playIcon1.backgroundTintList = this.getColorStateList(R.color.player1Color)
                        player1Background.setBackgroundColor(Color.parseColor("#ffffff"))
                        restart1.setTextColor(this.getColor(R.color.player1Color))
                        rewind1.setTextColor(this.getColor(R.color.player1Color))
                        player1Timer.animate().apply {
                            duration = 1000 * timer1.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                    2 -> {
                        endTurn.background = this.getDrawable(R.drawable.tap_icon_2)
                        endTurn.rotation =  0.0f
                        commanderIcon2.backgroundTintList = this.getColorStateList(R.color.player2Color)
                        manaIcon2.backgroundTintList = this.getColorStateList(R.color.player2Color)
                        optionsIcon2.backgroundTintList = this.getColorStateList(R.color.player2Color)
                        playIcon2.backgroundTintList = this.getColorStateList(R.color.player2Color)
                        player2Background.setBackgroundColor(Color.parseColor("#ffffff"))
                        restart2.setTextColor(this.getColor(R.color.player2Color))
                        rewind2.setTextColor(this.getColor(R.color.player2Color))
                        player2Timer.animate().apply {
                            duration = 1000 * timer2.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                    3 -> {
                        endTurn.background = this.getDrawable(R.drawable.tap_icon_3)
                        endTurn.rotation = 90.0f
                        commanderIcon3.backgroundTintList = this.getColorStateList(R.color.player3Color)
                        manaIcon3.backgroundTintList = this.getColorStateList(R.color.player3Color)
                        optionsIcon3.backgroundTintList = this.getColorStateList(R.color.player3Color)
                        playIcon3.backgroundTintList = this.getColorStateList(R.color.player3Color)
                        player3Background.setBackgroundColor(Color.parseColor("#ffffff"))
                        restart3.setTextColor(this.getColor(R.color.player3Color))
                        rewind3.setTextColor(this.getColor(R.color.player3Color))
                        player3Timer.animate().apply {
                            duration = 1000 * timer3.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                    4 -> {
                        endTurn.background = this.getDrawable(R.drawable.tap_icon_4)
                        endTurn.rotation = 180.0f
                        commanderIcon4.backgroundTintList = this.getColorStateList(R.color.player4Color)
                        manaIcon4.backgroundTintList = this.getColorStateList(R.color.player4Color)
                        optionsIcon4.backgroundTintList = this.getColorStateList(R.color.player4Color)
                        playIcon4.backgroundTintList = this.getColorStateList(R.color.player4Color)
                        player4Background.setBackgroundColor(Color.parseColor("#ffffff"))
                        restart4.setTextColor(this.getColor(R.color.player4Color))
                        rewind4.setTextColor(this.getColor(R.color.player4Color))
                        player4Timer.animate().apply {
                            duration = 1000 * timer4.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                }
            }
            else {
                when (currentPlayer) {
                    1 -> {
                        endTurn.background = this.getDrawable(R.drawable.tap_icon_2)
                        currentPlayer = 2
                        endTurn.rotation = 0.0f
                        life1.setTextColor(Color.parseColor("#ffffff"))
                        life2.setTextColor(Color.parseColor(player2Color))
                        commanderIcon1.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                        manaIcon1.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                        optionsIcon1.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                        playIcon1.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                        commanderIcon2.backgroundTintList = this.getColorStateList(R.color.player2Color)
                        manaIcon2.backgroundTintList = this.getColorStateList(R.color.player2Color)
                        optionsIcon2.backgroundTintList = this.getColorStateList(R.color.player2Color)
                        playIcon2.backgroundTintList = this.getColorStateList(R.color.player2Color)
                        restart1.setTextColor(Color.parseColor("#ffffff"))
                        rewind1.setTextColor(Color.parseColor("#ffffff"))
                        restart2.setTextColor(this.getColor(R.color.player2Color))
                        rewind2.setTextColor(this.getColor(R.color.player2Color))
                        if (!isCommanderIcon1Pressed && !isManaIcon1Pressed && !isOptionsIcon1Pressed) {
                            player1Background.setBackgroundColor(Color.parseColor("#000000"))
                        }
                        else {
                            player1Background.setBackgroundColor(Color.parseColor(player1Color))
                        }
                        player2Background.setBackgroundColor(Color.parseColor("#ffffff"))
                        player2Timer.animate().apply {
                            duration = 1000 * timer2.toLong()
                            scaleY(0.0f)
                        }.start()
                        player1Timer.clearAnimation()
                        player1Timer.animate().cancel()
                        player1Timer.animate().apply {
                            duration = 1000
                            scaleY(1.0f)
                        }.start()
                        timer1 += timerAddition
                        if (timer1 > 900) {
                            timer1 = 900
                        }
                        else if (timer1 < 180) {
                            timer1 = 180
                        }
                    }
                    2 -> {
                        endTurn.background = this.getDrawable(R.drawable.tap_icon_3)
                        endTurn.rotation = 90.0f
                        currentPlayer = 3
                        life2.setTextColor(Color.parseColor("#ffffff"))
                        life3.setTextColor(Color.parseColor(player3Color))
                        commanderIcon2.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                        manaIcon2.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                        optionsIcon2.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                        playIcon2.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                        commanderIcon3.backgroundTintList = this.getColorStateList(R.color.player3Color)
                        manaIcon3.backgroundTintList = this.getColorStateList(R.color.player3Color)
                        optionsIcon3.backgroundTintList = this.getColorStateList(R.color.player3Color)
                        playIcon3.backgroundTintList = this.getColorStateList(R.color.player3Color)
                        restart2.setTextColor(Color.parseColor("#ffffff"))
                        rewind2.setTextColor(Color.parseColor("#ffffff"))
                        restart3.setTextColor(this.getColor(R.color.player3Color))
                        rewind3.setTextColor(this.getColor(R.color.player3Color))
                        if (!isCommanderIcon2Pressed && !isManaIcon2Pressed && !isOptionsIcon2Pressed) {
                            player2Background.setBackgroundColor(Color.parseColor("#000000"))
                        }
                        else {
                            player2Background.setBackgroundColor(Color.parseColor(player2Color))
                        }
                        player3Background.setBackgroundColor(Color.parseColor("#ffffff"))
                        player3Timer.animate().apply {
                            duration = 1000 * timer3.toLong()
                            scaleY(0.0f)
                        }.start()
                        player2Timer.clearAnimation()
                        player2Timer.animate().cancel()
                        player2Timer.animate().apply {
                            duration = 1000
                            scaleY(1.0f)
                        }.start()
                        timer2 += timerAddition
                        if (timer2 > 900) {
                            timer2 = 900
                        }
                        else if (timer2 < 180) {
                            timer2 = 180
                        }
                    }
                    3 -> {
                        endTurn.background = this.getDrawable(R.drawable.tap_icon_4)
                        endTurn.rotation = 180.0f
                        currentPlayer = 4
                        life3.setTextColor(Color.parseColor("#ffffff"))
                        life4.setTextColor(Color.parseColor(player4Color))
                        commanderIcon3.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                        manaIcon3.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                        optionsIcon3.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                        playIcon3.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                        commanderIcon4.backgroundTintList = this.getColorStateList(R.color.player4Color)
                        manaIcon4.backgroundTintList = this.getColorStateList(R.color.player4Color)
                        optionsIcon4.backgroundTintList = this.getColorStateList(R.color.player4Color)
                        playIcon4.backgroundTintList = this.getColorStateList(R.color.player4Color)
                        restart3.setTextColor(Color.parseColor("#ffffff"))
                        rewind3.setTextColor(Color.parseColor("#ffffff"))
                        restart4.setTextColor(this.getColor(R.color.player4Color))
                        rewind4.setTextColor(this.getColor(R.color.player4Color))
                        if (!isCommanderIcon3Pressed && !isManaIcon3Pressed && !isOptionsIcon3Pressed) {
                            player3Background.setBackgroundColor(Color.parseColor("#000000"))
                        }
                        else {
                            player3Background.setBackgroundColor(Color.parseColor(player3Color))
                        }
                        player4Background.setBackgroundColor(Color.parseColor("#ffffff"))
                        player4Timer.animate().apply {
                            duration = 1000 * timer4.toLong()
                            scaleY(0.0f)
                        }.start()
                        player3Timer.clearAnimation()
                        player3Timer.animate().cancel()
                        player3Timer.animate().apply {
                            duration = 1000
                            scaleY(1.0f)
                        }.start()
                        timer3 += timerAddition
                        if (timer3 > 900) {
                            timer3 = 900
                        }
                        else if (timer3 < 180) {
                            timer3 = 180
                        }
                    }
                    4 -> {
                        endTurn.background = this.getDrawable(R.drawable.tap_icon_1)
                        endTurn.rotation = 270.0f
                        currentPlayer = 1
                        life4.setTextColor(Color.parseColor("#ffffff"))
                        life1.setTextColor(Color.parseColor(player1Color))
                        commanderIcon4.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                        manaIcon4.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                        optionsIcon4.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                        playIcon4.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                        commanderIcon1.backgroundTintList = this.getColorStateList(R.color.player1Color)
                        manaIcon1.backgroundTintList = this.getColorStateList(R.color.player1Color)
                        optionsIcon1.backgroundTintList = this.getColorStateList(R.color.player1Color)
                        playIcon1.backgroundTintList = this.getColorStateList(R.color.player1Color)
                        restart4.setTextColor(Color.parseColor("#ffffff"))
                        rewind4.setTextColor(Color.parseColor("#ffffff"))
                        restart1.setTextColor(this.getColor(R.color.player1Color))
                        rewind1.setTextColor(this.getColor(R.color.player1Color))
                        if (!isCommanderIcon4Pressed && !isManaIcon4Pressed && !isOptionsIcon4Pressed) {
                            player4Background.setBackgroundColor(Color.parseColor("#000000"))
                        }
                        else {
                            player4Background.setBackgroundColor(Color.parseColor(player4Color))
                        }
                        player1Background.setBackgroundColor(Color.parseColor("#ffffff"))
                        player1Timer.animate().apply {
                            duration = 1000 * timer1.toLong()
                            scaleY(0.0f)
                        }.start()
                        player4Timer.clearAnimation()
                        player4Timer.animate().cancel()
                        player4Timer.animate().apply {
                            duration = 1000
                            scaleY(1.0f)
                        }.start()
                        timer4 += timerAddition
                        if (timer4 > 900) {
                            timer4 = 900
                        }
                        else if (timer4 < 180) {
                            timer4 = 180
                        }
                    }
                }
            }
        }

        commanderIcon1.setOnClickListener {
            if (!isCommanderIcon1Pressed){
                isCommanderIcon1Pressed = true
                commanderIcon1.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                player1Background.setBackgroundColor(Color.parseColor(player1Color))
                player1Area.visibility = INVISIBLE
                life1.visibility = GONE
                manaIcon1.visibility = GONE
                optionsIcon1.visibility = GONE
                playIcon1.visibility = GONE
                player1Damage2.visibility = VISIBLE
                player1Damage3.visibility = VISIBLE
                player1Damage4.visibility = VISIBLE
            }
            else {
                isCommanderIcon1Pressed = false
                if (currentPlayer == 1 && startButton.text != "START") {
                    commanderIcon1.backgroundTintList = this.getColorStateList(R.color.player1Color)
                    player1Background.setBackgroundColor(Color.parseColor("#ffffff"))
                }
                else {
                    player1Background.setBackgroundColor(Color.parseColor("#000000"))
                }
                player1Area.visibility = VISIBLE
                life1.visibility = VISIBLE
                manaIcon1.visibility = VISIBLE
                optionsIcon1.visibility = VISIBLE
                if (startButton.text != "START") {
                    playIcon1.visibility = VISIBLE
                }
                player1Damage2.visibility = GONE
                player1Damage3.visibility = GONE
                player1Damage4.visibility = GONE
            }
        }

        manaIcon1.setOnClickListener {
            if (!isManaIcon1Pressed){
                isManaIcon1Pressed = true
                manaIcon1.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                player1Background.setBackgroundColor(Color.parseColor(player1Color))
                player1Area.visibility = INVISIBLE
                life1.visibility = GONE
                commanderIcon1.visibility = GONE
                optionsIcon1.visibility = GONE
                playIcon1.visibility = GONE
                white1.visibility = VISIBLE
                blue1.visibility = VISIBLE
                black1.visibility = VISIBLE
                red1.visibility = VISIBLE
                green1.visibility = VISIBLE
                storm1.visibility = VISIBLE
            }
            else {
                isManaIcon1Pressed = false
                if (currentPlayer == 1 && startButton.text != "START") {
                    manaIcon1.backgroundTintList = this.getColorStateList(R.color.player1Color)
                    player1Background.setBackgroundColor(Color.parseColor("#ffffff"))
                }
                else {
                    player1Background.setBackgroundColor(Color.parseColor("#000000"))
                }
                player1Area.visibility = VISIBLE
                life1.visibility = VISIBLE
                commanderIcon1.visibility = VISIBLE
                optionsIcon1.visibility = VISIBLE
                if (startButton.text != "START") {
                    playIcon1.visibility = VISIBLE
                }
                white1.visibility = GONE
                blue1.visibility = GONE
                black1.visibility = GONE
                red1.visibility = GONE
                green1.visibility = GONE
                storm1.visibility = GONE
            }
        }

        optionsIcon1.setOnClickListener {
            if (!isOptionsIcon1Pressed){
                isOptionsIcon1Pressed = true
                if (currentPlayer == 1) {
                    restart1.setTextColor(Color.parseColor("#ffffff"))
                    rewind1.setTextColor(Color.parseColor("#ffffff"))
                }
                optionsIcon1.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                player1Background.setBackgroundColor(Color.parseColor(player1Color))
                player1Area.visibility = INVISIBLE
                life1.visibility = GONE
                commanderIcon1.visibility = GONE
                manaIcon1.visibility = GONE
                playIcon1.visibility = GONE
                restart1.visibility = VISIBLE
                rewind1.visibility = VISIBLE
            }
            else {
                isOptionsIcon1Pressed = false
                if (currentPlayer == 1 && startButton.text != "START") {
                    optionsIcon1.backgroundTintList = this.getColorStateList(R.color.player1Color)
                    player1Background.setBackgroundColor(Color.parseColor("#ffffff"))
                }
                else {
                    player1Background.setBackgroundColor(Color.parseColor("#000000"))
                }
                player1Area.visibility = VISIBLE
                life1.visibility = VISIBLE
                commanderIcon1.visibility = VISIBLE
                manaIcon1.visibility = VISIBLE
                if (startButton.text != "START") {
                    playIcon1.visibility = VISIBLE
                }
                restart1.visibility = GONE
                rewind1.visibility = GONE
            }
        }

        playIcon1.setOnClickListener {
            if (isPaused) {
                isPaused = false
                playIcon1.background = this.getDrawable(R.drawable.pause_icon)
                playIcon2.background = this.getDrawable(R.drawable.pause_icon)
                playIcon3.background = this.getDrawable(R.drawable.pause_icon)
                playIcon4.background = this.getDrawable(R.drawable.pause_icon)
                when (currentPlayer) {
                    1 -> {
                        player1Timer.animate().apply {
                            duration = 1000 * timer1.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                    2 -> {
                        player2Timer.animate().apply {
                            duration = 1000 * timer2.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                    3 -> {
                        player3Timer.animate().apply {
                            duration = 1000 * timer3.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                    4 -> {
                        player4Timer.animate().apply {
                            duration = 1000 * timer4.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                }
            }
            else {
                isPaused = true
                playIcon1.background = this.getDrawable(R.drawable.play_icon)
                playIcon2.background = this.getDrawable(R.drawable.play_icon)
                playIcon3.background = this.getDrawable(R.drawable.play_icon)
                playIcon4.background = this.getDrawable(R.drawable.play_icon)
                when (currentPlayer) {
                    1 -> {
                        player1Timer.clearAnimation()
                        player1Timer.animate().cancel()
                    }
                    2 -> {
                        player2Timer.clearAnimation()
                        player2Timer.animate().cancel()
                    }
                    3 -> {
                        player3Timer.clearAnimation()
                        player3Timer.animate().cancel()
                    }
                    4 -> {
                        player4Timer.clearAnimation()
                        player4Timer.animate().cancel()
                    }
                }
            }
        }

        commanderIcon2.setOnClickListener {
            if (!isCommanderIcon2Pressed){
                isCommanderIcon2Pressed = true
                commanderIcon2.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                player2Background.setBackgroundColor(Color.parseColor(player2Color))
                player2Area.visibility = INVISIBLE
                life2.visibility = GONE
                manaIcon2.visibility = GONE
                optionsIcon2.visibility = GONE
                playIcon2.visibility = GONE
                player2Damage1.visibility = VISIBLE
                player2Damage3.visibility = VISIBLE
                player2Damage4.visibility = VISIBLE
            }
            else {
                isCommanderIcon2Pressed = false
                if (currentPlayer == 2 && startButton.text != "START") {
                    commanderIcon2.backgroundTintList = this.getColorStateList(R.color.player2Color)
                    player2Background.setBackgroundColor(Color.parseColor("#ffffff"))
                }
                else {
                    player2Background.setBackgroundColor(Color.parseColor("#000000"))
                }
                player2Area.visibility = VISIBLE
                life2.visibility = VISIBLE
                manaIcon2.visibility = VISIBLE
                optionsIcon2.visibility = VISIBLE
                if (startButton.text != "START") {
                    playIcon2.visibility = VISIBLE
                }
                player2Damage1.visibility = GONE
                player2Damage3.visibility = GONE
                player2Damage4.visibility = GONE
            }
        }

        manaIcon2.setOnClickListener {
            if (!isManaIcon2Pressed){
                isManaIcon2Pressed = true
                manaIcon2.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                player2Background.setBackgroundColor(Color.parseColor(player2Color))
                player2Area.visibility = INVISIBLE
                life2.visibility = GONE
                commanderIcon2.visibility = GONE
                optionsIcon2.visibility = GONE
                playIcon2.visibility = GONE
                white2.visibility = VISIBLE
                blue2.visibility = VISIBLE
                black2.visibility = VISIBLE
                red2.visibility = VISIBLE
                green2.visibility = VISIBLE
                storm2.visibility = VISIBLE
            }
            else {
                isManaIcon2Pressed = false
                if (currentPlayer == 2 && startButton.text != "START") {
                    manaIcon2.backgroundTintList = this.getColorStateList(R.color.player2Color)
                    player2Background.setBackgroundColor(Color.parseColor("#ffffff"))
                }
                else {
                    player2Background.setBackgroundColor(Color.parseColor("#000000"))
                }
                player2Area.visibility = VISIBLE
                life2.visibility = VISIBLE
                commanderIcon2.visibility = VISIBLE
                optionsIcon2.visibility = VISIBLE
                if (startButton.text != "START") {
                    playIcon2.visibility = VISIBLE
                }
                white2.visibility = GONE
                blue2.visibility = GONE
                black2.visibility = GONE
                red2.visibility = GONE
                green2.visibility = GONE
                storm2.visibility = GONE
            }
        }

        optionsIcon2.setOnClickListener {
            if (!isOptionsIcon2Pressed){
                isOptionsIcon2Pressed = true
                if (currentPlayer == 2) {
                    restart2.setTextColor(Color.parseColor("#ffffff"))
                    rewind2.setTextColor(Color.parseColor("#ffffff"))
                }
                optionsIcon2.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                player2Background.setBackgroundColor(Color.parseColor(player2Color))
                player2Area.visibility = INVISIBLE
                life2.visibility = GONE
                commanderIcon2.visibility = GONE
                manaIcon2.visibility = GONE
                playIcon2.visibility = GONE
                restart2.visibility = VISIBLE
                rewind2.visibility = VISIBLE
            }
            else {
                isOptionsIcon2Pressed = false
                if (currentPlayer == 2 && startButton.text != "START") {
                    optionsIcon2.backgroundTintList = this.getColorStateList(R.color.player2Color)
                    player2Background.setBackgroundColor(Color.parseColor("#ffffff"))
                }
                else {
                    player2Background.setBackgroundColor(Color.parseColor("#000000"))
                }
                player2Area.visibility = VISIBLE
                life2.visibility = VISIBLE
                commanderIcon2.visibility = VISIBLE
                manaIcon2.visibility = VISIBLE
                if (startButton.text != "START") {
                    playIcon2.visibility = VISIBLE
                }
                restart2.visibility = GONE
                rewind2.visibility = GONE
            }
        }

        playIcon2.setOnClickListener {
            if (isPaused) {
                isPaused = false
                playIcon1.background = this.getDrawable(R.drawable.pause_icon)
                playIcon2.background = this.getDrawable(R.drawable.pause_icon)
                playIcon3.background = this.getDrawable(R.drawable.pause_icon)
                playIcon4.background = this.getDrawable(R.drawable.pause_icon)
                when (currentPlayer) {
                    1 -> {
                        player1Timer.animate().apply {
                            duration = 1000 * timer1.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                    2 -> {
                        player2Timer.animate().apply {
                            duration = 1000 * timer2.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                    3 -> {
                        player3Timer.animate().apply {
                            duration = 1000 * timer3.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                    4 -> {
                        player4Timer.animate().apply {
                            duration = 1000 * timer4.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                }
            }
            else {
                isPaused = true
                playIcon1.background = this.getDrawable(R.drawable.play_icon)
                playIcon2.background = this.getDrawable(R.drawable.play_icon)
                playIcon3.background = this.getDrawable(R.drawable.play_icon)
                playIcon4.background = this.getDrawable(R.drawable.play_icon)
                when (currentPlayer) {
                    1 -> {
                        player1Timer.clearAnimation()
                        player1Timer.animate().cancel()
                    }
                    2 -> {
                        player2Timer.clearAnimation()
                        player2Timer.animate().cancel()
                    }
                    3 -> {
                        player3Timer.clearAnimation()
                        player3Timer.animate().cancel()
                    }
                    4 -> {
                        player4Timer.clearAnimation()
                        player4Timer.animate().cancel()
                    }
                }
            }
        }

        commanderIcon3.setOnClickListener {
            if (!isCommanderIcon3Pressed){
                isCommanderIcon3Pressed = true
                commanderIcon3.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                player3Background.setBackgroundColor(Color.parseColor(player3Color))
                player3Area.visibility = INVISIBLE
                life3.visibility = GONE
                manaIcon3.visibility = GONE
                optionsIcon3.visibility = GONE
                playIcon3.visibility = GONE
                player3Damage2.visibility = VISIBLE
                player3Damage1.visibility = VISIBLE
                player3Damage4.visibility = VISIBLE
            }
            else {
                isCommanderIcon3Pressed = false
                if (currentPlayer == 3 && startButton.text != "START") {
                    commanderIcon3.backgroundTintList = this.getColorStateList(R.color.player3Color)
                    player3Background.setBackgroundColor(Color.parseColor("#ffffff"))
                }
                else {
                    player3Background.setBackgroundColor(Color.parseColor("#000000"))
                }
                player3Area.visibility = VISIBLE
                life3.visibility = VISIBLE
                manaIcon3.visibility = VISIBLE
                optionsIcon3.visibility = VISIBLE
                if (startButton.text != "START") {
                    playIcon3.visibility = VISIBLE
                }
                player3Damage2.visibility = GONE
                player3Damage1.visibility = GONE
                player3Damage4.visibility = GONE
            }
        }

        manaIcon3.setOnClickListener {
            if (!isManaIcon3Pressed){
                isManaIcon3Pressed = true
                manaIcon3.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                player3Background.setBackgroundColor(Color.parseColor(player3Color))
                player3Area.visibility = INVISIBLE
                life3.visibility = GONE
                commanderIcon3.visibility = GONE
                optionsIcon3.visibility = GONE
                playIcon3.visibility = GONE
                white3.visibility = VISIBLE
                blue3.visibility = VISIBLE
                black3.visibility = VISIBLE
                red3.visibility = VISIBLE
                green3.visibility = VISIBLE
                storm3.visibility = VISIBLE
            }
            else {
                isManaIcon3Pressed = false
                if (currentPlayer == 3 && startButton.text != "START") {
                    manaIcon3.backgroundTintList = this.getColorStateList(R.color.player3Color)
                    player3Background.setBackgroundColor(Color.parseColor("#ffffff"))
                }
                else {
                    player3Background.setBackgroundColor(Color.parseColor("#000000"))
                }
                player3Area.visibility = VISIBLE
                life3.visibility = VISIBLE
                commanderIcon3.visibility = VISIBLE
                optionsIcon3.visibility = VISIBLE
                if (startButton.text != "START") {
                    playIcon3.visibility = VISIBLE
                }
                white3.visibility = GONE
                blue3.visibility = GONE
                black3.visibility = GONE
                red3.visibility = GONE
                green3.visibility = GONE
                storm3.visibility = GONE
            }
        }

        optionsIcon3.setOnClickListener {
            if (!isOptionsIcon3Pressed){
                isOptionsIcon3Pressed = true
                if (currentPlayer == 3) {
                    restart3.setTextColor(Color.parseColor("#ffffff"))
                    rewind3.setTextColor(Color.parseColor("#ffffff"))
                }
                optionsIcon3.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                player3Background.setBackgroundColor(Color.parseColor(player3Color))
                player3Area.visibility = INVISIBLE
                life3.visibility = GONE
                commanderIcon3.visibility = GONE
                manaIcon3.visibility = GONE
                playIcon3.visibility = GONE
                restart3.visibility = VISIBLE
                rewind3.visibility = VISIBLE
            }
            else {
                isOptionsIcon3Pressed = false
                if (currentPlayer == 3 && startButton.text != "START") {
                    optionsIcon3.backgroundTintList = this.getColorStateList(R.color.player3Color)
                    player3Background.setBackgroundColor(Color.parseColor("#ffffff"))
                }
                else {
                    player3Background.setBackgroundColor(Color.parseColor("#000000"))
                }
                player3Area.visibility = VISIBLE
                life3.visibility = VISIBLE
                commanderIcon3.visibility = VISIBLE
                manaIcon3.visibility = VISIBLE
                if (startButton.text != "START") {
                    playIcon3.visibility = VISIBLE
                }
                restart3.visibility = GONE
                rewind3.visibility = GONE
            }
        }

        playIcon3.setOnClickListener {
            if (isPaused) {
                isPaused = false
                playIcon1.background = this.getDrawable(R.drawable.pause_icon)
                playIcon2.background = this.getDrawable(R.drawable.pause_icon)
                playIcon3.background = this.getDrawable(R.drawable.pause_icon)
                playIcon4.background = this.getDrawable(R.drawable.pause_icon)
                when (currentPlayer) {
                    1 -> {
                        player1Timer.animate().apply {
                            duration = 1000 * timer1.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                    2 -> {
                        player2Timer.animate().apply {
                            duration = 1000 * timer2.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                    3 -> {
                        player3Timer.animate().apply {
                            duration = 1000 * timer3.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                    4 -> {
                        player4Timer.animate().apply {
                            duration = 1000 * timer4.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                }
            }
            else {
                isPaused = true
                playIcon1.background = this.getDrawable(R.drawable.play_icon)
                playIcon2.background = this.getDrawable(R.drawable.play_icon)
                playIcon3.background = this.getDrawable(R.drawable.play_icon)
                playIcon4.background = this.getDrawable(R.drawable.play_icon)
                when (currentPlayer) {
                    1 -> {
                        player1Timer.clearAnimation()
                        player1Timer.animate().cancel()
                    }
                    2 -> {
                        player2Timer.clearAnimation()
                        player2Timer.animate().cancel()
                    }
                    3 -> {
                        player3Timer.clearAnimation()
                        player3Timer.animate().cancel()
                    }
                    4 -> {
                        player4Timer.clearAnimation()
                        player4Timer.animate().cancel()
                    }
                }
            }
        }

        commanderIcon4.setOnClickListener {
            if (!isCommanderIcon4Pressed){
                isCommanderIcon4Pressed = true
                commanderIcon4.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                player4Background.setBackgroundColor(Color.parseColor(player4Color))
                player4Area.visibility = INVISIBLE
                life4.visibility = GONE
                manaIcon4.visibility = GONE
                optionsIcon4.visibility = GONE
                playIcon4.visibility = GONE
                player4Damage2.visibility = VISIBLE
                player4Damage3.visibility = VISIBLE
                player4Damage1.visibility = VISIBLE
            }
            else {
                isCommanderIcon4Pressed = false
                if (currentPlayer == 4 && startButton.text != "START") {
                    commanderIcon4.backgroundTintList = this.getColorStateList(R.color.player4Color)
                    player4Background.setBackgroundColor(Color.parseColor("#ffffff"))
                }
                else {
                    player4Background.setBackgroundColor(Color.parseColor("#000000"))
                }
                player4Area.visibility = VISIBLE
                life4.visibility = VISIBLE
                manaIcon4.visibility = VISIBLE
                optionsIcon4.visibility = VISIBLE
                if (startButton.text != "START") {
                    playIcon4.visibility = VISIBLE
                }
                player4Damage2.visibility = GONE
                player4Damage3.visibility = GONE
                player4Damage1.visibility = GONE
            }
        }

        manaIcon4.setOnClickListener {
            if (!isManaIcon4Pressed){
                isManaIcon4Pressed = true
                manaIcon4.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                player4Background.setBackgroundColor(Color.parseColor(player4Color))
                player4Area.visibility = INVISIBLE
                life4.visibility = GONE
                commanderIcon4.visibility = GONE
                optionsIcon4.visibility = GONE
                playIcon4.visibility = GONE
                white4.visibility = VISIBLE
                blue4.visibility = VISIBLE
                black4.visibility = VISIBLE
                red4.visibility = VISIBLE
                green4.visibility = VISIBLE
                storm4.visibility = VISIBLE
            }
            else {
                isManaIcon4Pressed = false
                if (currentPlayer == 4 && startButton.text != "START") {
                    manaIcon4.backgroundTintList = this.getColorStateList(R.color.player4Color)
                    player4Background.setBackgroundColor(Color.parseColor("#ffffff"))
                }
                else {
                    player4Background.setBackgroundColor(Color.parseColor("#000000"))
                }
                player4Area.visibility = VISIBLE
                life4.visibility = VISIBLE
                commanderIcon4.visibility = VISIBLE
                optionsIcon4.visibility = VISIBLE
                if (startButton.text != "START") {
                    playIcon4.visibility = VISIBLE
                }
                white4.visibility = GONE
                blue4.visibility = GONE
                black4.visibility = GONE
                red4.visibility = GONE
                green4.visibility = GONE
                storm4.visibility = GONE
            }
        }
        
        optionsIcon4.setOnClickListener {
            if (!isOptionsIcon4Pressed){
                isOptionsIcon4Pressed = true
                if (currentPlayer == 4) {
                    restart4.setTextColor(Color.parseColor("#ffffff"))
                    rewind4.setTextColor(Color.parseColor("#ffffff"))
                }
                optionsIcon4.backgroundTintList = this.getColorStateList(R.color.whiteColor)
                player4Background.setBackgroundColor(Color.parseColor(player4Color))
                player4Area.visibility = INVISIBLE
                life4.visibility = GONE
                commanderIcon4.visibility = GONE
                manaIcon4.visibility = GONE
                playIcon4.visibility = GONE
                restart4.visibility = VISIBLE
                rewind4.visibility = VISIBLE
            }
            else {
                isOptionsIcon4Pressed = false
                if (currentPlayer == 4 && startButton.text != "START") {
                    optionsIcon4.backgroundTintList = this.getColorStateList(R.color.player4Color)
                    player4Background.setBackgroundColor(Color.parseColor("#ffffff"))
                }
                else {
                    player4Background.setBackgroundColor(Color.parseColor("#000000"))
                }
                player4Area.visibility = VISIBLE
                life4.visibility = VISIBLE
                commanderIcon4.visibility = VISIBLE
                manaIcon4.visibility = VISIBLE
                if (startButton.text != "START") {
                    playIcon4.visibility = VISIBLE
                }
                restart4.visibility = GONE
                rewind4.visibility = GONE
            }
        }

        playIcon4.setOnClickListener {
            if (isPaused) {
                isPaused = false
                playIcon1.background = this.getDrawable(R.drawable.pause_icon)
                playIcon2.background = this.getDrawable(R.drawable.pause_icon)
                playIcon3.background = this.getDrawable(R.drawable.pause_icon)
                playIcon4.background = this.getDrawable(R.drawable.pause_icon)
                when (currentPlayer) {
                    1 -> {
                        player1Timer.animate().apply {
                            duration = 1000 * timer1.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                    2 -> {
                        player2Timer.animate().apply {
                            duration = 1000 * timer2.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                    3 -> {
                        player3Timer.animate().apply {
                            duration = 1000 * timer3.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                    4 -> {
                        player4Timer.animate().apply {
                            duration = 1000 * timer4.toLong()
                            scaleY(0.0f)
                        }.start()
                    }
                }
            }
            else {
                isPaused = true
                playIcon1.background = this.getDrawable(R.drawable.play_icon)
                playIcon2.background = this.getDrawable(R.drawable.play_icon)
                playIcon3.background = this.getDrawable(R.drawable.play_icon)
                playIcon4.background = this.getDrawable(R.drawable.play_icon)
                when (currentPlayer) {
                    1 -> {
                        player1Timer.clearAnimation()
                        player1Timer.animate().cancel()
                    }
                    2 -> {
                        player2Timer.clearAnimation()
                        player2Timer.animate().cancel()
                    }
                    3 -> {
                        player3Timer.clearAnimation()
                        player3Timer.animate().cancel()
                    }
                    4 -> {
                        player4Timer.clearAnimation()
                        player4Timer.animate().cancel()
                    }
                }
            }
        }

        restart1.setOnClickListener {
            recreate()
        }

        restart2.setOnClickListener {
            recreate()
        }

        restart3.setOnClickListener {
            recreate()
        }

        restart4.setOnClickListener {
            recreate()
        }

        rewind1.setOnClickListener {
            timer1 -= timerAddition
            if (timer1 <= 0) {
                timer1 = 180
            }
            player1Timer.clearAnimation()
            player1Timer.animate().cancel()
            player1Timer.animate().apply {
                duration = 1000
                scaleY(1.0f)
            }.start()
            if (currentPlayer == 1) {
                player1Timer.animate().apply {
                    duration = 1000 * timer1.toLong()
                    scaleY(0.0f)
                }.start()
            }
        }

        rewind2.setOnClickListener {
            timer2 -= timerAddition
            if (timer2 <= 0) {
                timer2 = 180
            }
            player2Timer.clearAnimation()
            player2Timer.animate().cancel()
            player2Timer.animate().apply {
                duration = 1000
                scaleY(1.0f)
            }.start()
            if (currentPlayer == 2) {
                player2Timer.animate().apply {
                    duration = 1000 * timer2.toLong()
                    scaleY(0.0f)
                }.start()
            }
        }

        rewind3.setOnClickListener {
            timer3 -= timerAddition
            if (timer3 <= 0) {
                timer3 = 180
            }
            player3Timer.clearAnimation()
            player3Timer.animate().cancel()
            player3Timer.animate().apply {
                duration = 1000
                scaleY(1.0f)
            }.start()
            if (currentPlayer == 3) {
                player3Timer.animate().apply {
                    duration = 1000 * timer3.toLong()
                    scaleY(0.0f)
                }.start()
            }
        }

        rewind4.setOnClickListener {
            timer4 -= timerAddition
            if (timer4 <= 0) {
                timer4 = 180
            }
            player4Timer.clearAnimation()
            player4Timer.animate().cancel()
            player4Timer.animate().apply {
                duration = 1000
                scaleY(1.0f)
            }.start()
            if (currentPlayer == 4) {
                player4Timer.animate().apply {
                    duration = 1000 * timer4.toLong()
                    scaleY(0.0f)
                }.start()
            }
        }

        /*
        startButton.setOnClickListener {
            
            if (startButton.text == "START"){
                startButton.text = ""
                endTurn.visibility = VISIBLE
            }
            lifeTotal1 = 40
            lifeTotal2 = 40
            lifeTotal3 = 40
            lifeTotal4 = 40
            life1.text = lifeTotal1.toString()
            life2.text = lifeTotal2.toString()
            life3.text = lifeTotal3.toString()
            life4.text = lifeTotal4.toString()
        }

         */
    }

    //Menu creation
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?){
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v == player1Area){
            contextMenuHolder = 1
        }
        else if (v == player2Area){
            contextMenuHolder = 2
        }
        else if (v == player3Area){
            contextMenuHolder = 3
        }
        else if (v == player4Area){
            contextMenuHolder = 4
        }
        else {
            return
        }
        menu?.setHeaderTitle("Choose wisely")
        menuInflater.inflate(R.menu.counter_menu, menu)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.optionItem -> {
                Toast.makeText(this, "Option 1 selected by player " + contextMenuHolder.toString(), Toast.LENGTH_SHORT).show()
                true
            }
            R.id.manaItem -> {
                Toast.makeText(this, "Option 2 selected by player " + contextMenuHolder.toString(), Toast.LENGTH_SHORT).show()
                true
            }
            R.id.damageItem -> {
                Toast.makeText(this, "Option 3 selected by player " + contextMenuHolder.toString(), Toast.LENGTH_SHORT).show()
                true
            }
            R.id.lifeItem -> {
                Toast.makeText(this, "Option 4 selected by player " + contextMenuHolder.toString(), Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    //Increase/Decrease by swiping up/down
        /*
    override fun onTouchEvent(event: MotionEvent): Boolean {

        val action: Int = MotionEventCompat.getActionMasked(event)

        return when (action) {
            MotionEvent.ACTION_DOWN -> {
                
                true
            }
            MotionEvent.ACTION_MOVE -> {
                
                true
            }
            MotionEvent.ACTION_UP -> {
                
                true
            }
            MotionEvent.ACTION_CANCEL -> {
                
                true
            }
            MotionEvent.ACTION_OUTSIDE -> {
                
                true
            }
            else -> super.onTouchEvent(event)
        }
    }
         */

    // The ‘active pointer’ is the one currently moving our object.
    /*
    private var mActivePointerId = INVALID_POINTER_ID
    var mLastTouchX: Float = 0.0f
    var mLastTouchY: Float = 0.0f
    var mPosX: Float = 0.0f
    var mPosY: Float = 0.0f

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        // Let the ScaleGestureDetector inspect all events.
        player1Area.onTouchEvent(ev)

        when (MotionEventCompat.getActionMasked(ev)) {
            MotionEvent.ACTION_DOWN -> {
                MotionEventCompat.getActionIndex(ev).also { pointerIndex ->
                    // Remember where we started (for dragging)
                    mLastTouchX = MotionEventCompat.getX(ev, pointerIndex)
                    mLastTouchY = MotionEventCompat.getY(ev, pointerIndex)
                }

                // Save the ID of this pointer (for dragging)
                mActivePointerId = MotionEventCompat.getPointerId(ev, 0)
            }

            MotionEvent.ACTION_MOVE -> {
                // Find the index of the active pointer and fetch its position
                val (x: Float, y: Float) =
                    MotionEventCompat.findPointerIndex(ev, mActivePointerId).let { pointerIndex ->
                        // Calculate the distance moved
                        MotionEventCompat.getX(ev, pointerIndex) to
                                MotionEventCompat.getY(ev, pointerIndex)
                    }

                mPosX += x - mLastTouchX
                mPosY += y - mLastTouchY

                //invalidate()

                // Remember this touch position for the next move event
                mLastTouchX = x
                mLastTouchY = y
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                mActivePointerId = INVALID_POINTER_ID
            }
            MotionEvent.ACTION_POINTER_UP -> {

                MotionEventCompat.getActionIndex(ev).also { pointerIndex ->
                    MotionEventCompat.getPointerId(ev, pointerIndex)
                        .takeIf { it == mActivePointerId }
                        ?.run {
                            // This was our active pointer going up. Choose a new
                            // active pointer and adjust accordingly.
                            val newPointerIndex = if (pointerIndex == 0) 1 else 0
                            mLastTouchX = MotionEventCompat.getX(ev, newPointerIndex)
                            mLastTouchY = MotionEventCompat.getY(ev, newPointerIndex)
                            mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex)
                            lifeTotal1++
                            life1.text = lifeTotal1.toString()
                        }
                }
            }
        }
        return true
    }
     */

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
