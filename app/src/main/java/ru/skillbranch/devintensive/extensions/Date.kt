package ru.skillbranch.devintensive.extensions

import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.util.*


const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR



fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {
    var difference = (date.time - this.time) / SECOND * SECOND
    var prefix = ""
    var postfix = ""
    if (difference > 0) postfix = " назад" else prefix = "через "
    difference = abs(difference)

    val answer = when (difference) {
        in 0..1 * SECOND -> "только что"
        in 2 * SECOND..45 * SECOND -> "${prefix}несколько секунд$postfix"
        in 46 * SECOND..75 * SECOND -> "${prefix}минуту$postfix"
        in 76 * SECOND..45 * MINUTE -> "${prefix}${difference / MINUTE} минут$postfix" //TODO
        in 46 * MINUTE..75 * MINUTE -> "${prefix}час$postfix"
        in 76 * MINUTE..22 * HOUR -> "${prefix}${difference / HOUR} часов$postfix"  //TODO
        in 23 * HOUR..26 * HOUR -> "${prefix}день$postfix"
        in 27 * HOUR..360 * DAY -> "${prefix}${difference / DAY} дней$postfix" //TODO
        else -> "xcxxccxcxc"
    }
    return answer
}



enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}

