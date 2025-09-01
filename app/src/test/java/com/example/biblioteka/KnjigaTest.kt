package com.example.biblioteka

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class KnjigaTest {
    var knjiga: Knjiga?=null

    var autor1: Autor?=null
    var autor2: Autor?=null
    var autor3: Autor?=null
    @BeforeEach
    fun setUp(){
        knjiga= Knjiga("Zlocin i kazna",1234567890L,
            listOf(Autor("Vilijam","Sekspir"),
                Autor("Ivo","Andric")
            ),"Laguna",50)

        autor1= Autor("Vilijam","Sekspir")
        autor2=Autor("Ivo","Andric")
        autor3= Autor("Branislav","Nusic")
    }
    @AfterEach
    fun tearDown(){
        knjiga=null
        autor1=null
        autor2=null
        autor3=null

    }
    @Test
    fun getNaslovTest(){
        assertEquals("Zlocin i kazna",knjiga?.getNaslov())
    }
    @Test
    fun setNaslov_null(){
        assertThrows<NullPointerException> {
            knjiga?.setNaslov(null)
        }
    }
    @Test
    fun setNaslov_prazan(){
        assertThrows<IllegalArgumentException> {
            knjiga?.setNaslov("")
        }
    }
    @Test
    fun setNaslov_ispravno(){
        knjiga?.setNaslov("Knjiga")
        assertEquals("Knjiga",knjiga?.getNaslov())
    }
    @Test
    fun getIsbnTest(){
        assertEquals("Zlocin i kazna",knjiga?.getNaslov())
    }
    @Test
    fun setIsbn_null(){
        assertThrows<NullPointerException> {
            knjiga?.setIsbn(null)
        }
    }
    @ParameterizedTest
    @CsvSource(
        "9999999",
        "111111111111"
    )
    fun setIsbn_Neispravno(isbn:Long){
        assertThrows<IllegalArgumentException> {
            knjiga?.setIsbn(isbn.toLong())
        }
    }

    @ParameterizedTest
    @CsvSource(
        "1234567890",
        "8888888888",
        "9999999999",
        "2222222222"
        ,"5674289675"
    )
    fun setIsbn_ispravno(isbn: Long){
        knjiga?.setIsbn(isbn)
        assertEquals(isbn,knjiga?.getIsbn())
    }
    @Test
    fun getAutoriTest(){
        val autori=mutableListOf<Autor>()
        autori.add(autor1!!)
        autori.add(autor2!!)
        assertEquals(autori,knjiga?.getAutori())
    }
    @Test
    fun setAutori_praznaLista(){
        assertThrows<IllegalArgumentException> { knjiga?.setAutori(emptyList()) }
    }
    @Test
    fun setAutori_ispravno()
    {
        val lista=mutableListOf<Autor>()
        lista.add(autor2!!)
        lista.add(autor1!!)
        knjiga?.setAutori(lista)
        assertTrue(knjiga?.getAutori()?.contains(autor2)!!)
        assertTrue(knjiga?.getAutori()?.contains(autor1)!!)
    }

    @Test
    fun getIzdavacTest(){
        assertEquals("Laguna",knjiga?.getIzdavac())
    }
    @Test
    fun setIzdavacNull(){
        assertThrows < NullPointerException>{
            knjiga?.setIzdavac(null)
        }
    }
    @Test
    fun setIzdavac_prazno(){
        assertThrows<IllegalArgumentException> {
            knjiga?.setIzdavac("")
        }
    }
    @ParameterizedTest
    @CsvSource(
        "Laguna",
        "Vulkan",
        "Epoha"
    )
    fun setIzdavacIspravno(izdavac: String){
        knjiga?.setIzdavac(izdavac)
        assertEquals(izdavac,knjiga?.getIzdavac())
    }

    @Test
    fun getIzdanje(){
        assertEquals(50,knjiga?.getIzdanje())
    }

    @ParameterizedTest
    @CsvSource(
        "0",
        "-1",
        "-2"
    )
    fun setIzdanje_neispravno(izdanje: Int){
        assertThrows<IllegalArgumentException> {
            knjiga?.setIzdanje(izdanje)
        }
    }
    @ParameterizedTest
    @CsvSource(
        "5",
        "10",
        "15"
    )
    fun setIzdanje_ispravno(izdanje: Int){
        knjiga?.setIzdanje(izdanje)
        assertEquals(izdanje,knjiga?.getIzdanje())
    }



    @Test
    fun equalsTest_isti(){
        val knjiga2= Knjiga("Zlocin i kazna",1234567890L,
            listOf(Autor("Vilijam","Sekspir"),
                Autor("Ivo","Andric")
            ),"Laguna",50)
        assertTrue(knjiga?.equals(knjiga2)!!)
    }
    @Test
    fun equalsTest_razliciti(){
        val knjiga2= Knjiga("Hamlet",1234567890L,
            listOf(Autor("Vilijam","Sekspir"),
                Autor("Ivo","Andric")
            ),"Laguna",50)
        assertFalse (knjiga?.equals(knjiga2)!!)
    }
    @Test
    fun hashCodeTest(){
        val knjiga2= Knjiga("Zlocin i kazna",1234567890L,
            listOf(Autor("Vilijam","Sekspir"),
                Autor("Ivo","Andric")
            ),"Laguna",50)

        assertEquals(knjiga.hashCode(),knjiga2.hashCode())

    }

    @Test
    fun toStringTest(){
        val knjiga2=knjiga.toString()

        assertTrue(knjiga2.contains("Vilijam"))
        assertTrue(knjiga2.contains("Sekspir"))
        assertTrue(knjiga2.contains("Ivo"))
        assertTrue(knjiga2.contains("Andric"))
        assertTrue(knjiga2.contains("Laguna"))
        assertTrue(knjiga2.contains("50"))
        assertTrue(knjiga2.contains("1234567890"))
        assertTrue(knjiga2.contains("Zlocin i kazna"))



    }


}