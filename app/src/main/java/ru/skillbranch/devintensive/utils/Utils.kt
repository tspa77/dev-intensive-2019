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

        /* Определение словаря*/
        val dictMap = hashMapOf(
            'а' to "a",
            'б' to "b",
            'в' to "v",
            'г' to "g",
            'д' to "d",
            'е' to "e",
            'ё' to "e",
            'ж' to "zh",
            'з' to "z",
            'и' to "i",
            'й' to "i",
            'к' to "k",
            'л' to "l",
            'м' to "m",
            'н' to "n",
            'о' to "o",
            'п' to "p",
            'р' to "r",
            'с' to "s",
            'т' to "t",
            'у' to "u",
            'ф' to "f",
            'х' to "h",
            'ц' to "c",
            'ч' to "ch",
            'ш' to "sh",
            'щ' to "sh'",
            'ъ' to "",
            'ы' to "i",
            'ь' to "",
            'э' to "e",
            'ю' to "yu",
            'я' to "ya",
            ' ' to divider
        )


        var transWord = ""
        for (c in payload) {
            transWord += when (c.toLowerCase()) {
                in dictMap.keys ->
                    if (c.isLowerCase()) dictMap[c] else
                        "${dictMap[c.toLowerCase()]?.first()?.toUpperCase()}" +
                                "${dictMap[c.toLowerCase()]?.substring(1)}"
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


    fun urlRepoValidation(string: String): Boolean {
        if (string.isEmpty()) return true

        val exclude = listOf(
            "enterprise",
            "features",
            "topics",
            "collections",
            "trending",
            "events",
            "marketplace",
            "pricing",
            "nonprofit",
            "customer-stories",
            "security",
            "login",
            "join"
        )

        for (word in exclude) {
            if (string.contains(word)) return false
        }

        val regex = """(https://)?(www.)?github.com/(\w*[^/])""".toRegex()
        return regex.matches(string)
    }
}


