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
        assertEquals("123456...", "123456789".truncate(6))
        assertEquals("123456789", "123456789".truncate(9))
        assertEquals(
            "Bender Bending R...",
            "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate()
        )
        assertEquals(
            "Bender Bending...",
            "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15)
        )
        assertEquals("1", "1     ".truncate(3))

    }

    /**
     * *String.stripHtml
     * Необходимо реализовать метод stripHtml для очистки строки от лишних пробелов, html тегов, escape
     * последовательностей
     * Реализуй extension позволяющий очистить строку от html тегов и html escape последовательностей
     * ("& < > ' ""), а так же удалить пустые символы (пробелы) между словами если их больше 1. Необходимо
     * вернуть модифицированную строку
     * Пример:
     * "<p class="title">Образовательное IT-сообщество Skill Branch</p>".stripHtml()
     * //Образовательное IT-сообщество Skill Branch
     * "<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml()
     * //Образовательное IT-сообщество Skill Branch
     */

@Test
    fun test_stripHtml(){
        /* skillBranch tests */
        assertEquals("Образовательное IT-сообщество Skill Branch",
            "<p class=\"title\">Образовательное IT-сообщество Skill Branch</p>".stripHtml())
        assertEquals("Образовательное IT-сообщество Skill Branch",
            "<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml())

    }

}