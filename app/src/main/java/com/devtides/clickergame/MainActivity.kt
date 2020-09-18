package com.devtides.clickergame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var clickCounter = 0
    private var record = 0
    private var running = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onStartButtonClick(v: View) {
        if (!running) {
            startButton.isEnabled = false
            clickCounter = 0
            running = true
            counterTV.text = clickCounter.toString()
            Handler(Looper.getMainLooper()).postDelayed({
                onFinish()
            }, 3000)
        }
    }

    fun onScreenClick(v: View) {
        if (running) {
            clickCounter++
            counterTV.text = clickCounter.toString()
        }
    }

    private fun onFinish() {
        Toast.makeText(this, "Finished! You clicked $clickCounter times", Toast.LENGTH_SHORT).show()
        if (record < clickCounter) {
            record = clickCounter
            recordTV.text = record.toString()
        }
        startButton.isEnabled = true
        running = false
    }

}