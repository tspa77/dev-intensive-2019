package ru.skillbranch.devintensive.utils


import org.junit.Assert.assertEquals
import org.junit.Test

class UtilTest {

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
        assertEquals("John" to null, Utils.parseFullName(" John"))
        assertEquals("John" to null, Utils.parseFullName(" John "))

    }


}