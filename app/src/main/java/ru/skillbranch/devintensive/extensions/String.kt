package ru.skillbranch.devintensive.extensions

fun String.truncate(length: Int = 16): String {
    var stroka = this.trim()
    if (stroka.length > length) stroka = "${stroka.substring(0, length).trimEnd()}..."
    return stroka
}

fun String.stripHtml(): String {

    var string = this.replace("\\s+".toRegex(), " ")
    string = string.replace("<[^>]*>".toRegex(), "")
    println(string)

    return string
}