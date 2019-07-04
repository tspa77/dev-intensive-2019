package ru.skillbranch.devintensive.extensions

fun String.truncate(length: Int = 16): String {
    var stroka = this.trim()
    if (stroka.length > length) stroka = "${stroka.substring(0, length).trimEnd()}..."
    return stroka
}