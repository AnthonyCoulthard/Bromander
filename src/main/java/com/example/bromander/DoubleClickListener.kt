package com.example.bromander

import android.R.string.cancel
import android.os.Handler
import android.view.View
import java.util.*


abstract class DoubleClickListener : View.OnClickListener {

    private var timer: Timer? = null  //at class level;
    private val delay: Long = 400

    private var lastClickTime: Long = 0

    override fun onClick(v: View) {
        val clickTime = System.currentTimeMillis()
        if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA) {
            processDoubleClickEvent(v)
        } else {
            processSingleClickEvent(v)
        }
        lastClickTime = clickTime
    }


    fun processSingleClickEvent(v: View) {

        val handler = Handler()
        val mRunnable = Runnable {
            onSingleClick(v) //Do what ever u want on single click
        }

        val timerTask = object : TimerTask() {
            override fun run() {
                handler.post(mRunnable)
            }
        }
        timer = Timer()
        timer!!.schedule(timerTask, delay)

    }

    fun processDoubleClickEvent(v: View) {
        if (timer != null) {
            timer!!.cancel() //Cancels Running Tasks or Waiting Tasks.
            timer!!.purge()  //Frees Memory by erasing cancelled Tasks.
        }
        onDoubleClick(v)//Do what ever u want on Double Click
    }

    abstract fun onSingleClick(v: View)

    abstract fun onDoubleClick(v: View)

    companion object {
        private val DOUBLE_CLICK_TIME_DELTA: Long = 400
    }
}