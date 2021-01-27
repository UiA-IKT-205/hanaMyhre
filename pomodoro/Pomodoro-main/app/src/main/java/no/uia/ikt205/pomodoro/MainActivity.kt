package no.uia.ikt205.pomodoro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import no.uia.ikt205.pomodoro.util.millisecondsToDescriptiveTime

class MainActivity : AppCompatActivity() {

    lateinit var timer:CountDownTimer
    lateinit var startButton:Button
    lateinit var countdownDisplay:TextView

    lateinit var button30:Button
    lateinit var button60:Button
    lateinit var button90:Button
    lateinit var button120:Button

    val minutesToMs = 60 * 1000L
    var timeToCountDownInMs = 5000L
    val timeTicks = 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       startButton = findViewById<Button>(R.id.startCountdownButton)
        button30 = findViewById<Button>(R.id.minutes30)
        button60 = findViewById<Button>(R.id.minutes60)
        button90 = findViewById<Button>(R.id.minutes90)
        button120 = findViewById<Button>(R.id.minutes120)

        startButton.setOnClickListener(){
            startCountDown(it)
        }

        button30.setOnClickListener(){
            timeToCountDownInMs = 30 * minutesToMs
        }

        button60.setOnClickListener(){
            timeToCountDownInMs = 60 * minutesToMs
        }

        button90.setOnClickListener(){
            timeToCountDownInMs = 90 * minutesToMs
        }

        button120.setOnClickListener(){
            timeToCountDownInMs = 120 * minutesToMs
        }


       countdownDisplay = findViewById<TextView>(R.id.countDownView)
    }

    fun startCountDown(v: View){

        timer = object : CountDownTimer(timeToCountDownInMs,timeTicks) {
            override fun onFinish() {
                Toast.makeText(this@MainActivity,"Arbeidsøkt er ferdig", Toast.LENGTH_SHORT).show()
            }

            override fun onTick(millisUntilFinished: Long) {
               updateCountDownDisplay(millisUntilFinished)
            }
        }

        timer.start()
    }


    fun updateCountDownDisplay(timeInMs:Long){
        countdownDisplay.text = millisecondsToDescriptiveTime(timeInMs)
    }



}