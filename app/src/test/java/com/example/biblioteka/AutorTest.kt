package com.example.biblioteka

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AutorTest {

    var autor: Autor?=null

    @BeforeEach
    fun setUp(){
        autor= Autor("Branislav","Nusic")

    }
    @AfterEach
    fun tearDown(){
        autor=null
    }

    @Test
    fun getImeTest(){
        assertEquals("Branislav",autor?.getIme())
    }
    @Test
    fun setImeNull(){
        assertThrows<NullPointerException> {
            autor?.setIme(null)
        }
    }
    @Test
    fun setIme_prazanString(){
        assertThrows<IllegalArgumentException> {
            autor?.setIme("")
        }
    }
    @Test
    fun setIme_ispravno(){
        autor?.setIme("Jovan")
        assertEquals("Jovan",autor?.getIme())
    }
    @Test
    fun getPrezimeTest(){
        assertEquals("Nusic",autor?.getPrezime())
    }
    @Test
    fun setPrezimeNull(){
        assertThrows<NullPointerException> {
            autor?.setPrezime(null)
        }
    }
    @Test
    fun setPrezime_prazanString(){
        assertThrows<IllegalArgumentException> {
            autor?.setPrezime("")
        }
    }
    @Test
    fun setPrezime_ispravno(){
        autor?.setPrezime("Jovan")
        assertEquals("Jovan",autor?.getPrezime())
    }

    @Test
    fun equals_Isti(){
        val  autor2= Autor("Branislav","Nusic")
        assertTrue(autor?.equals(autor2)!!)


    }
    @Test
    fun equals_Razliciti(){
        val  autor2= Autor("Jovan","Nusic")
        assertFalse (autor?.equals(autor2)!!)


    }

    @Test
    fun hashCodeTest(){
        val  autor2= Autor("Branislav","Nusic")

        assertEquals(autor.hashCode(),autor2.hashCode())

    }
    @Test
    fun toStringTest(){
        val  autor2= autor.toString()
        assertTrue(autor2.contains("Branislav"))
        assertTrue(autor2.contains("Nusic"))

    }
}