package ru.skillbranch.devintensive.extensions

fun String.truncate(length: Int = 16): String {


    var stroka = this
    var rightBorder = length

    if (this.length > length) {

        println(rightBorder)
        println("знак:${this[length - 1]}:")
        if (this[length - 1] == ' ')          stroka = this.trimEnd()
        println(rightBorder)
        stroka = this.substring(0, rightBorder).plus("...")
        println(stroka)
        return stroka
    }

    return this.trimEnd()
}