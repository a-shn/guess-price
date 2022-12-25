package com.example.guessprice.model

import com.example.guessprice.dto.AnsweredQuestion

class Game(private val userId: String, val questionsNumber: Int) {
    val answeredQuestions: MutableList<AnsweredQuestion> = mutableListOf()
    var currentQuestionEntity: QuestionEntity? = null

    val points: Double
        get() {
            return answeredQuestions.sumOf { it.answerResult.points }
        }

    val bonusPoints: Double
        get() {
            return answeredQuestions.sumOf { it.answerResult.bonusPoints }
        }

    val currentQuestionNumber: Int
        get() {
            return answeredQuestions.size + 1
        }
}