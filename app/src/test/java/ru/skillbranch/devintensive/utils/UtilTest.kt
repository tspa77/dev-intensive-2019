package ru.skillbranch.devintensive.utils


import org.junit.Assert.assertEquals
import org.junit.Test

class UtilTest {

    /**
     * Необходимо реализовать утилитный метод parseFullName(fullName) принимающий в качестве аргумента полное имя
     * пользователя и возвращающий пару значений "firstName lastName"
     *
     * Реализуй метод Utils.parseFullName(fullName) принимающий в качестве аргумента полное имя пользователя
     * (null, пустую строку) и возвращающий пару значений Pair(firstName, lastName) при невозможности распарсить
     * полное имя или его часть вернуть null null/"firstName" null
     *
     * Пример:
     * Utils.parseFullName(null) //null null
     * Utils.parseFullName("") //null null
     * Utils.parseFullName(" ") //null null
     * Utils.parseFullName("John") //John null
     *
     */

    @Test
    fun test_parseFullName() {
        assertEquals("John" to "Silver", Utils.parseFullName("John Silver"))
        assertEquals("John" to "Silver", Utils.parseFullName(" John Silver"))
        assertEquals("John" to "Silver", Utils.parseFullName(" John Silver "))
        assertEquals("John" to "Silver", Utils.parseFullName("  John  Silver  "))
        assertEquals(null to null, Utils.parseFullName(null))
        assertEquals(null to null, Utils.parseFullName(""))
        assertEquals(null to null, Utils.parseFullName(" "))
        assertEquals(null to null, Utils.parseFullName("  "))
        assertEquals("John" to null, Utils.parseFullName("John"))
        assertEquals("John" to null, Utils.parseFullName("  John"))
        assertEquals("John" to null, Utils.parseFullName("John  "))
        assertEquals("John" to null, Utils.parseFullName("  John  "))
    }


    /**
     * *toInitials
     * Необходимо реализовать утилитный метод toInitials(firstName lastName) принимающий в качестве аргументов имя и
     * фамилию пользователя и возвращающий его инициалы
     *
     * Реализуй метод Utils.toInitials(firstName lastName) принимающий в качестве аргументов имя и фамилию пользователя
     * (null, пустую строку) и возвращающий строку с первыми буквами имени и фамилии в верхнем регистре (если один из
     * аргументов null то вернуть один инициал, если оба аргумента null вернуть null)
     * Пример:
     * Utils.toInitials("john" ,"doe") //JD
     * Utils.toInitials("John", null) //J
     * Utils.toInitials(null, null) //null
     * Utils.toInitials(" ", "") //null
     */

    @Test
    fun test_toInitials() {
        assertEquals("JD", Utils.toInitials("john", "doe"))
        assertEquals("JD", Utils.toInitials(" john", " doe"))
        assertEquals("JD", Utils.toInitials("  jonatan", " doe "))
        assertEquals(null, Utils.toInitials("", null))
        assertEquals(null, Utils.toInitials(" ", null))
        assertEquals("J", Utils.toInitials("j", null))
        assertEquals("J", Utils.toInitials(" j", null))
        assertEquals("D", Utils.toInitials(null, " d"))
        assertEquals("D", Utils.toInitials(null, "d"))
        assertEquals(null, Utils.toInitials(null, ""))
        assertEquals(null, Utils.toInitials(null, " "))
        assertEquals(null, Utils.toInitials(null, null))
        assertEquals(null, Utils.toInitials("  ", ""))
        assertEquals(null, Utils.toInitials(" ", ""))
        assertEquals(null, Utils.toInitials("", ""))
        assertEquals(null, Utils.toInitials("", " "))
        assertEquals(null, Utils.toInitials("", "  "))
    }

    @Test
    fun test_getFirstUpperCaseLetter() {
        assertEquals("J", Utils.getFirstUpperCaseLetter("john"))
        assertEquals("J", Utils.getFirstUpperCaseLetter(" john"))
        assertEquals("J", Utils.getFirstUpperCaseLetter("  john "))
        assertEquals("J", Utils.getFirstUpperCaseLetter("  john  doe"))
        assertEquals(null, Utils.getFirstUpperCaseLetter("   "))
        assertEquals(null, Utils.getFirstUpperCaseLetter("  "))
        assertEquals(null, Utils.getFirstUpperCaseLetter(" "))
        assertEquals(null, Utils.getFirstUpperCaseLetter(""))
        assertEquals(null, Utils.getFirstUpperCaseLetter(null))
    }




}