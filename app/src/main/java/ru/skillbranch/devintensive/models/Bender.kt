package ru.skillbranch.devintensive.models

class Bender(
    var status: Status = Status.NORMAL,
    var question: Question = Question.NAME
) {

    fun askQuestion(): String = when (question) {
        Question.NAME -> Question.NAME.question
        Question.PROFESSION -> Question.PROFESSION.question
        Question.MATERIAL -> Question.MATERIAL.question
        Question.BDAY -> Question.BDAY.question
        Question.SERIAL -> Question.SERIAL.question
        Question.IDLE -> Question.IDLE.question
    }


    fun listenAnswer(answer: String): Pair<String, Triple<Int, Int, Int>> {

        return if (question.answers.contains(answer)) {
            question = question.nextQuesition()
            "Отлично - это правильный ответ\n${question.question}" to status.color
        } else {
            status = status.nextStatus()
            "Это не правильный ответ\n${question.question}" to status.color
        }

    }

    enum class Status(val color: Triple<Int, Int, Int>) {
        NORMAL(Triple(255, 255, 255)),
        WARNING(Triple(255, 120, 0)),
        DANGER(Triple(255, 60, 60)),
        CRITICAL(Triple(255, 255, 0));

        fun nextStatus(): Status {
            return if (this.ordinal < values().lastIndex) {
                values()[this.ordinal + 1]
            } else {
                values()[0]
            }
        }
    }

    enum class Question(val question: String, val answers: List<String>) {
        NAME("Как меня зовут?", listOf("бендер", "bender")) {
            override fun nextQuesition(): Question = PROFESSION
        },
        PROFESSION("Назови мою профессию", listOf("сгибальщик", "bender")) {
            override fun nextQuesition(): Question = MATERIAL
        },
        MATERIAL("Из чего я сделан?", listOf("металл", "metal", "iron")) {
            override fun nextQuesition(): Question = BDAY
        },
        BDAY("Когда меня создали?", listOf("2993")) {
            override fun nextQuesition(): Question = SERIAL
        },
        SERIAL("Мой серийный номер?", listOf("2716057")) {
            override fun nextQuesition(): Question = IDLE
        },
        IDLE("На этом всё, вопросов больше нет", listOf()) {
            override fun nextQuesition(): Question = PROFESSION
        };

        abstract fun nextQuesition(): Question
    }
}