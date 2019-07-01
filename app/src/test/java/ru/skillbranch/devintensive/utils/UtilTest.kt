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
        assertEquals(null to null, Utils.parseFullName("   "))
        assertEquals("John" to null, Utils.parseFullName("John"))
        assertEquals("John" to null, Utils.parseFullName("  John"))
        assertEquals("John" to null, Utils.parseFullName("  John  "))

    }


}