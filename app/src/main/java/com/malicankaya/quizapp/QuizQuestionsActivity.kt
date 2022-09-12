package com.malicankaya.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var currentPosition: Int = 1
    private var questionsList: ArrayList<Question>? = null
    private var questionsListSize: Int = 0
    private var selectedOptionPosition: Int = 0
    private var correctAnswers: Int = 0
    private var userName: String? = null

    private var tvQuestion: TextView? = null
    private var ivFlag: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var tvProgressBar: TextView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null

    private var btnSubmit: Button? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        userName = intent.getStringExtra(Constants.USER_NAME)

        tvQuestion = findViewById(R.id.tvQuestion)
        ivFlag = findViewById(R.id.ivFlag)
        progressBar = findViewById(R.id.progressBar)
        tvProgressBar = findViewById(R.id.tvProgressBar)

        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)
        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)

        btnSubmit = findViewById(R.id.btnSubmit)
        btnSubmit?.setOnClickListener(this)

        questionsList = Constants.getQuestions()
        questionsListSize = questionsList?.size!!.toInt()
        progressBar?.max = questionsListSize

        setQuestion()

    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        defaultOptionsView()
        val question = questionsList!![currentPosition - 1]
        tvQuestion?.text = question.question
        ivFlag?.setImageResource(question.image)
        progressBar?.progress = currentPosition
        tvProgressBar?.text = "$currentPosition / $questionsListSize"

        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        btnSubmit?.text = "SUBMIT"

    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        selectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(it)
        }
        tvOptionTwo?.let {
            options.add(it)
        }
        tvOptionThree?.let {
            options.add(it)
        }
        tvOptionFour?.let {
            options.add(it)
        }

        for (i in options) {
            i.setTextColor(Color.parseColor("#7A8089"))
            i.typeface = Typeface.DEFAULT
            i.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun answerView(selectedAnswer: Int, drawable: Int) {

        when (selectedAnswer) {
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(this, drawable)
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(this, drawable)
            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(this, drawable)
            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(this, drawable)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvOptionOne -> {
                tvOptionOne?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.tvOptionTwo -> {
                tvOptionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tvOptionThree -> {
                tvOptionThree?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tvOptionFour -> {
                tvOptionFour?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.btnSubmit -> {
                if(selectedOptionPosition == 0){
                    currentPosition++

                    if(currentPosition <= questionsListSize){
                        setQuestion()
                    }else{
                        btnSubmit?.text = "FINISH"
                        val intent = Intent(this, ResultActivity::class.java)

                        intent.putExtra(Constants.USER_NAME, userName)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, questionsListSize)
                        intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
                        startActivity(intent)
                        finish()
                    }

                }else{
                    val question = questionsList!![currentPosition-1]

                    if(question.correctAnswer != selectedOptionPosition){
                        answerView(selectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        correctAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(currentPosition < questionsListSize)
                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    else
                        btnSubmit?.text = "FINISH"

                    selectedOptionPosition = 0
                }
            }
        }
    }
}