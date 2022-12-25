package com.example.guessprice.service

import com.example.guessprice.dto.AnswerResult
import com.example.guessprice.dto.AnsweredQuestion
import com.example.guessprice.dto.GameInfo
import com.example.guessprice.model.Game
import com.example.guessprice.dto.Question
import com.example.guessprice.model.QuestionEntity
import org.springframework.stereotype.Service

@Service
class GamesService(
    private val pointsCalculationService: PointsCalculationService,
    private val questionsService: QuestionsService,
) {
    private val QUESTIONS_NUMBER = 10
    private val gamesMap = mutableMapOf<String, Game>()

    fun answer(userId: String, guess: Long): GameInfo {
        val game = gamesMap[userId]!!
        val currentQuestion = game.currentQuestionEntity!!
        questionsService.handleAnswer(currentQuestion.id!!, guess)
        val result = handleAnswer(game, guess)
        val question = if (game.currentQuestionEntity == null) {
            null
        } else {
            convertToQuestionDto(game.currentQuestionEntity!!)
        }
        return GameInfo(
            answerResult = result,
            totalPoints = game.points,
            totalBonusPoints = game.bonusPoints,
            questionNumber = game.currentQuestionNumber,
            totalQuestions = QUESTIONS_NUMBER,
            question = question
        )
    }

    private fun handleAnswer(game: Game, guess: Long): AnswerResult {
        val currentQuestion = game.currentQuestionEntity!!
        val result = pointsCalculationService.calculate(currentQuestion, guess)
        game.answeredQuestions.add(AnsweredQuestion(currentQuestion, result))
        if (game.currentQuestionNumber > QUESTIONS_NUMBER) {
            game.currentQuestionEntity = null
        } else {
            game.currentQuestionEntity = getNewRandomQuestion(game)
        }
        return result
    }

    fun getQuestion(userId: String): GameInfo {
        var game = gamesMap[userId]
        if (game == null || game.currentQuestionNumber > QUESTIONS_NUMBER) {
            gamesMap[userId] = startNewGame(userId)
            game = gamesMap[userId]!!
        } else {
            game = gamesMap[userId]!!
        }
        val qDto = convertToQuestionDto(game.currentQuestionEntity!!)
        val answerResult = if (game.answeredQuestions.size == 0) {
            null
        } else {
            game.answeredQuestions.last().answerResult
        }
        return GameInfo(
            answerResult = answerResult,
            totalPoints = game.points,
            totalBonusPoints = game.bonusPoints,
            questionNumber = game.currentQuestionNumber,
            totalQuestions = QUESTIONS_NUMBER,
            question = qDto
        )
    }

    private fun getNewRandomQuestion(game: Game): QuestionEntity {
        var q = questionsService.getRandomQuestion()
        while (game.answeredQuestions.map { it.questionEntity }.any { it.id == q.id }) {
            q = questionsService.getRandomQuestion()
        }
        return q
    }

    private fun convertToQuestionDto(q: QuestionEntity): Question {
        return Question(q.id!!, q.description!!, q.imgSource!!)
    }

    private fun startNewGame(userId: String): Game {
        return Game(userId, QUESTIONS_NUMBER).also {
            it.currentQuestionEntity = questionsService.getRandomQuestion()
        }
    }
}