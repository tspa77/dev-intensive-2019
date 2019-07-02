package ru.skillbranch.devintensive.utils

import java.io.File


object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {

        return if (fullName.isNullOrBlank()) null to null else {
            val parts: List<String>? = fullName?.replace("\\s+".toRegex(), " ").trim().split(" ")
            // Убирает пробелы с краёв и сдвоенные, т.к. двойной пробел между в середине не даёт ожидаемого результата
            val firstName = parts?.getOrNull(0)
            val lastName = parts?.getOrNull(1)
            firstName to lastName
        }
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val fileName = System.getProperty("user.dir") + "\\src\\main\\res\\raw\\transliteration.txt"
        val transMap = getTranslitMap(readFileAsLinesUsingReadLines(fileName))

        var transWord = ""
        for (c in payload) {
            transWord += when (c.toLowerCase()) {
                in transMap.keys ->
                    if (c.isLowerCase()) transMap[c] else
                        "${transMap[c.toLowerCase()]?.first()?.toUpperCase()}" +
                                "${transMap[c.toLowerCase()]?.substring(1)}"
                ' ' -> divider
                else -> c
            }
        }
        return transWord
    }




    fun toInitials(firstName: String?, lastName: String?): String? {
        val initials = (getFirstUpperCaseLetter(firstName).plus(getFirstUpperCaseLetter(lastName)))
        return when {
            initials.isBlank() -> null
            else -> initials
        }
    }

    fun getFirstUpperCaseLetter(word: String?) =
        if (word.isNullOrBlank()) "" else word.trim().first().toUpperCase().toString()


    fun readFileAsLinesUsingReadLines(fileName: String): List<String> = File(fileName).readLines()


    fun getTranslitMap(list: List<String>): Map<Char, String> {
        val myMap = mutableMapOf<Char, String>()
        for (s in list) {
            if (!s.isBlank()) {
                val (key, value) = s.replace("\"", "").split(": ")
                myMap[key.single()] = value.dropLast(1)
            }
        }
        return myMap.toMap()
    }
}


