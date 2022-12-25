package com.example.guessprice.repository

import com.example.guessprice.model.QuestionEntity
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
class QuestionsRepository {

    private val questionsById = hashMapOf<Long, QuestionEntity>(
        0L to QuestionEntity().apply {
            this.id = 0L
            cost = 100
            imgSource = "http://thumbs.dreamstime.com/z/100-%D0%B4%D0%BE%D0%BB%D0%BB%D0%B0%D1%80%D0%BE%D0%B2-4787169.jpg"
            description = "100$ dollar bill"
            predictions = 1
            guessesSum = 100
        },
        1L to QuestionEntity().apply {
            this.id = 1L
            cost = 146
            imgSource = "https://m.media-amazon.com/images/I/7120GgUKj3L.__AC_SY445_SX342_QL70_FMwebp_.jpg"
            description = "Apple AirPods (2nd Generation)"
            predictions = 1
            guessesSum = 120
        },
        2L to QuestionEntity().apply {
            this.id = 2L
            cost = 40
            imgSource = "https://m.media-amazon.com/images/I/713c7c3UWrL._SX466_.jpg"
            description = "Philips Sonicare 4100 Power Toothbrush"
            predictions = 1
            guessesSum = 50
        },
        3L to QuestionEntity().apply {
            this.id = 3L
            cost = 325
            imgSource = "https://m.media-amazon.com/images/I/81tRd24e98L._AC_SX679_.jpg"
            description = "X Rocker 5152301 Trident Pedestal 4.1 Wireless"
            predictions = 1
            guessesSum = 500
        },
        4L to QuestionEntity().apply {
            this.id = 4L
            cost = 249
            imgSource = "https://m.media-amazon.com/images/I/51JbsHSktkL._AC_SX466_.jpg"
            description = "Bose QuietComfort 45 Bluetooth Wireless Noise Cancelling Headphones"
            predictions = 1
            guessesSum = 100
        },
        5L to QuestionEntity().apply {
            this.id = 5L
            cost = 144
            imgSource = "https://m.media-amazon.com/images/I/51Brl+iYtvL._AC_SX300_SY300_.jpg"
            description = "SAMSUNG 970 EVO Plus SSD 2TB NVMe M.2 Internal Solid State Drive w/ V-NAND Technology"
            predictions = 1
            guessesSum = 200
        },
        6L to QuestionEntity().apply {
            this.id = 6L
            cost = 110
            imgSource = "https://m.media-amazon.com/images/I/61dZnPy6AYL._AC_SX679_.jpg"
            description = "Kindle Paperwhite Signature Edition (32 GB)"
            predictions = 1
            guessesSum = 80
        },
        7L to QuestionEntity().apply {
            this.id = 7L
            cost = 265
            imgSource = "https://m.media-amazon.com/images/I/61O7HHu181L._AC_SX679_.jpg"
            description = "Logitech G920 Driving Force Racing Wheel and Floor Pedals, Real Force Feedback, Stainless Steel Paddle Shifters"
            predictions = 1
            guessesSum = 70
        },
        8L to QuestionEntity().apply {
            this.id = 8L
            cost = 49
            imgSource = "https://m.media-amazon.com/images/I/61mpMH5TzkL._AC_SX679_.jpg"
            description = "Logitech G502 HERO High Performance Wired Gaming Mouse, HERO 25K Sensor, 25,600 DPI, RGB"
            predictions = 100
            guessesSum = 70
        },
        9L to QuestionEntity().apply {
            this.id = 9L
            cost = 28
            imgSource = "https://m.media-amazon.com/images/I/51ja6ds+pML._AC_SX679_.jpg"
            description = "Amazfit Band 5 Activity Fitness Tracker with Alexa Built-in"
            predictions = 1
            guessesSum = 25
        },
        10L to QuestionEntity().apply {
            this.id = 10L
            cost = 17
            imgSource = "https://m.media-amazon.com/images/I/71jKDgN926L._AC_SX679_.jpg"
            description = "Amazon Basics 1/2-Inch Extra Thick Exercise Yoga Mat"
            predictions = 1
            guessesSum = 20
        },
        11L to QuestionEntity().apply {
            this.id = 11L
            cost = 25
            imgSource = "https://m.media-amazon.com/images/I/61pP5gObVXL._SX466_.jpg"
            description = "CeraVe Moisturizing Cream"
            predictions = 1
            guessesSum = 10
        },
        12L to QuestionEntity().apply {
            this.id = 12L
            cost = 85
            imgSource = "https://m.media-amazon.com/images/I/21SPDoiRuGL._AC_SX522_.jpg"
            description = "Apple Pencil (2nd Generation)"
            predictions = 1
            guessesSum = 82
        },
        13L to QuestionEntity().apply {
            this.id = 13L
            cost = 469
            imgSource = "https://m.media-amazon.com/images/I/71ey-9D8yDL._AC_SX522_.jpg"
            description = "2021 Apple iPad Mini (Wi-Fi, 64GB)"
            predictions = 1
            guessesSum = 450
        },
        14L to QuestionEntity().apply {
            this.id = 14L
            cost = 409
            imgSource = "https://m.media-amazon.com/images/I/61QGMX0Qy6L._AC_SX466_.jpg"
            description = "Lenovo 2022 Newest Ideapad 3 Laptop, 15.6\" HD Touchscreen, 11th Gen Intel Core i3-1115G4 Processor, 8GB DDR4 RAM, 256GB PCIe NVMe SSD"
            predictions = 1
            guessesSum = 350
        }
        )

    fun findById(id: Long): Optional<QuestionEntity> {
        return Optional.of(questionsById[id]!!)
    }

    fun count(): Long {
        return 15L
    }

    fun save(q: QuestionEntity) {

    }
}