package ru.you11.rusilomer.model

data class Task(val name: String,
                val points: Int,
                var timesCompleted: Int = 0) {
}