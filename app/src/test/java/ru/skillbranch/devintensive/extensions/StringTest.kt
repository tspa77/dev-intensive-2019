package ru.skillbranch.devintensive.extensions

import junit.framework.Assert.assertEquals
import org.junit.Test


class StringTest {

    /**
     *
     * *String.truncate
     * Необходимо реализовать метод truncate усекающий исходную строку до указанного числа символов и добавляющий
     * заполнитель "..." в конец строки
     *
     * Реализуй extension усекающий исходную строку до указанного числа символов (по умолчанию 16) и возвращающий
     * усеченную строку с заполнителем "..." (если строка была усечена) если последний символ усеченной строки является
     * пробелом - удалить его и добавить заполнитель
     * Пример:
     * "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate() //Bender Bending R...
     * "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15) //Bender Bending...
     * "A     ".truncate(3) //A

     */


    @Test
    fun truncateTest() {
        /* admins tests */
        assertEquals("123456...","123456789".truncate(6))
        assertEquals("123456789","123456789".truncate(9))
        assertEquals("Bender Bending R...","Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate())
        assertEquals("Bender Bending...","Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15))
        assertEquals("1","1     ".truncate(3))

    }
}