package ru.skillbranch.devintensive.extensions

import java.lang.IllegalArgumentException
import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


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
    val difference = (date.time - this.time) / SECOND * SECOND
    var prefix = ""
    var postfix = ""
    if (difference > 0) postfix = " назад" else prefix = "через "

    val answer = when (val timeUnit = abs(difference)) {
        in 0..1 * SECOND -> "только что"
        in 2 * SECOND..45 * SECOND -> "${prefix}несколько секунд$postfix"
        in 46 * SECOND..75 * SECOND -> "${prefix}минуту$postfix"
        in 76 * SECOND..45 * MINUTE -> "$prefix${toDecline((timeUnit / MINUTE).toInt(), TimeUnit.MINUTES)}$postfix"
        in 46 * MINUTE..75 * MINUTE -> "${prefix}час$postfix"
        in 76 * MINUTE..22 * HOUR -> "$prefix${toDecline((timeUnit / HOUR).toInt(), TimeUnit.HOURS)}$postfix"
        in 23 * HOUR..26 * HOUR -> "${prefix}день$postfix"
        in 27 * HOUR..360 * DAY -> "$prefix${toDecline((timeUnit / DAY).toInt(), TimeUnit.DAYS)}$postfix"
        else -> if (difference > 0) "более года назад" else "более чем через год"
    }
    return answer
}

fun toDecline(number: Int, timeUnit: TimeUnit): String {
    val residue = number % 100
    return when (timeUnit) {

        TimeUnit.SECONDS -> if (residue in 10..20) "$number секунд" else
            when (residue % 10) {
                1 -> "$number секунду"
                in 2..4 -> "$number секунды"
                else -> "$number секунд"
            }
        TimeUnit.MINUTES -> if (residue in 10..20) "$number минут" else
            when (residue % 10) {
                1 -> "$number минуту"
                in 2..4 -> "$number минуты"
                else -> "$number минут"
            }
        TimeUnit.HOURS -> if (residue in 10..20) "$number часов" else
            when (residue % 10) {
                1 -> "$number час"
                in 2..4 -> "$number часа"
                else -> "$number часов"
            }
        TimeUnit.DAYS -> if (residue in 10..20) "$number дней" else
            when (residue % 10) {
                1 -> "$number день"
                in 2..4 -> "$number дня"
                else -> "$number дней"
            }
        else -> throw IllegalArgumentException()
    }
}


enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun plural(number: Int): String {
        val timeUnit = when (super.name) {
            "SECOND" -> TimeUnit.SECONDS
            "MINUTE" -> TimeUnit.MINUTES
            "HOUR" -> TimeUnit.HOURS
            "DAY" -> TimeUnit.DAYS
            else -> throw IllegalArgumentException()
        }

        return toDecline(number, timeUnit)
    }
}

