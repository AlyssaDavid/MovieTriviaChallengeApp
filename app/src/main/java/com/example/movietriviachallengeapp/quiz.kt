package com.example.movietriviachallengeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class quiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

        class QuizActivity : AppCompatActivity() {
            private val questions = arrayOf(
                "The first feature-length animated movie was Snow White and the Seven Dwarfs.",
                "Titanic won 11 Academy Awards.",
                "The movie 'Jaws' was about a giant squid.",
                "Star Wars was released in 1977.",
                "The Oscars are held every two years."
            )

            private val answers = arrayOf(true, true, false, true, false)
            private var currentQuestionIndex = 0
            private var score = 0

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_quiz)

                updateQuestion()

                findViewById<Button>(R.id.trueButton).setOnClickListener { checkAnswer(true) }
                findViewById<Button>(R.id.falseButton).setOnClickListener { checkAnswer(false) }
                findViewById<Button>(R.id.nextButton).setOnClickListener { nextQuestion() }
            }

            private fun updateQuestion() {
                findViewById<TextView>(R.id.questionTextView).text = questions[currentQuestionIndex]
            }

            private fun checkAnswer(userAnswer: Boolean) {
                val feedbackTextView = findViewById<TextView>(R.id.feedbackTextView)
                if (userAnswer == answers[currentQuestionIndex]) {
                    feedbackTextView.text = "Correct!"
                    score++
                } else {
                    feedbackTextView.text = "Incorrect!"
                }
            }

            private fun nextQuestion() {
                currentQuestionIndex++
                if (currentQuestionIndex < questions.size) {
                    updateQuestion()
                    findViewById<TextView>(R.id.feedbackTextView).text = ""
                } else {
                    val intent = Intent(this, QuizActivity::class.java)
                    intent.putExtra("score", score)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}
