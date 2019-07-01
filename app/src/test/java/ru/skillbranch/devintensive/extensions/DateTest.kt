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
     *
     */

    @Test
    fun dateFormat_test(){

        println(Date().format())
        println(Date().format("HH:mm"))
    }


}