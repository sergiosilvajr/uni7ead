package br.com.companyname.helloworldapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.companyname.helloworldapplication.ResultActivity.Companion.RIGHT_ANSWER_KEY
import br.com.companyname.helloworldapplication.ResultActivity.Companion.TOTAL_QUESTIONS_AMOUNT_KEY
import br.com.companyname.helloworldapplication.model.Answer
import br.com.companyname.helloworldapplication.model.Quiz
import kotlinx.android.synthetic.main.activity_first.*

class QuestionActivity : AppCompatActivity() {

    lateinit var nextQuestion: Button
    var currentQuestion = 0
    var rightQuestions = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_first)

        if (intent.hasExtra(CURRENT_QUESTION_ITEM_KEY)) {
            currentQuestion = (intent.extras!![CURRENT_QUESTION_ITEM_KEY] ?: 0) as Int
        }
        if (intent.hasExtra(CURRENT_RIGHT_QUESTION_KEY)) {
            rightQuestions = (intent.extras!![CURRENT_RIGHT_QUESTION_KEY] ?: 0) as Int
        }
        val quizList = getQuizList()

        val questionLabel = question_description_label
        val answer1Label = button_answer_1
        val answer2Label = button_answer_2
        val answer3Label = button_answer_3
        val answer4Label = button_answer_4

        nextQuestion = next_question
        val quizItem = quizList[currentQuestion]
        questionLabel.text = quizItem.question
        answer1Label.text = quizItem.answer1.description
        answer2Label.text = quizItem.answer2.description
        answer3Label.text = quizItem.answer3.description
        answer4Label.text = quizItem.answer4.description

        setAnswerToLabel(answer1Label, quizItem.answer1)
        setAnswerToLabel(answer2Label, quizItem.answer2)
        setAnswerToLabel(answer3Label, quizItem.answer3)
        setAnswerToLabel(answer4Label, quizItem.answer4)

        nextQuestion.setOnClickListener {
            val intent: Intent?
            if (this.currentQuestion >= this.getQuizList().size - 1) {
                intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(TOTAL_QUESTIONS_AMOUNT_KEY, MAX_QUESTION.toString())
                intent.putExtra(RIGHT_ANSWER_KEY, rightQuestions.toString())
            } else {
                intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra(CURRENT_QUESTION_ITEM_KEY, currentQuestion + 1)
                intent.putExtra(CURRENT_RIGHT_QUESTION_KEY, rightQuestions )
            }

            startActivity(intent)
        }
    }

    private fun setAnswerToLabel(answerLabel: TextView, answer: Answer) {
        answerLabel.setOnClickListener {
            if (answer.isCorrect) {
                rightQuestions++
                Toast.makeText(this, getString(R.string.right_answer), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, getString(R.string.wrong_answer), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getQuizList(): List<Quiz> {
        return listOf(
            Quiz(
                "Qual o planeta mais próximo do Sol?",
                Answer("Vênus", false),
                Answer("Mercúrio", true),
                Answer("Jupiter", false),
                Answer("Marte", false)
            ),
            Quiz(
                "Qual o planeta mais distante do Sol?",
                Answer("Vênus", false),
                Answer("Netuno", true),
                Answer("Jupiter", false),
                Answer("Marte", false)
            ),
            Quiz(
                "Quanto é 1+1",
                Answer("22", false),
                Answer("3", false),
                Answer("4", false),
                Answer("2", true)
            ),
            Quiz(
                "Qual o planeta mais distante do Sol?",
                Answer("Vênus", false),
                Answer("Netuno", true),
                Answer("Jupiter", false),
                Answer("Marte", false)
            ),
            Quiz(
                "Qual o planeta mais distante do Sol?",
                Answer("Vênus", false),
                Answer("Netuno", true),
                Answer("Jupiter", false),
                Answer("Marte", false)
            )
        )
    }

    companion object {
        const val MAX_QUESTION = 5
        const val CURRENT_QUESTION_ITEM_KEY = "CURRENT_QUESTION_ITEM_KEY"
        const val CURRENT_RIGHT_QUESTION_KEY = "CURRENT_RIGHT_QUESTION_KEY"

    }
}