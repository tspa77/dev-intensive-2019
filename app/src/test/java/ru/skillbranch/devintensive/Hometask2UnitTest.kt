package ru.skillbranch.devintensive


import org.junit.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.MessageType
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils

class Hometask2UnitTest {

    /**
     * DTO User, Factory
     * Необходимо создать data класс User и реализовать Factory для создания экземпляров класса
     *
     * Реализуй паттерн Factory с методом makeUser(fullName) принимающий в качесте аргумента
     * полное имя пользователя и возвращающий экземпляр класса User
     */


    @Test
    fun test_DTO_UserFactory() {
        val user1 = User.makeUser("John Silver")
//        val user2 = User.makeUser("John ")
//        val user3 = User.makeUser(" ")
//        val user4 = User.makeUser(null)
        print("$user1")
//        print("$user1\n$user2\n$user3\n$user4")

    }


    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Павел Цыганков")
        val txtMessage = BaseMessage.makeMessage(
            user, Chat("OurChat"),
            payload = "any text message", type = MessageType.TEXT
        )
        val imgMessage = BaseMessage.makeMessage(
            user, Chat("OurChat"), isIncoming = true,
            payload = "https://anyurl.com", type = MessageType.IMAGE
        )

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }

    @Test
    fun test_parseFullName() {
        assertEquals("John" to "Silver", Utils.parseFullName("John Silver"))
        assertEquals(null to null, Utils.parseFullName(null))
        assertEquals(null to null, Utils.parseFullName(""))
        assertEquals(null to null, Utils.parseFullName(" "))
        assertEquals(null to null, Utils.parseFullName("  "))
        assertEquals(null to null, Utils.parseFullName("   "))
        assertEquals("John" to null, Utils.parseFullName("John"))
        assertEquals("John" to null, Utils.parseFullName(" John"))
        assertEquals("John" to null, Utils.parseFullName(" John "))

    }


}