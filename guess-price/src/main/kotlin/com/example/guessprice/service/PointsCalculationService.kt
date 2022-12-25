package com.example.guessprice.service

import com.example.guessprice.dto.AnswerResult
import com.example.guessprice.model.QuestionEntity
import org.springframework.stereotype.Service
import kotlin.math.abs

@Service
class PointsCalculationService {
    fun calculate(questionEntity: QuestionEntity, guess: Long): AnswerResult {
        val trueCost = questionEntity.cost!!
        val averageGuess = questionEntity.guessesSum * 1.0 / questionEntity.predictions

        val relativeDifference = abs(guess - trueCost) * 1.0 / trueCost;

        val accuracy: Double = if (1 - relativeDifference < 0) {
            0.0
        } else {
            1 - relativeDifference
        }

        val relativeAverageDifference = abs(averageGuess - trueCost) * 1.0 / trueCost;

        val difficultyBonus = if (relativeAverageDifference > relativeDifference) {
            25.0 * (relativeAverageDifference - relativeDifference) / relativeAverageDifference
        } else {
            0.0
        }
        return AnswerResult(accuracy * 100, difficultyBonus)
    }
}