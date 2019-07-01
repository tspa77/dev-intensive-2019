package ru.skillbranch.devintensive.utils

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
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return "Pavel Tsygankov"
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
}