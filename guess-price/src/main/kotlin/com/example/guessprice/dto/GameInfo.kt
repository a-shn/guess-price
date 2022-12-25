package com.example.guessprice.dto

data class GameInfo(
    val answerResult: AnswerResult?,
    val totalPoints: Double,
    val totalBonusPoints: Double,
    val questionNumber: Int,
    val totalQuestions: Int,
    val question: Question?
)