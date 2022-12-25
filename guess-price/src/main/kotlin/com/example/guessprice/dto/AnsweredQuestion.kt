package com.example.guessprice.dto

import com.example.guessprice.model.QuestionEntity

class AnsweredQuestion(val questionEntity: QuestionEntity,
                       val answerResult: AnswerResult)