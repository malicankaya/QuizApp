package com.malicankaya.quizapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {

    var tvQuestion: TextView? = null
    var ivFlag: ImageView? = null
    var progressBar: ProgressBar? = null
    var tvProgressBar: TextView? = null

    var tvOptionOne: TextView? = null
    var tvOptionTwo: TextView? = null
    var tvOptionThree: TextView? = null
    var tvOptionFour: TextView? = null

    var btnSubmit: Button? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        tvQuestion = findViewById(R.id.tvQuestion)
        ivFlag = findViewById(R.id.ivFlag)
        progressBar = findViewById(R.id.progressBar)
        tvProgressBar = findViewById(R.id.tvProgressBar)

        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)

        btnSubmit = findViewById(R.id.btnSubmit)
        val questionsList = Constants.getQuestions()
        val questionsListSize = questionsList.size
        var currentPosition = 1

        progressBar?.max = questionsListSize


        for (i in questionsList){
            tvQuestion?.text = i.question
            ivFlag?.setImageResource(i.image)
            progressBar?.progress = currentPosition
            tvProgressBar?.text = "$currentPosition / $questionsListSize"

            tvOptionOne?.text = i.optionOne
            tvOptionTwo?.text = i.optionTwo
            tvOptionThree?.text = i.optionThree
            tvOptionFour?.text = i.optionFour
        }
    }
}