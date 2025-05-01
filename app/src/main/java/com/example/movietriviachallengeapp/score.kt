package com.example.movietriviachallengeapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->


            val score = intent.getIntExtra("score", 0)
            val scoreTextView = findViewById<TextView>(R.id.scoreTextView)

            val feedback = when (score) {
                in 4..5 -> "🎉 You’re a movie genius!"
                in 2..3 -> "🍿 Not bad! Keep watching."
                else -> "🎬 Time to binge some classics!"
            }

            scoreTextView.text = "Your Score: $score/5\n$feedback"

            findViewById<Button>(R.id.exitButton).setOnClickListener {
            finishAffinity()
        }
    }
}
    }
