package com.example.guessprice.controller

import com.example.guessprice.dto.AnswerResult
import com.example.guessprice.dto.GameInfo
import com.example.guessprice.dto.Question
import com.example.guessprice.service.GamesService
import jakarta.servlet.http.HttpSession
import org.springframework.web.bind.annotation.*

@CrossOrigin(
    allowCredentials = "true",
    origins = ["http://localhost:3000"]
)
@RestController
class GamesController(private val gamesService: GamesService) {

    @PostMapping("/answer")
    fun answer(@CookieValue("JSESSIONID") userId: String, @RequestBody guess: Long): GameInfo {
        return gamesService.answer(userId, guess)
    }

    @GetMapping("/get-question")
    fun getQuestion(@CookieValue("JSESSIONID") userId: String): GameInfo {
        return gamesService.getQuestion(userId)
    }
}