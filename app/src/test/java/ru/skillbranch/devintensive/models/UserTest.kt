package ru.skillbranch.devintensive.models

import org.junit.Test
import ru.skillbranch.devintensive.extensions.MessageType
import ru.skillbranch.devintensive.models.User

class UserTest {
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


    /**
     * Base Message, AbstractFactory
     * Необходимо создать абстрактный класс BaseMessage и два его наследника TextMessage и ImageMessage.
     * Реализовать AbstractFactory для создания экземпляров классов наследников
     *
     * Реализуй паттерн AbstractFactory с методом makeMessage(from, chat, date, type, payload, isIncoming = false)
     * принимающий в качесте аргументов пользователя создавшего сообщение, чат к которому относится сообщение, дата
     * сообщения и его тип ("text/image"), полезную нагрузку
     *
     * Пример:
     * BaseMessage.makeMessage(user, chat, date, "any text message", "text") //Василий отправил сообщение
     * "any text message" только что
     *
     * BaseMessage.makeMessage(user, chat, date, "https://anyurl.com", "image",true) //Василий получил изображение
     * "https://anyurl.com" 2 часа назад
     *
     */

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
}