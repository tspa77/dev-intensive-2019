package ru.skillbranch.devintensive.utils


import org.junit.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintensive.utils.Utils.getTranslitMap
import ru.skillbranch.devintensive.utils.Utils.readFileAsLinesUsingReadLines
import ru.skillbranch.devintensive.utils.Utils.transliteration

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
        assertEquals("", Utils.getFirstUpperCaseLetter("    "))
        assertEquals("", Utils.getFirstUpperCaseLetter("   "))
        assertEquals("", Utils.getFirstUpperCaseLetter("  "))
        assertEquals("", Utils.getFirstUpperCaseLetter(" "))
        assertEquals("", Utils.getFirstUpperCaseLetter(""))
        assertEquals("", Utils.getFirstUpperCaseLetter(null))
    }


    @Test
    fun test_readFileAsLinesUsingReadLines() {
        val fileName = System.getProperty("user.dir") +
//                "\\src\\main\\java\\ru\\skillbranch\\devintensive\\utils\\transliteration.txt"
                "/src/main/java/ru/skillbranch/devintensive/utils/transliteration.txt"

        val lines = readFileAsLinesUsingReadLines(fileName)

        getTranslitMap(lines)
    }


    /**
     * *transliteration
     * Необходимо реализовать утилитный метод transliteration(payload divider) принимающий в качестве аргумента
     * строку и возвращающий преобразованную строку из латинских символов
     *
     * Реализуй метод Utils.transliteration(payload divider) принимающий в качестве аргумента строку
     * (divider по умолчанию " ") и возвращающий преобразованную строку из латинских символов, словарь символов
     * соответствия алфовитов доступен в ресурсах к заданию
     * Пример:
     * Utils.transliteration("Женя Стереотипов") //Zhenya Stereotipov
     * Utils.transliteration("Amazing Петр","_") //Amazing_Petr
     */

    @Test
    fun test_transliteration() {
        assertEquals("", transliteration(""))
        assertEquals("", transliteration("", "*"))
        assertEquals("*", transliteration(" ", "*"))
        assertEquals("Zhenya Stereotipov", transliteration("Женя Стереотипов"))
        assertEquals("Amazing_Petr", transliteration("Amazing Петр","_"))
        assertEquals("Pavel`Senyor`Cigankov", transliteration("Павел Senyor Цыганков","`"))
    }


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
}