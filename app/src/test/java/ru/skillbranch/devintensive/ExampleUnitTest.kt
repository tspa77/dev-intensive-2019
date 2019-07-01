package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun test_instance() {
        val user1 = User("1")
        val user2 = User("2", "John", "Wick")
        val user3 = User(
            "3", "John", "Silverhand",
            null, lastVisit = Date(), isOnline = true
        )

//        user1.printMe()
//        user2.printMe()
//        user3.printMe()

//        println("$user1 $user2 $user3")
    }


    @Test
    fun test_factory() {
        val user1 = User.makeUser("John Cena")
        val user2 = User.makeUser("John Wick")
        val user3 = User.makeUser("John Silverhand")
        val user4 = User.makeUser(" John")
        val user5 = User.makeUser(null)
//
//        val user1 = User.makeUser("John Cena")
//        val user2 = user1.copy(id = "9", lastName = "John Goodman", lastVisit = Date())

        print("$user1\n$user2\n" +
                "$user3\n" +
                "$user4\n" +
                "$user5")
    }


    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user

        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")

    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit = Date())
        var user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        var user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

        println(
            """
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent()
        )
    }

    @Test
    fun test_data_mapping() {
        val user = User.makeUser("Павел Цыганков")
        val newUser = user.copy(lastVisit = Date().add(-800, TimeUnits.DAY))
        println(newUser)

        val userView = user.toUserView()
        userView.printMe()
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Павел Цыганков")
//        val txtMessage = BaseMessage.makeMessage(user, Chat("OurChat"), payload = "any text message", type = "text")
//        val imgMessage = BaseMessage.makeMessage(user, Chat("OurChat"), payload = "any image url", type = "image")

//        when(imgMessage){
//            is TextMessage -> println("this is text message")
//            is ImageMessage -> println("this is image message")
//        }
//
//        println(txtMessage.formatMessage())
//        println(imgMessage.formatMessage())

    }

}
