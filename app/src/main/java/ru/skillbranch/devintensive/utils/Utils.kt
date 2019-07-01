package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {

        return if (fullName.isNullOrBlank()) null to null else {
            val parts: List<String>? = fullName?.replace("\\s+".toRegex(), " ").trim().split(" ")
            // Убирает сдвоенные пробелы с краёв и сдвоенные.
            // Двойной пробел между именем и фамилией не даёт ожидаемого результата
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
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return "PT"
    }
}