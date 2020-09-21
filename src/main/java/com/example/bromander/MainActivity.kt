package com.example.bromander

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    //Variables for tap gestures
    //lateinit var gestureDetector: GestureDetector
    //var doubleTapped = false
    val doubleTapTimeout = 300
    var lastClickTime = 0

    //Variables for XML elements of activity_main.xml
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
    lateinit var life1Mana: TextView
    lateinit var life2Mana: TextView
    lateinit var life3Mana: TextView
    lateinit var life4Mana: TextView
    lateinit var manaCounters1: Button
    lateinit var commanderDamage1: Button
    lateinit var manaCounters2: Button
    lateinit var commanderDamage2: Button
    lateinit var manaCounters3: Button
    lateinit var commanderDamage3: Button
    lateinit var manaCounters4: Button
    lateinit var commanderDamage4: Button
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
    lateinit var player1up2: Button
    lateinit var player1down2: Button
    lateinit var player1Counter2: TextView
    lateinit var player1up3: Button
    lateinit var player1down3: Button
    lateinit var player1Counter3: TextView
    lateinit var player1up4: Button
    lateinit var player1down4: Button
    lateinit var player1Counter4: TextView
    lateinit var player2up3: Button
    lateinit var player2down3: Button
    lateinit var player2Counter3: TextView
    lateinit var player2up4: Button
    lateinit var player2down4: Button
    lateinit var player2Counter4: TextView
    lateinit var player2up1: Button
    lateinit var player2down1: Button
    lateinit var player2Counter1: TextView
    lateinit var player3up4: Button
    lateinit var player3down4: Button
    lateinit var player3Counter4: TextView
    lateinit var player3up1: Button
    lateinit var player3down1: Button
    lateinit var player3Counter1: TextView
    lateinit var player3up2: Button
    lateinit var player3down2: Button
    lateinit var player3Counter2: TextView
    lateinit var player4up1: Button
    lateinit var player4down1: Button
    lateinit var player4Counter1: TextView
    lateinit var player4up2: Button
    lateinit var player4down2: Button
    lateinit var player4Counter2: TextView
    lateinit var player4up3: Button
    lateinit var player4down3: Button
    lateinit var player4Counter3: TextView
    lateinit var progressBar: CircleProgressBar
    lateinit var playerName1: EditText
    lateinit var playerName2: EditText
    lateinit var playerName3: EditText
    lateinit var playerName4: EditText
    lateinit var endTurn: Button
    lateinit var pause: Button
    lateinit var progressBarBackground: Button

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
    var lifeHeld: Boolean = false
    var turnStatus: Int = 0
    var additionalTime: Int = 0
    val handler = Handler()
    var player1TimeRemaining: Int = 300
    var player2TimeRemaining: Int = 300
    var player3TimeRemaining: Int = 300
    var player4TimeRemaining: Int = 300
    var playerTimer: Int = 300
    var currentPlayer: Int = 1
    val endTurnString: String = "END"
    val skipTurnString: String = "SKIP"
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

    //Variable for turn timer object
    lateinit var timeOutRemoveTimer : CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize variables for XML elements
        
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
        life1 = findViewById(R.id.life1)
        life2 = findViewById(R.id.life2)
        life3 = findViewById(R.id.life3)
        life4 = findViewById(R.id.life4)
        life1Mana = findViewById(R.id.life1Mana)
        life2Mana = findViewById(R.id.life2Mana)
        life3Mana = findViewById(R.id.life3Mana)
        life4Mana = findViewById(R.id.life4Mana)
        manaCounters1 = findViewById(R.id.manaCounters1)
        commanderDamage1 = findViewById(R.id.commanderDamage1)
        manaCounters2 = findViewById(R.id.manaCounters2)
        commanderDamage2 = findViewById(R.id.commanderDamage2)
        manaCounters3 = findViewById(R.id.manaCounters3)
        commanderDamage3 = findViewById(R.id.commanderDamage3)
        manaCounters4 = findViewById(R.id.manaCounters4)
        commanderDamage4 = findViewById(R.id.commanderDamage4)
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
        player1up2 = findViewById(R.id.player1up2)
        player1down2 = findViewById(R.id.player1down2)
        player1Counter2 = findViewById(R.id.player1Counter2)
        player1up3 = findViewById(R.id.player1up3)
        player1down3 = findViewById(R.id.player1down3)
        player1Counter3 = findViewById(R.id.player1Counter3)
        player1up4 = findViewById(R.id.player1up4)
        player1down4 = findViewById(R.id.player1down4)
        player1Counter4 = findViewById(R.id.player1Counter4)
        player2up3 = findViewById(R.id.player2up3)
        player2down3 = findViewById(R.id.player2down3)
        player2Counter3 = findViewById(R.id.player2Counter3)
        player2up4 = findViewById(R.id.player2up4)
        player2down4 = findViewById(R.id.player2down4)
        player2Counter4 = findViewById(R.id.player2Counter4)
        player2up1 = findViewById(R.id.player2up1)
        player2down1 = findViewById(R.id.player2down1)
        player2Counter1 = findViewById(R.id.player2Counter1)
        player3up4 = findViewById(R.id.player3up4)
        player3down4 = findViewById(R.id.player3down4)
        player3Counter4 = findViewById(R.id.player3Counter4)
        player3up1 = findViewById(R.id.player3up1)
        player3down1 = findViewById(R.id.player3down1)
        player3Counter1 = findViewById(R.id.player3Counter1)
        player3up2 = findViewById(R.id.player3up2)
        player3down2 = findViewById(R.id.player3down2)
        player3Counter2 = findViewById(R.id.player3Counter2)
        player4up1 = findViewById(R.id.player4up1)
        player4down1 = findViewById(R.id.player4down1)
        player4Counter1 = findViewById(R.id.player4Counter1)
        player4up2 = findViewById(R.id.player4up2)
        player4down2 = findViewById(R.id.player4down2)
        player4Counter2 = findViewById(R.id.player4Counter2)
        player4up3 = findViewById(R.id.player4up3)
        player4down3 = findViewById(R.id.player4down3)
        player4Counter3 = findViewById(R.id.player4Counter3)
        playerName1 = findViewById(R.id.playerName1)
        playerName2 = findViewById(R.id.playerName2)
        playerName3 = findViewById(R.id.playerName3)
        playerName4 = findViewById(R.id.playerName4)
        endTurn = findViewById(R.id.endTurn)
        pause = findViewById(R.id.pause)
        progressBarBackground = findViewById(R.id.progressBarBackground)
        progressBar = findViewById(R.id.progressBar)


        //No mana counters or commander damage visible on game start
        hideShiftedLifeTotals()
        hideManaCounters1()
        hideManaCounters2()
        hideManaCounters3()
        hideManaCounters4()
        hideDamageCounters1()
        hideDamageCounters2()
        hideDamageCounters3()
        hideDamageCounters4()


        //Set onClickListeners for life buttons
        hiddenPlus1.setOnClickListener {
            lifeTotal1++
            life1.text = lifeTotal1.toString()
            life1Mana.text = lifeTotal1.toString()
        }
        hiddenPlus2.setOnClickListener {
            lifeTotal2++
            life2.text = lifeTotal2.toString()
            life2Mana.text = lifeTotal2.toString()
        }
        hiddenPlus3.setOnClickListener {
            lifeTotal3++
            life3.text = lifeTotal3.toString()
            life3Mana.text = lifeTotal3.toString()
        }
        hiddenPlus4.setOnClickListener {
            lifeTotal4++
            life4.text = lifeTotal4.toString()
            life4Mana.text = lifeTotal4.toString()
        }
        hiddenMinus1.setOnClickListener {
            if (lifeTotal1 != 0) {
                lifeTotal1--
                life1.text = lifeTotal1.toString()
                life1Mana.text = lifeTotal1.toString()
            }
        }
        hiddenMinus2.setOnClickListener {
            if (lifeTotal2 != 0) {
                lifeTotal2--
                life2.text = lifeTotal2.toString()
                life2Mana.text = lifeTotal2.toString()
            }
        }
        hiddenMinus3.setOnClickListener {
            if (lifeTotal3 != 0) {
                lifeTotal3--
                life3.text = lifeTotal3.toString()
                life3Mana.text = lifeTotal3.toString()
            }
        }
        hiddenMinus4.setOnClickListener {
            if (lifeTotal4 != 0) {
                lifeTotal4--
                life4.text = lifeTotal4.toString()
                life4Mana.text = lifeTotal4.toString()
            }
        }


        //Set onClickListener for ending the turn
        //Algorithm:
        //5 minute reference
        //10 minute maximum
        //3 minute minimum
        //additionalTime = (5-timeSpent)/4
        //if (additionalTime < -60s){
        //   additionalTime = -60s
        //}
        endTurn.setOnClickListener {
            timeOutRemoveTimer.cancel()

            if (currentPlayer == 1){
                additionalTime = (300-turnStatus)/4
                if (additionalTime < -60){
                    additionalTime = -60
                }
                player1TimeRemaining += additionalTime
                if (player1TimeRemaining > 600){
                    player1TimeRemaining = 600
                }
                else if (player1TimeRemaining < 180){
                    player1TimeRemaining = 180
                }
                currentPlayer = 2
                playerTimer = player2TimeRemaining
                player1Background.setBackgroundColor(Color.parseColor("#77ff8c00"))
                player2Background.setBackgroundColor(Color.parseColor("#77f440e4"))
                endTurn.rotation = 65f
                progressBar.rotation = 270f
            }
            else if (currentPlayer == 2){
                additionalTime = (300-turnStatus)/4
                if (additionalTime < -60){
                    additionalTime = -60
                }
                player2TimeRemaining += additionalTime
                if (player2TimeRemaining > 600){
                    player2TimeRemaining = 600
                }
                else if (player2TimeRemaining < 180){
                    player2TimeRemaining = 180
                }
                currentPlayer = 3
                playerTimer = player3TimeRemaining
                player2Background.setBackgroundColor(Color.parseColor("#77ff8c00"))
                player3Background.setBackgroundColor(Color.parseColor("#77f440e4"))
                endTurn.rotation = 155f
                progressBar.rotation = 270f
            }
            else if (currentPlayer == 3){
                additionalTime = (300-turnStatus)/4
                if (additionalTime < -60){
                    additionalTime = -60
                }
                player3TimeRemaining += additionalTime
                if (player3TimeRemaining > 600){
                    player3TimeRemaining = 600
                }
                else if (player3TimeRemaining < 180){
                    player3TimeRemaining = 180
                }
                currentPlayer = 4
                playerTimer = player4TimeRemaining
                player3Background.setBackgroundColor(Color.parseColor("#77ff8c00"))
                player4Background.setBackgroundColor(Color.parseColor("#77f440e4"))
                endTurn.rotation = 245f
                progressBar.rotation = 90f
            }
            else if (currentPlayer == 4){
                additionalTime = (300-turnStatus)/4
                if (additionalTime < -60){
                    additionalTime = -60
                }
                player4TimeRemaining += additionalTime
                if (player4TimeRemaining > 600){
                    player4TimeRemaining = 600
                }
                else if (player4TimeRemaining < 180){
                    player4TimeRemaining = 180
                }
                currentPlayer = 1
                playerTimer = player1TimeRemaining
                player4Background.setBackgroundColor(Color.parseColor("#77ff8c00"))
                player1Background.setBackgroundColor(Color.parseColor("#77f440e4"))
                endTurn.rotation = 335f
                progressBar.rotation = 90f
            }

            isPaused = false
            pause.setBackgroundResource(R.drawable.ic_pause_icon_close)
            if (currentPlayer == 1 || currentPlayer == 4) {
                pause.rotation = 90f
            }
            else if (currentPlayer == 2 || currentPlayer == 3) {
                pause.rotation = 270f
            }

            additionalTime = 0
            turnStatus = 0
            progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
            progressBarBackground.text = endTurnString
            progressBarBackground.rotation = progressBar.rotation

            timeOutRemoveTimer = object : CountDownTimer((playerTimer-turnStatus)*1000L, 10) {
                override fun onFinish() {
                    progressBar.progress = 1f
                    turnStatus = playerTimer
                    endTurn.setBackgroundResource(R.drawable.ic_tap_icon_orange)
                    pause.setBackgroundResource(R.drawable.ic_play_icon_orange)
                    if (currentPlayer == 1) {
                        player1Background.setBackgroundColor(Color.parseColor("#f440e4"))
                        endTurn.rotation = 65f
                        pause.rotation = 0f
                    } else if (currentPlayer == 2) {
                        player2Background.setBackgroundColor(Color.parseColor("#f440e4"))
                        endTurn.rotation = 155f
                        pause.rotation = 90f
                    } else if (currentPlayer == 3) {
                        player3Background.setBackgroundColor(Color.parseColor("#f440e4"))
                        endTurn.rotation = 245f
                        pause.rotation = 180f
                    } else if (currentPlayer == 4) {
                        player4Background.setBackgroundColor(Color.parseColor("#f440e4"))
                        endTurn.rotation = 335f
                        pause.rotation = 270f
                    }
                }

                override fun onTick(millisUntilFinished: Long) {
                    endTurn.setBackgroundResource(R.drawable.ic_tap_icon)
                    progressBar.progress = (playerTimer*1000L - millisUntilFinished).toFloat()/(playerTimer*1000L)
                    if((playerTimer*1000L - millisUntilFinished)/1000 > turnStatus){
                        turnStatus++
                        Log.i("turnStatus = ", turnStatus.toString())
                    }
                }
            }

            timeOutRemoveTimer.start()
        }


        //Set onClickListener for the pause/play button
        pause.setOnClickListener {
            if (isPaused){
                isPaused = false

                pause.setBackgroundResource(R.drawable.ic_pause_icon_close)
                if (currentPlayer == 1 || currentPlayer == 4) {
                    pause.rotation = 90f
                }
                else if (currentPlayer == 2 || currentPlayer == 3) {
                    pause.rotation = 270f
                }

                timeOutRemoveTimer = object : CountDownTimer((playerTimer-turnStatus)*1000L, 10) {
                    override fun onFinish() {
                        progressBar.progress = 1f
                        turnStatus = playerTimer
                        endTurn.setBackgroundResource(R.drawable.ic_tap_icon_orange)
                        pause.setBackgroundResource(R.drawable.ic_play_icon_orange)
                        if (currentPlayer == 1) {
                            player1Background.setBackgroundColor(Color.parseColor("#f440e4"))
                            endTurn.rotation = 65f
                            pause.rotation = 0f
                        } else if (currentPlayer == 2) {
                            player2Background.setBackgroundColor(Color.parseColor("#f440e4"))
                            endTurn.rotation = 155f
                            pause.rotation = 90f
                        } else if (currentPlayer == 3) {
                            player3Background.setBackgroundColor(Color.parseColor("#f440e4"))
                            endTurn.rotation = 245f
                            pause.rotation = 180f
                        } else if (currentPlayer == 4) {
                            player4Background.setBackgroundColor(Color.parseColor("#f440e4"))
                            endTurn.rotation = 335f
                            pause.rotation = 270f
                        }
                    }

                    override fun onTick(millisUntilFinished: Long) {
                        endTurn.setBackgroundResource(R.drawable.ic_tap_icon)
                        pause.setBackgroundResource(R.drawable.ic_pause_icon_close)
                        if (turnStatus == 0){
                            pause.rotation = 90f
                        }
                        progressBar.progress = (playerTimer*1000L - millisUntilFinished).toFloat()/(playerTimer*1000L)
                        if((playerTimer*1000L - millisUntilFinished)/1000 > turnStatus){
                            turnStatus++
                            Log.i("turnStatus = ", turnStatus.toString())
                        }
                    }
                }

                    timeOutRemoveTimer.start()
            }
            else{
                isPaused = true

                pause.setBackgroundResource(R.drawable.ic_play_icon)

                timeOutRemoveTimer.cancel()
            }
        }


        //Set onClickListeners to display mana counters
        manaCounters1.setOnClickListener {
            if (displayDamageCounters1){
                hideDamageCounters1()
                commanderDamage1.setBackgroundColor(Color.parseColor("#ffffff"))
                commanderDamage1.setTextColor(Color.parseColor("#000000"))
            }
            if (displayManaCounters1){
                displayManaCounters1 = false
                manaCounters1.setBackgroundColor(Color.parseColor("#ffffff"))
                manaCounters1.setTextColor(Color.parseColor("#000000"))
                hideManaCounters1()
                life1.visibility = View.VISIBLE
                life1Mana.visibility = View.INVISIBLE
            }
            else{
                displayManaCounters1 = true
                manaCounters1.setBackgroundColor(Color.parseColor("#ff8c00"))
                manaCounters1.setTextColor(Color.parseColor("#f440e4"))
                showManaCounters1()
                life1.visibility = View.INVISIBLE
                life1Mana.visibility = View.VISIBLE
            }
        }
        manaCounters2.setOnClickListener {
            if (displayDamageCounters2){
                hideDamageCounters2()
                commanderDamage2.setBackgroundColor(Color.parseColor("#ffffff"))
                commanderDamage2.setTextColor(Color.parseColor("#000000"))
            }
            if (displayManaCounters2){
                displayManaCounters2 = false
                manaCounters2.setBackgroundColor(Color.parseColor("#ffffff"))
                manaCounters2.setTextColor(Color.parseColor("#000000"))
                hideManaCounters2()
                life2.visibility = View.VISIBLE
                life2Mana.visibility = View.INVISIBLE
            }
            else{
                displayManaCounters2 = true
                manaCounters2.setBackgroundColor(Color.parseColor("#ff8c00"))
                manaCounters2.setTextColor(Color.parseColor("#f440e4"))
                showManaCounters2()
                life2.visibility = View.INVISIBLE
                life2Mana.visibility = View.VISIBLE
            }
        }
        manaCounters3.setOnClickListener {
            if (displayDamageCounters3){
                hideDamageCounters3()
                commanderDamage3.setBackgroundColor(Color.parseColor("#ffffff"))
                commanderDamage3.setTextColor(Color.parseColor("#000000"))
            }
            if (displayManaCounters3){
                displayManaCounters3 = false
                manaCounters3.setBackgroundColor(Color.parseColor("#ffffff"))
                manaCounters3.setTextColor(Color.parseColor("#000000"))
                hideManaCounters3()
                life3.visibility = View.VISIBLE
                life3Mana.visibility = View.INVISIBLE
            }
            else{
                displayManaCounters3 = true
                manaCounters3.setBackgroundColor(Color.parseColor("#ff8c00"))
                manaCounters3.setTextColor(Color.parseColor("#f440e4"))
                showManaCounters3()
                life3.visibility = View.INVISIBLE
                life3Mana.visibility = View.VISIBLE
            }
        }
        manaCounters4.setOnClickListener {
            if (displayDamageCounters4){
                hideDamageCounters4()
                commanderDamage4.setBackgroundColor(Color.parseColor("#ffffff"))
                commanderDamage4.setTextColor(Color.parseColor("#000000"))
            }
            if (displayManaCounters4){
                displayManaCounters4 = false
                manaCounters4.setBackgroundColor(Color.parseColor("#ffffff"))
                manaCounters4.setTextColor(Color.parseColor("#000000"))
                hideManaCounters4()
                life4.visibility = View.VISIBLE
                life4Mana.visibility = View.INVISIBLE
            }
            else{
                displayManaCounters4 = true
                manaCounters4.setBackgroundColor(Color.parseColor("#ff8c00"))
                manaCounters4.setTextColor(Color.parseColor("#f440e4"))
                showManaCounters4()
                life4.visibility = View.INVISIBLE
                life4Mana.visibility = View.VISIBLE
            }
        }


        //Set onClickListeners to display damage counters
        commanderDamage1.setOnClickListener {
            if (displayManaCounters1){
                hideManaCounters1()
                manaCounters1.setBackgroundColor(Color.parseColor("#ffffff"))
                manaCounters1.setTextColor(Color.parseColor("#000000"))
            }
            if (displayDamageCounters1){
                displayDamageCounters1 = false
                commanderDamage1.setBackgroundColor(Color.parseColor("#ffffff"))
                commanderDamage1.setTextColor(Color.parseColor("#000000"))
                hideDamageCounters1()
                life1.visibility = View.VISIBLE
                life1Mana.visibility = View.INVISIBLE
            }
            else{
                displayDamageCounters1 = true
                commanderDamage1.setBackgroundColor(Color.parseColor("#ff8c00"))
                commanderDamage1.setTextColor(Color.parseColor("#f440e4"))
                showDamageCounters1()
                life1.visibility = View.INVISIBLE
                life1Mana.visibility = View.VISIBLE
            }
        }
        commanderDamage2.setOnClickListener {
            if (displayManaCounters2){
                hideManaCounters2()
                manaCounters2.setBackgroundColor(Color.parseColor("#ffffff"))
                manaCounters2.setTextColor(Color.parseColor("#000000"))
            }
            if (displayDamageCounters2){
                displayDamageCounters2 = false
                commanderDamage2.setBackgroundColor(Color.parseColor("#ffffff"))
                commanderDamage2.setTextColor(Color.parseColor("#000000"))
                hideDamageCounters2()
                life2.visibility = View.VISIBLE
                life2Mana.visibility = View.INVISIBLE
            }
            else{
                displayDamageCounters2 = true
                commanderDamage2.setBackgroundColor(Color.parseColor("#ff8c00"))
                commanderDamage2.setTextColor(Color.parseColor("#f440e4"))
                showDamageCounters2()
                life2.visibility = View.INVISIBLE
                life2Mana.visibility = View.VISIBLE
            }
        }
        commanderDamage3.setOnClickListener {
            if (displayManaCounters3){
                hideManaCounters3()
                manaCounters3.setBackgroundColor(Color.parseColor("#ffffff"))
                manaCounters3.setTextColor(Color.parseColor("#000000"))
            }
            if (displayDamageCounters3){
                displayDamageCounters3 = false
                commanderDamage3.setBackgroundColor(Color.parseColor("#ffffff"))
                commanderDamage3.setTextColor(Color.parseColor("#000000"))
                hideDamageCounters3()
                life3.visibility = View.VISIBLE
                life3Mana.visibility = View.INVISIBLE
            }
            else{
                displayDamageCounters3 = true
                commanderDamage3.setBackgroundColor(Color.parseColor("#ff8c00"))
                commanderDamage3.setTextColor(Color.parseColor("#f440e4"))
                showDamageCounters3()
                life3.visibility = View.INVISIBLE
                life3Mana.visibility = View.VISIBLE
            }
        }
        commanderDamage4.setOnClickListener {
            if (displayManaCounters4){
                hideManaCounters4()
                manaCounters4.setBackgroundColor(Color.parseColor("#ffffff"))
                manaCounters4.setTextColor(Color.parseColor("#000000"))
            }
            if (displayDamageCounters4){
                displayDamageCounters4 = false
                commanderDamage4.setBackgroundColor(Color.parseColor("#ffffff"))
                commanderDamage4.setTextColor(Color.parseColor("#000000"))
                hideDamageCounters4()
                life4.visibility = View.VISIBLE
                life4Mana.visibility = View.INVISIBLE
            }
            else{
                displayDamageCounters4 = true
                commanderDamage4.setBackgroundColor(Color.parseColor("#ff8c00"))
                commanderDamage4.setTextColor(Color.parseColor("#f440e4"))
                showDamageCounters4()
                life4.visibility = View.INVISIBLE
                life4Mana.visibility = View.VISIBLE
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


        //Set onClickListeners for damage counters
        player1up2.setOnClickListener {
            if (player1Counter2Int < 0) {
                player1Counter2Int = 0
            }
            if (player1Counter2Int >= 0){
                player1Counter2Int++
                player1Counter2.text = player1Counter2Int.toString()
            }
            else {
                player1Counter2.text = ""
            }
        }
        player1down2.setOnClickListener {
            if (player1Counter2Int > 0) {
                player1Counter2Int--
            }
            if (player1Counter2Int == 0){
                player1Counter2.text = ""
            }
            else {
                player1Counter2.text = player1Counter2Int.toString()
            }
        }
        player1up3.setOnClickListener {
            if (player1Counter3Int < 0) {
                player1Counter3Int = 0
            }
            if (player1Counter3Int >= 0){
                player1Counter3Int++
                player1Counter3.text = player1Counter3Int.toString()
            }
            else {
                player1Counter3.text = ""
            }
        }
        player1down3.setOnClickListener {
            if (player1Counter3Int > 0) {
                player1Counter3Int--
            }
            if (player1Counter3Int == 0){
                player1Counter3.text = ""
            }
            else {
                player1Counter3.text = player1Counter3Int.toString()
            }
        }
        player1up4.setOnClickListener {
            if (player1Counter4Int < 0) {
                player1Counter4Int = 0
            }
            if (player1Counter4Int >= 0){
                player1Counter4Int++
                player1Counter4.text = player1Counter4Int.toString()
            }
            else {
                player1Counter4.text = ""
            }
        }
        player1down4.setOnClickListener {
            if (player1Counter4Int > 0) {
                player1Counter4Int--
            }
            if (player1Counter4Int == 0){
                player1Counter4.text = ""
            }
            else {
                player1Counter4.text = player1Counter4Int.toString()
            }
        }

        player2up3.setOnClickListener {
            if (player2Counter3Int < 0) {
                player2Counter3Int = 0
            }
            if (player2Counter3Int >= 0){
                player2Counter3Int++
                player2Counter3.text = player2Counter3Int.toString()
            }
            else {
                player2Counter3.text = ""
            }
        }
        player2down3.setOnClickListener {
            if (player2Counter3Int > 0) {
                player2Counter3Int--
            }
            if (player2Counter3Int == 0){
                player2Counter3.text = ""
            }
            else {
                player2Counter3.text = player2Counter3Int.toString()
            }
        }
        player2up4.setOnClickListener {
            if (player2Counter4Int < 0) {
                player2Counter4Int = 0
            }
            if (player2Counter4Int >= 0){
                player2Counter4Int++
                player2Counter4.text = player2Counter4Int.toString()
            }
            else {
                player2Counter4.text = ""
            }
        }
        player2down4.setOnClickListener {
            if (player2Counter4Int > 0) {
                player2Counter4Int--
            }
            if (player2Counter4Int == 0){
                player2Counter4.text = ""
            }
            else {
                player2Counter4.text = player2Counter4Int.toString()
            }
        }
        player2up1.setOnClickListener {
            if (player2Counter1Int < 0) {
                player2Counter1Int = 0
            }
            if (player2Counter1Int >= 0){
                player2Counter1Int++
                player2Counter1.text = player2Counter1Int.toString()
            }
            else {
                player2Counter1.text = ""
            }
        }
        player2down1.setOnClickListener {
            if (player2Counter1Int > 0) {
                player2Counter1Int--
            }
            if (player2Counter1Int == 0){
                player2Counter1.text = ""
            }
            else {
                player2Counter1.text = player2Counter1Int.toString()
            }
        }

        player3up4.setOnClickListener {
            if (player3Counter4Int < 0) {
                player3Counter4Int = 0
            }
            if (player3Counter4Int >= 0){
                player3Counter4Int++
                player3Counter4.text = player3Counter4Int.toString()
            }
            else {
                player3Counter4.text = ""
            }
        }
        player3down4.setOnClickListener {
            if (player3Counter4Int > 0) {
                player3Counter4Int--
            }
            if (player3Counter4Int == 0){
                player3Counter4.text = ""
            }
            else {
                player3Counter4.text = player3Counter4Int.toString()
            }
        }
        player3up1.setOnClickListener {
            if (player3Counter1Int < 0) {
                player3Counter1Int = 0
            }
            if (player3Counter1Int >= 0){
                player3Counter1Int++
                player3Counter1.text = player3Counter1Int.toString()
            }
            else {
                player3Counter1.text = ""
            }
        }
        player3down1.setOnClickListener {
            if (player3Counter1Int > 0) {
                player3Counter1Int--
            }
            if (player3Counter1Int == 0){
                player3Counter1.text = ""
            }
            else {
                player3Counter1.text = player3Counter1Int.toString()
            }
        }
        player3up2.setOnClickListener {
            if (player3Counter2Int < 0) {
                player3Counter2Int = 0
            }
            if (player3Counter2Int >= 0){
                player3Counter2Int++
                player3Counter2.text = player3Counter2Int.toString()
            }
            else {
                player3Counter2.text = ""
            }
        }
        player3down2.setOnClickListener {
            if (player3Counter2Int > 0) {
                player3Counter2Int--
            }
            if (player3Counter2Int == 0){
                player3Counter2.text = ""
            }
            else {
                player3Counter2.text = player3Counter2Int.toString()
            }
        }
        
        player4up1.setOnClickListener {
            if (player4Counter1Int < 0) {
                player4Counter1Int = 0
            }
            if (player4Counter1Int >= 0){
                player4Counter1Int++
                player4Counter1.text = player4Counter1Int.toString()
            }
            else {
                player4Counter1.text = ""
            }
        }
        player4down1.setOnClickListener {
            if (player4Counter1Int > 0) {
                player4Counter1Int--
            }
            if (player4Counter1Int == 0){
                player4Counter1.text = ""
            }
            else {
                player4Counter1.text = player4Counter1Int.toString()
            }
        }
        player4up2.setOnClickListener {
            if (player4Counter2Int < 0) {
                player4Counter2Int = 0
            }
            if (player4Counter2Int >= 0){
                player4Counter2Int++
                player4Counter2.text = player4Counter2Int.toString()
            }
            else {
                player4Counter2.text = ""
            }
        }
        player4down2.setOnClickListener {
            if (player4Counter2Int > 0) {
                player4Counter2Int--
            }
            if (player4Counter2Int == 0){
                player4Counter2.text = ""
            }
            else {
                player4Counter2.text = player4Counter2Int.toString()
            }
        }
        player4up3.setOnClickListener {
            if (player4Counter3Int < 0) {
                player4Counter3Int = 0
            }
            if (player4Counter3Int >= 0){
                player4Counter3Int++
                player4Counter3.text = player4Counter3Int.toString()
            }
            else {
                player4Counter3.text = ""
            }
        }
        player4down3.setOnClickListener {
            if (player4Counter3Int > 0) {
                player4Counter3Int--
            }
            if (player4Counter3Int == 0){
                player4Counter3.text = ""
            }
            else {
                player4Counter3.text = player4Counter3Int.toString()
            }
        }


        //Set textChangeListeners for mana counters
        white1Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#f9faf4"))
                progressBarBackground.rotation = 90f
                progressBarBackground.text = white1Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        white2Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#f9faf4"))
                progressBarBackground.rotation = 270f
                progressBarBackground.text = white2Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        white3Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#f9faf4"))
                progressBarBackground.rotation = 270f
                progressBarBackground.text = white3Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        white4Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#f9faf4"))
                progressBarBackground.rotation = 90f
                progressBarBackground.text = white4Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        blue1Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#0e68ab"))
                progressBarBackground.rotation = 90f
                progressBarBackground.text = blue1Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        blue2Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#0e68ab"))
                progressBarBackground.rotation = 270f
                progressBarBackground.text = blue2Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        blue3Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#0e68ab"))
                progressBarBackground.rotation = 270f
                progressBarBackground.text = blue3Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        blue4Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#0e68ab"))
                progressBarBackground.rotation = 90f
                progressBarBackground.text = blue4Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        black1Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#150b00"))
                progressBarBackground.rotation = 90f
                progressBarBackground.text = black1Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        black2Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#150b00"))
                progressBarBackground.rotation = 270f
                progressBarBackground.text = black2Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        black3Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#150b00"))
                progressBarBackground.rotation = 270f
                progressBarBackground.text = black3Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        black4Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#150b00"))
                progressBarBackground.rotation = 90f
                progressBarBackground.text = black4Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        red1Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#d3202a"))
                progressBarBackground.rotation = 90f
                progressBarBackground.text = red1Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        red2Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#d3202a"))
                progressBarBackground.rotation = 270f
                progressBarBackground.text = red2Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        red3Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#d3202a"))
                progressBarBackground.rotation = 270f
                progressBarBackground.text = red3Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        red4Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#d3202a"))
                progressBarBackground.rotation = 90f
                progressBarBackground.text = red4Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        green1Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#00733e"))
                progressBarBackground.rotation = 90f
                progressBarBackground.text = green1Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        green2Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#00733e"))
                progressBarBackground.rotation = 270f
                progressBarBackground.text = green2Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        green3Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#00733e"))
                progressBarBackground.rotation = 270f
                progressBarBackground.text = green3Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        green4Counter.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#00733e"))
                progressBarBackground.rotation = 90f
                progressBarBackground.text = green4Counter.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })

        //Set textChangeListeners for damage counters
        player1Counter2.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#00733e"))
                progressBarBackground.rotation = 90f
                progressBarBackground.text = player1Counter2.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        player1Counter3.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#150b00"))
                progressBarBackground.rotation = 90f
                progressBarBackground.text = player1Counter3.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        player1Counter4.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#f9faf4"))
                progressBarBackground.rotation = 90f
                progressBarBackground.text = player1Counter4.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })

        player2Counter3.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#f9faf4"))
                progressBarBackground.rotation = 270f
                progressBarBackground.text = player2Counter3.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        player2Counter4.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#150b00"))
                progressBarBackground.rotation = 270f
                progressBarBackground.text = player2Counter4.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        player2Counter1.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#0e68ab"))
                progressBarBackground.rotation = 270f
                progressBarBackground.text = player2Counter1.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })

        player3Counter4.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#f9faf4"))
                progressBarBackground.rotation = 270f
                progressBarBackground.text = player3Counter4.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        player3Counter1.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#0e68ab"))
                progressBarBackground.rotation = 270f
                progressBarBackground.text = player3Counter1.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        player3Counter2.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#00733e"))
                progressBarBackground.rotation = 270f
                progressBarBackground.text = player3Counter2.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        
        player4Counter1.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#0e68ab"))
                progressBarBackground.rotation = 90f
                progressBarBackground.text = player4Counter1.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        player4Counter2.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#00733e"))
                progressBarBackground.rotation = 90f
                progressBarBackground.text = player4Counter2.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
            }
        })
        player4Counter3.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable){}
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int){}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int){
                progressBarBackground.setTextColor(Color.parseColor("#150b00"))
                progressBarBackground.rotation = 90f
                progressBarBackground.text = player4Counter3.text.toString()
                if (progressBarBackground.text == ""){
                    progressBarBackground.text = endTurnString
                    if (currentPlayer == 1 || currentPlayer == 4){
                        progressBarBackground.rotation = 90f
                    }
                    else if (currentPlayer == 2 || currentPlayer == 3){
                        progressBarBackground.rotation = 270f
                    }
                    progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
                }
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


        //Set RepeatListeners for damage counters
        player1up2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player1Counter2Int++
            player1Counter2.text = player1Counter2Int.toString()
        }))
        player1down2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player1Counter2Int--
            if (player1Counter2Int <= 0){
                player1Counter2Int = 0
                player1Counter2.text = ""
            }
            else {
                player1Counter2.text = player1Counter2Int.toString()
            }
        }))
        player1up3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player1Counter3Int++
            player1Counter3.text = player1Counter3Int.toString()
        }))
        player1down3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player1Counter3Int--
            if (player1Counter3Int <= 0){
                player1Counter3Int = 0
                player1Counter3.text = ""
            }
            else {
                player1Counter3.text = player1Counter3Int.toString()
            }
        }))
        player1up4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player1Counter4Int++
            player1Counter4.text = player1Counter4Int.toString()
        }))
        player1down4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player1Counter4Int--
            if (player1Counter4Int <= 0){
                player1Counter4Int = 0
                player1Counter4.text = ""
            }
            else {
                player1Counter4.text = player1Counter4Int.toString()
            }
        }))

        player2up3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player2Counter3Int++
            player2Counter3.text = player2Counter3Int.toString()
        }))
        player2down3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player2Counter3Int--
            if (player2Counter3Int <= 0){
                player2Counter3Int = 0
                player2Counter3.text = ""
            }
            else {
                player2Counter3.text = player2Counter3Int.toString()
            }
        }))
        player2up4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player2Counter4Int++
            player2Counter4.text = player2Counter4Int.toString()
        }))
        player2down4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player2Counter4Int--
            if (player2Counter4Int <= 0){
                player2Counter4Int = 0
                player2Counter4.text = ""
            }
            else {
                player2Counter4.text = player2Counter4Int.toString()
            }
        }))
        player2up1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player2Counter1Int++
            player2Counter1.text = player2Counter1Int.toString()
        }))
        player2down1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player2Counter1Int--
            if (player2Counter1Int <= 0){
                player2Counter1Int = 0
                player2Counter1.text = ""
            }
            else {
                player2Counter1.text = player2Counter1Int.toString()
            }
        }))

        player2up3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player2Counter3Int++
            player2Counter3.text = player2Counter3Int.toString()
        }))
        player2down3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player2Counter3Int--
            if (player2Counter3Int <= 0){
                player2Counter3Int = 0
                player2Counter3.text = ""
            }
            else {
                player2Counter3.text = player2Counter3Int.toString()
            }
        }))
        player2up4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player2Counter4Int++
            player2Counter4.text = player2Counter4Int.toString()
        }))
        player2down4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player2Counter4Int--
            if (player2Counter4Int <= 0){
                player2Counter4Int = 0
                player2Counter4.text = ""
            }
            else {
                player2Counter4.text = player2Counter4Int.toString()
            }
        }))
        player2up1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player2Counter1Int++
            player2Counter1.text = player2Counter1Int.toString()
        }))
        player2down1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player2Counter1Int--
            if (player2Counter1Int <= 0){
                player2Counter1Int = 0
                player2Counter1.text = ""
            }
            else {
                player2Counter1.text = player2Counter1Int.toString()
            }
        }))

        player3up4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player3Counter4Int++
            player3Counter4.text = player3Counter4Int.toString()
        }))
        player3down4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player3Counter4Int--
            if (player3Counter4Int <= 0){
                player3Counter4Int = 0
                player3Counter4.text = ""
            }
            else {
                player3Counter4.text = player3Counter4Int.toString()
            }
        }))
        player3up1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player3Counter1Int++
            player3Counter1.text = player3Counter1Int.toString()
        }))
        player3down1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player3Counter1Int--
            if (player3Counter1Int <= 0){
                player3Counter1Int = 0
                player3Counter1.text = ""
            }
            else {
                player3Counter1.text = player3Counter1Int.toString()
            }
        }))
        player3up2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player3Counter2Int++
            player3Counter2.text = player3Counter2Int.toString()
        }))
        player3down2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player3Counter2Int--
            if (player3Counter2Int <= 0){
                player3Counter2Int = 0
                player3Counter2.text = ""
            }
            else {
                player3Counter2.text = player3Counter2Int.toString()
            }
        }))

        player4up1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player4Counter1Int++
            player4Counter1.text = player4Counter1Int.toString()
        }))
        player4down1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player4Counter1Int--
            if (player4Counter1Int <= 0){
                player4Counter1Int = 0
                player4Counter1.text = ""
            }
            else {
                player4Counter1.text = player4Counter1Int.toString()
            }
        }))
        player4up2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player4Counter2Int++
            player4Counter2.text = player4Counter2Int.toString()
        }))
        player4down2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player4Counter2Int--
            if (player4Counter2Int <= 0){
                player4Counter2Int = 0
                player4Counter2.text = ""
            }
            else {
                player4Counter2.text = player4Counter2Int.toString()
            }
        }))
        player4up3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player4Counter3Int++
            player4Counter3.text = player4Counter3Int.toString()
        }))
        player4down3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            player4Counter3Int--
            if (player4Counter3Int <= 0){
                player4Counter3Int = 0
                player4Counter3.text = ""
            }
            else {
                player4Counter3.text = player4Counter3Int.toString()
            }
        }))

        
        //Set RepeatListeners for life counter increases
        hiddenMinus1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            if (lifeTotal1 > 0){
                lifeTotal1--
            }
            life1.text = lifeTotal1.toString()
            life1Mana.text = lifeTotal1.toString()
        }))
        hiddenPlus1.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            lifeTotal1++
            life1.text = lifeTotal1.toString()
            life1Mana.text = lifeTotal1.toString()
        }))

        hiddenMinus2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            if (lifeTotal2 > 0){
                lifeTotal2--
            }
            life2.text = lifeTotal2.toString()
            life2Mana.text = lifeTotal2.toString()
        }))
        hiddenPlus2.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            lifeTotal2++
            life2.text = lifeTotal2.toString()
            life2Mana.text = lifeTotal2.toString()
        }))

        hiddenMinus3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            if (lifeTotal3 > 0){
                lifeTotal3--
            }
            life3.text = lifeTotal3.toString()
            life3Mana.text = lifeTotal3.toString()
        }))
        hiddenPlus3.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            lifeTotal3++
            life3.text = lifeTotal3.toString()
            life3Mana.text = lifeTotal3.toString()
        }))

        hiddenMinus4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            if (lifeTotal4 > 0){
                lifeTotal4--
            }
            life4.text = lifeTotal4.toString()
            life4Mana.text = lifeTotal4.toString()
        }))
        hiddenPlus4.setOnTouchListener(RepeatListener(600, 125, lifeHeld, View.OnClickListener {
            lifeTotal4++
            life4.text = lifeTotal4.toString()
            life4Mana.text = lifeTotal4.toString()
        }))


        //Set center button to say End
        progressBarBackground.text = endTurnString
        progressBarBackground.setTextColor(Color.parseColor("#ffffff"))
    }

    //Functions to hide and show different layout views
    fun hideLifeTotals(){
        life1.visibility = View.INVISIBLE
        life2.visibility = View.INVISIBLE
        life3.visibility = View.INVISIBLE
        life4.visibility = View.INVISIBLE
    }
    fun hideShiftedLifeTotals(){
        displayShiftedLifeTotal1 = false
        displayShiftedLifeTotal2 = false
        displayShiftedLifeTotal3 = false
        displayShiftedLifeTotal4 = false
        life1Mana.visibility = View.INVISIBLE
        life2Mana.visibility = View.INVISIBLE
        life3Mana.visibility = View.INVISIBLE
        life4Mana.visibility = View.INVISIBLE
    }
    fun hideManaCounters1() {
        displayManaCounters1 = false
        white1.visibility = View.INVISIBLE
        white1down.visibility = View.INVISIBLE
        blue1.visibility = View.INVISIBLE
        blue1down.visibility = View.INVISIBLE
        black1.visibility = View.INVISIBLE
        black1down.visibility = View.INVISIBLE
        red1.visibility = View.INVISIBLE
        red1down.visibility = View.INVISIBLE
        green1.visibility = View.INVISIBLE
        green1down.visibility = View.INVISIBLE
        white1Counter.visibility = View.INVISIBLE
        blue1Counter.visibility = View.INVISIBLE
        black1Counter.visibility = View.INVISIBLE
        red1Counter.visibility = View.INVISIBLE
        green1Counter.visibility = View.INVISIBLE
    }
    fun hideManaCounters2() {
        displayManaCounters2 = false
        white2.visibility = View.INVISIBLE
        white2down.visibility = View.INVISIBLE
        blue2.visibility = View.INVISIBLE
        blue2down.visibility = View.INVISIBLE
        black2.visibility = View.INVISIBLE
        black2down.visibility = View.INVISIBLE
        red2.visibility = View.INVISIBLE
        red2down.visibility = View.INVISIBLE
        green2.visibility = View.INVISIBLE
        green2down.visibility = View.INVISIBLE
        white2Counter.visibility = View.INVISIBLE
        blue2Counter.visibility = View.INVISIBLE
        black2Counter.visibility = View.INVISIBLE
        red2Counter.visibility = View.INVISIBLE
        green2Counter.visibility = View.INVISIBLE
    }
    fun hideManaCounters3() {
        displayManaCounters3 = false
        white3.visibility = View.INVISIBLE
        white3down.visibility = View.INVISIBLE
        blue3.visibility = View.INVISIBLE
        blue3down.visibility = View.INVISIBLE
        black3.visibility = View.INVISIBLE
        black3down.visibility = View.INVISIBLE
        red3.visibility = View.INVISIBLE
        red3down.visibility = View.INVISIBLE
        green3.visibility = View.INVISIBLE
        green3down.visibility = View.INVISIBLE
        white3Counter.visibility = View.INVISIBLE
        blue3Counter.visibility = View.INVISIBLE
        black3Counter.visibility = View.INVISIBLE
        red3Counter.visibility = View.INVISIBLE
        green3Counter.visibility = View.INVISIBLE
    }
    fun hideManaCounters4() {
        displayManaCounters4 = false
        white4.visibility = View.INVISIBLE
        white4down.visibility = View.INVISIBLE
        blue4.visibility = View.INVISIBLE
        blue4down.visibility = View.INVISIBLE
        black4.visibility = View.INVISIBLE
        black4down.visibility = View.INVISIBLE
        red4.visibility = View.INVISIBLE
        red4down.visibility = View.INVISIBLE
        green4.visibility = View.INVISIBLE
        green4down.visibility = View.INVISIBLE
        white4Counter.visibility = View.INVISIBLE
        blue4Counter.visibility = View.INVISIBLE
        black4Counter.visibility = View.INVISIBLE
        red4Counter.visibility = View.INVISIBLE
        green4Counter.visibility = View.INVISIBLE
    }
    fun hideDamageCounters1() {
        displayDamageCounters1 = false
        player1up2.visibility = View.INVISIBLE
        player1down2.visibility = View.INVISIBLE
        player1Counter2.visibility = View.INVISIBLE
        player1up3.visibility = View.INVISIBLE
        player1down3.visibility = View.INVISIBLE
        player1Counter3.visibility = View.INVISIBLE
        player1up4.visibility = View.INVISIBLE
        player1down4.visibility = View.INVISIBLE
        player1Counter4.visibility = View.INVISIBLE
    }
    fun hideDamageCounters2() {
        displayDamageCounters2 = false
        player2up3.visibility = View.INVISIBLE
        player2down3.visibility = View.INVISIBLE
        player2Counter3.visibility = View.INVISIBLE
        player2up4.visibility = View.INVISIBLE
        player2down4.visibility = View.INVISIBLE
        player2Counter4.visibility = View.INVISIBLE
        player2up1.visibility = View.INVISIBLE
        player2down1.visibility = View.INVISIBLE
        player2Counter1.visibility = View.INVISIBLE
    }
    fun hideDamageCounters3() {
        displayDamageCounters3 = false
        player3up4.visibility = View.INVISIBLE
        player3down4.visibility = View.INVISIBLE
        player3Counter4.visibility = View.INVISIBLE
        player3up1.visibility = View.INVISIBLE
        player3down1.visibility = View.INVISIBLE
        player3Counter1.visibility = View.INVISIBLE
        player3up2.visibility = View.INVISIBLE
        player3down2.visibility = View.INVISIBLE
        player3Counter2.visibility = View.INVISIBLE
    }
    fun hideDamageCounters4() {
        displayDamageCounters4 = false
        player4up1.visibility = View.INVISIBLE
        player4down1.visibility = View.INVISIBLE
        player4Counter1.visibility = View.INVISIBLE
        player4up2.visibility = View.INVISIBLE
        player4down2.visibility = View.INVISIBLE
        player4Counter2.visibility = View.INVISIBLE
        player4up3.visibility = View.INVISIBLE
        player4down3.visibility = View.INVISIBLE
        player4Counter3.visibility = View.INVISIBLE
    }
    fun showLifeTotals(){
        life1.visibility = View.VISIBLE
        life2.visibility = View.VISIBLE
        life3.visibility = View.VISIBLE
        life4.visibility = View.VISIBLE
    }
    fun showShiftedLifeTotals(){
        displayShiftedLifeTotal1 = true
        displayShiftedLifeTotal2 = true
        displayShiftedLifeTotal3 = true
        displayShiftedLifeTotal4 = true
        life1Mana.visibility = View.VISIBLE
        life2Mana.visibility = View.VISIBLE
        life3Mana.visibility = View.VISIBLE
        life4Mana.visibility = View.VISIBLE
    }
    fun showManaCounters1() {
        displayManaCounters1 = true
        white1.visibility = View.VISIBLE
        white1down.visibility = View.VISIBLE
        blue1.visibility = View.VISIBLE
        blue1down.visibility = View.VISIBLE
        black1.visibility = View.VISIBLE
        black1down.visibility = View.VISIBLE
        red1.visibility = View.VISIBLE
        red1down.visibility = View.VISIBLE
        green1.visibility = View.VISIBLE
        green1down.visibility = View.VISIBLE
        white1Counter.visibility = View.VISIBLE
        blue1Counter.visibility = View.VISIBLE
        black1Counter.visibility = View.VISIBLE
        red1Counter.visibility = View.VISIBLE
        green1Counter.visibility = View.VISIBLE
    }
    fun showManaCounters2() {
        displayManaCounters2 = true
        white2.visibility = View.VISIBLE
        white2down.visibility = View.VISIBLE
        blue2.visibility = View.VISIBLE
        blue2down.visibility = View.VISIBLE
        black2.visibility = View.VISIBLE
        black2down.visibility = View.VISIBLE
        red2.visibility = View.VISIBLE
        red2down.visibility = View.VISIBLE
        green2.visibility = View.VISIBLE
        green2down.visibility = View.VISIBLE
        white2Counter.visibility = View.VISIBLE
        blue2Counter.visibility = View.VISIBLE
        black2Counter.visibility = View.VISIBLE
        red2Counter.visibility = View.VISIBLE
        green2Counter.visibility = View.VISIBLE
    }
    fun showManaCounters3() {
        displayManaCounters3 = true
        white3.visibility = View.VISIBLE
        white3down.visibility = View.VISIBLE
        blue3.visibility = View.VISIBLE
        blue3down.visibility = View.VISIBLE
        black3.visibility = View.VISIBLE
        black3down.visibility = View.VISIBLE
        red3.visibility = View.VISIBLE
        red3down.visibility = View.VISIBLE
        green3.visibility = View.VISIBLE
        green3down.visibility = View.VISIBLE
        white3Counter.visibility = View.VISIBLE
        blue3Counter.visibility = View.VISIBLE
        black3Counter.visibility = View.VISIBLE
        red3Counter.visibility = View.VISIBLE
        green3Counter.visibility = View.VISIBLE
    }
    fun showManaCounters4() {
        displayManaCounters4 = true
        white4.visibility = View.VISIBLE
        white4down.visibility = View.VISIBLE
        blue4.visibility = View.VISIBLE
        blue4down.visibility = View.VISIBLE
        black4.visibility = View.VISIBLE
        black4down.visibility = View.VISIBLE
        red4.visibility = View.VISIBLE
        red4down.visibility = View.VISIBLE
        green4.visibility = View.VISIBLE
        green4down.visibility = View.VISIBLE
        white4Counter.visibility = View.VISIBLE
        blue4Counter.visibility = View.VISIBLE
        black4Counter.visibility = View.VISIBLE
        red4Counter.visibility = View.VISIBLE
        green4Counter.visibility = View.VISIBLE
    }
    fun showDamageCounters1() {
        displayDamageCounters1 = true
        player1up2.visibility = View.VISIBLE
        player1down2.visibility = View.VISIBLE
        player1Counter2.visibility = View.VISIBLE
        player1up3.visibility = View.VISIBLE
        player1down3.visibility = View.VISIBLE
        player1Counter3.visibility = View.VISIBLE
        player1up4.visibility = View.VISIBLE
        player1down4.visibility = View.VISIBLE
        player1Counter4.visibility = View.VISIBLE
    }
    fun showDamageCounters2() {
        displayDamageCounters2 = true
        player2up3.visibility = View.VISIBLE
        player2down3.visibility = View.VISIBLE
        player2Counter3.visibility = View.VISIBLE
        player2up4.visibility = View.VISIBLE
        player2down4.visibility = View.VISIBLE
        player2Counter4.visibility = View.VISIBLE
        player2up1.visibility = View.VISIBLE
        player2down1.visibility = View.VISIBLE
        player2Counter1.visibility = View.VISIBLE
    }
    fun showDamageCounters3() {
        displayDamageCounters3 = true
        player3up4.visibility = View.VISIBLE
        player3down4.visibility = View.VISIBLE
        player3Counter4.visibility = View.VISIBLE
        player3up1.visibility = View.VISIBLE
        player3down1.visibility = View.VISIBLE
        player3Counter1.visibility = View.VISIBLE
        player3up2.visibility = View.VISIBLE
        player3down2.visibility = View.VISIBLE
        player3Counter2.visibility = View.VISIBLE
    }
    fun showDamageCounters4() {
        displayDamageCounters4 = true
        player4up1.visibility = View.VISIBLE
        player4down1.visibility = View.VISIBLE
        player4Counter1.visibility = View.VISIBLE
        player4up2.visibility = View.VISIBLE
        player4down2.visibility = View.VISIBLE
        player4Counter2.visibility = View.VISIBLE
        player4up3.visibility = View.VISIBLE
        player4down3.visibility = View.VISIBLE
        player4Counter3.visibility = View.VISIBLE
    }
}
