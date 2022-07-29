package com.github.nikokann.crickdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    companion object {
        private var COUNT_DOWN_MILLISECOND: Long = 5000
        private const val INTERVAL_MILLISECOND: Long = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.count_down_button)
        val finishedTextView = findViewById<TextView>(R.id.finished_text)
        val countTextView = findViewById<TextView>(R.id.count_label)
        val settimer_10 = findViewById<Button>(R.id.settimer_10)

        val timer = object : CountDownTimer(COUNT_DOWN_MILLISECOND, INTERVAL_MILLISECOND) {
            override fun onTick(millisUntilFinished: Long) {
                // 1秒ごとにテキストを更新
                val second = ceil(millisUntilFinished / 1000.0).toInt()
                countTextView.text = second.toString()
            }

            override fun onFinish() {
                // 各Viewの終了設定
                button.isEnabled = true
                finishedTextView.visibility = View.VISIBLE
                countTextView.text = "0"
            }
        }

        button.setOnClickListener {
            // 各Viewの初期設定
            button.isEnabled = false
            finishedTextView.visibility = View.INVISIBLE
            COUNT_DOWN_MILLISECOND = 5000
            // timerのスタート
            timer.start()
        }

        settimer_10.setOnClickListener {
            // 各Viewの初期設定
            button.isEnabled = false
            finishedTextView.visibility = View.INVISIBLE
            COUNT_DOWN_MILLISECOND = 10000
            // timerのスタート
            timer.start()
        }
    }
}