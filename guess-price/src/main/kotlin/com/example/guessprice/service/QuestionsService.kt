package com.example.guessprice.service

import com.example.guessprice.model.QuestionEntity
import com.example.guessprice.repository.QuestionsRepository
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class QuestionsService(private val questionsRepository: QuestionsRepository) {

    fun getRandomQuestion(): QuestionEntity {
        val questionId = Random.nextLong(0, questionsRepository.count())
        return questionsRepository.findById(questionId).get()
    }

    fun handleAnswer(questionId: Long, guess: Long) {
        val q = questionsRepository.findById(questionId).get()
        q.guessesSum = q.guessesSum + guess
        q.predictions = q.predictions + 1
        questionsRepository.save(q)
    }
}