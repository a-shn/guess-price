package com.example.guessprice.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class QuestionEntity {
    @Id
    @GeneratedValue
    var id: Long? = null

    var description: String? = null

    var imgSource: String? = null

    var cost: Long? = null

    var guessesSum: Long = 0

    var predictions: Long = 0
}