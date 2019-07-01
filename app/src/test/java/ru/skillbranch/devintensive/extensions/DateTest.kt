package ru.skillbranch.devintensive.extensions

import org.junit.Test
import java.time.LocalDateTime
import java.util.*


class DateTest {


    /**
     * Date.format
     * Необходимо реализовать extension для форматирования вывода даты экземпляра класса Date по заданному паттерну
     * Реализуй extension Date.format(pattern) возвращающий отформатированную дату по паттерну передаваемому в
     * качестве аргумента (значение по умолчанию "HH:mm:ss dd.MM.yy" локаль "ru")
     *
     * Пример:
     * Date().format() //14:00:00 27.06.19
     * Date().format("HH:mm") //14:00
     */

    @Test
    fun dateFormat_test(){
        println(Date().format())
        println(Date().format("HH:mm"))
    }


    /**
     * Date.add
     * Необходимо реализовать extension для изменения значения экземпляра Data (добавление/вычитание) на указанную
     * временную единицу
     * Реализуй extension Date.add(value, TimeUnits) добавляющий или вычитающий значение переданное первым
     * аргументом в единицах измерения второго аргумента (enum TimeUnits [SECOND, MINUTE, HOUR, DAY]) и возвращающий
     * модифицированный экземпляр Date
     *
     * Пример:
     * Date().add(2, TimeUnits.SECOND) //Thu Jun 27 14:00:02 GST 2019
     * Date().add(-4, TimeUnits.DAY) //Thu Jun 23 14:00:00 GST 2019
     */

    @Test
    fun dateAdd_test(){
        println(Date().format())
        println(Date().add(10, TimeUnits.SECOND).format())
        println(Date().add(5, TimeUnits.MINUTE).format())
        println(Date().add(7, TimeUnits.HOUR).format())
        println(Date().add(3, TimeUnits.DAY).format())
    }

}