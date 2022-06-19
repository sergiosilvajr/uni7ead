package br.com.companyname.helloworldapplication.model

data class Quiz(
    val question: String,
    val answer1: Answer,
    val answer2: Answer,
    val answer3: Answer,
    val answer4: Answer,
)