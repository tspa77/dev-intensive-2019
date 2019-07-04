package ru.skillbranch.devintensive.extensions

import junit.framework.Assert.assertEquals
import org.junit.Assert
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
    fun dateFormat_test() {
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
    fun dateAdd_test() {
        println(Date().format())
        println(Date().add(10, TimeUnits.SECOND).format())
        println(Date().add(5, TimeUnits.MINUTE).format())
        println(Date().add(7, TimeUnits.HOUR).format())
        println(Date().add(3, TimeUnits.DAY).format())
    }


    /**
     * *Date.humanizeDiff
     * Необходимо реализовать extension для форматирования вывода разницы между текущим экземпляром Date и
     * текущим моментом времени (или указанным в качестве аргумента) в человекообразном формате
     *
     * Реализуй extension Date.humanizeDiff(date) (значение по умолчанию текущий момент времени) для
     * форматирования вывода разницы между датами в человекообразном формате, с учетом склонения числительных.
     * Временные интервалы преобразований к человекообразному формату доступны в ресурсах к заданию
     * Пример:
     * Date().add(-2, TimeUnits.HOUR).humanizeDiff() //2 часа назад
     * Date().add(-5, TimeUnits.DAY).humanizeDiff() //5 дней назад
     * Date().add(2, TimeUnits.MINUTE).humanizeDiff() //через 2 минуты
     * Date().add(7, TimeUnits.DAY).humanizeDiff() //через 7 дней
     * Date().add(-400, TimeUnits.DAY).humanizeDiff() //более года назад
     * Date().add(400, TimeUnits.DAY).humanizeDiff() //более чем через год
     */


    @Test
    fun test_of_humanizeDiff() {
        // ----- Past -----
        assertEquals("только что", Date().add(-1, TimeUnits.SECOND).humanizeDiff())
        assertEquals("несколько секунд назад", Date().add(-45, TimeUnits.SECOND).humanizeDiff())
        assertEquals("минуту назад", Date().add(-46, TimeUnits.SECOND).humanizeDiff())
        assertEquals("1 минуту назад", Date().add(-76, TimeUnits.SECOND).humanizeDiff())
        assertEquals("минуту назад", Date().add(-1, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("2 минуты назад", Date().add(-2, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("3 минуты назад", Date().add(-3, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("45 минут назад", Date().add(-45, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("час назад", Date().add(-1, TimeUnits.HOUR).humanizeDiff())
        assertEquals("1 час назад", Date().add(-76, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("2 часа назад", Date().add(-120, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("3 часа назад", Date().add(-3, TimeUnits.HOUR).humanizeDiff())
        assertEquals("4 часа назад", Date().add(-4, TimeUnits.HOUR).humanizeDiff())
        assertEquals("5 часов назад", Date().add(-5, TimeUnits.HOUR).humanizeDiff())
        assertEquals("день назад", Date().add(-26, TimeUnits.HOUR).humanizeDiff())
        assertEquals("1 день назад", Date().add(-27, TimeUnits.HOUR).humanizeDiff())
        assertEquals("4 дня назад", Date().add(-4, TimeUnits.DAY).humanizeDiff())
        assertEquals("5 дней назад", Date().add(-5, TimeUnits.DAY).humanizeDiff())
        assertEquals("360 дней назад", Date().add(-360, TimeUnits.DAY).humanizeDiff())
        assertEquals("более года назад", Date().add(-361, TimeUnits.DAY).humanizeDiff())

        // ----- Future ------
        assertEquals("через несколько секунд", Date().add(2, TimeUnits.SECOND).humanizeDiff())
        assertEquals("через минуту", Date().add(1, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("через 2 минуты", Date().add(2, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("через 3 минуты", Date().add(3, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("через 5 минут", Date().add(5, TimeUnits.MINUTE).humanizeDiff())
        assertEquals("через час", Date().add(1, TimeUnits.HOUR).humanizeDiff())
        assertEquals("через 2 часа", Date().add(2, TimeUnits.HOUR).humanizeDiff())
        assertEquals("через 3 часа", Date().add(3, TimeUnits.HOUR).humanizeDiff())
        assertEquals("через 4 часа", Date().add(4, TimeUnits.HOUR).humanizeDiff())
        assertEquals("через 5 часов", Date().add(5, TimeUnits.HOUR).humanizeDiff())
        assertEquals("через день", Date().add(1, TimeUnits.DAY).humanizeDiff())
        assertEquals("через 4 дня", Date().add(4, TimeUnits.DAY).humanizeDiff())
        assertEquals("через 5 дней", Date().add(5, TimeUnits.DAY).humanizeDiff())
        assertEquals("через 148 дней", Date().add(148, TimeUnits.DAY).humanizeDiff())
        assertEquals("более чем через год", Date().add(400, TimeUnits.DAY).humanizeDiff())
    }


    /**
     * **plural
     * Необходимо реализовать метод plural для enum TimeUnits
     * Реализуй метод plural для всех перечислений TimeUnits следующего вида TimeUnits.SECOND.plural(value:Int)
     * возвращающую значение в виде строки с праильно склоненной единицой измерения
     * Пример:
     * TimeUnits.SECOND.plural(1) //1 секунду
     * TimeUnits.MINUTE.plural(4) //4 минуты
     * TimeUnits.HOUR.plural(19) //19 часов
     * TimeUnits.DAY.plural(222) //222 дня
     */

    @Test
    fun test_plural() {
        assertEquals("0 секунд", TimeUnits.SECOND.plural(0))
        assertEquals("1 секунду", TimeUnits.SECOND.plural(1))
        assertEquals("2 секунды", TimeUnits.SECOND.plural(2))
        assertEquals("7 секунд", TimeUnits.SECOND.plural(7))
        assertEquals("14 секунд", TimeUnits.SECOND.plural(14))
        assertEquals("24 секунды", TimeUnits.SECOND.plural(24))
        assertEquals("112 секунд", TimeUnits.SECOND.plural(112))
        assertEquals("122 секунды", TimeUnits.SECOND.plural(122))
        assertEquals("311 секунд", TimeUnits.SECOND.plural(311))

        assertEquals("0 минут", TimeUnits.MINUTE.plural(0))
        assertEquals("1 минуту", TimeUnits.MINUTE.plural(1))
        assertEquals("2 минуты", TimeUnits.MINUTE.plural(2))
        assertEquals("7 минут", TimeUnits.MINUTE.plural(7))
        assertEquals("14 минут", TimeUnits.MINUTE.plural(14))
        assertEquals("24 минуты", TimeUnits.MINUTE.plural(24))
        assertEquals("112 минут", TimeUnits.MINUTE.plural(112))
        assertEquals("122 минуты", TimeUnits.MINUTE.plural(122))
        assertEquals("311 минут", TimeUnits.MINUTE.plural(311))

        assertEquals("0 часов", TimeUnits.HOUR.plural(0))
        assertEquals("1 час", TimeUnits.HOUR.plural(1))
        assertEquals("2 часа", TimeUnits.HOUR.plural(2))
        assertEquals("7 часов", TimeUnits.HOUR.plural(7))
        assertEquals("14 часов", TimeUnits.HOUR.plural(14))
        assertEquals("24 часа", TimeUnits.HOUR.plural(24))
        assertEquals("112 часов", TimeUnits.HOUR.plural(112))
        assertEquals("122 часа", TimeUnits.HOUR.plural(122))
        assertEquals("311 часов", TimeUnits.HOUR.plural(311))

        assertEquals("0 дней", TimeUnits.DAY.plural(0))
        assertEquals("1 день", TimeUnits.DAY.plural(1))
        assertEquals("2 дня", TimeUnits.DAY.plural(2))
        assertEquals("7 дней", TimeUnits.DAY.plural(7))
        assertEquals("14 дней", TimeUnits.DAY.plural(14))
        assertEquals("24 дня", TimeUnits.DAY.plural(24))
        assertEquals("112 дней", TimeUnits.DAY.plural(112))
        assertEquals("122 дня", TimeUnits.DAY.plural(122))
        assertEquals("311 дней", TimeUnits.DAY.plural(311))
    }
}