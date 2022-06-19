package br.com.companyname.helloworldapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity: AppCompatActivity() {

    var rightAnswer = 0
    var totalQuestions = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        if (intent.hasExtra(RIGHT_ANSWER_KEY)) {
            result_info_right_answers_value.text = (intent.extras!![RIGHT_ANSWER_KEY] ?: "0") as String?
        }
        if (intent.hasExtra(TOTAL_QUESTIONS_AMOUNT_KEY)) {
            result_info_total_value.text = (intent.extras!![TOTAL_QUESTIONS_AMOUNT_KEY] ?: "0") as String?
        }
    }

    companion object {
        const val RIGHT_ANSWER_KEY = "RIGHT_ANSWER_KEY"
        const val TOTAL_QUESTIONS_AMOUNT_KEY = "TOTAL_QUESTIONS_AMOUNT_KEY"
    }
}