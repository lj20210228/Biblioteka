package com.example.biblioteka.biblioteka

import com.example.biblioteka.Autor
import com.example.biblioteka.Knjiga
import com.example.biblioteka.interfejs.BibliotekaInterfejs
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.IllegalArgumentException
import java.time.LocalDateTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

abstract class BibliotekaInterfejsTest {


    var biblioteka: BibliotekaInterfejs?=null
    private lateinit var knjiga1: Knjiga
    private lateinit var knjiga2: Knjiga
    private lateinit var knjiga3: Knjiga


    abstract fun getInstance(): BibliotekaInterfejs

    @BeforeEach
    fun setUp(){
        biblioteka=getInstance()
        knjiga1= Knjiga("Zlocin i kazna",1234567890L,
            listOf(Autor("Vilijam","Sekspir"),
                Autor("Ivo","Andric")
            ),"Laguna",50)
        knjiga2=Knjiga("Na Drini cuprija",1784567890L,
            listOf(Autor("Branislav","Nusic"),
                Autor("Ivo","Andric")
            ),"Vulkan",100)
        knjiga3=Knjiga("Manifest",1234907890L,
            listOf(Autor("Karl","Marks"),
                Autor("Fridrih","Engels")
            ),"Deutche",2000)
    }
    @AfterEach
    fun tearDown(){
        biblioteka=null
    }

    @Test
    fun dodajKnjigu_null(){
        assertThrows<NullPointerException> { biblioteka?.dodajKnjigu(null) }
    }
    @Test
    fun dodajKnjigu_vecPostoji(){
        biblioteka?.dodajKnjigu(knjiga1)
        assertThrows<IllegalArgumentException> {
            biblioteka?.dodajKnjigu(knjiga1)
        }
    }
    @Test
    fun dodajKnjigu_Uspesno(){
        val povratno: LocalDateTime=biblioteka?.dodajKnjigu(knjiga1)!!
        assertEquals(LocalDateTime.now().withSecond(0).withNano(0),povratno)

    }
    @Test
    fun obrisiKnjigu_null(){
        assertThrows<NullPointerException> {
            biblioteka?.obrisiKnjigu(null)
        }
    }
    @Test
    fun obrisiKnjiguNePostoji(){

        assertThrows<IllegalArgumentException> { biblioteka?.obrisiKnjigu(knjiga3) }
    }
    @Test
    fun obrisiKnjigu_postoji(){

        biblioteka?.dodajKnjigu(knjiga1)
        biblioteka?.dodajKnjigu(knjiga2)
        assertEquals(LocalDateTime.now().withSecond(0).withNano(0),
            biblioteka?.obrisiKnjigu(knjiga1)?.withSecond(0)?.withNano(0))
    }

    @Test
    fun vratiSveKnjigeTest(){
        val lista=mutableListOf<Knjiga>()
        lista.add(knjiga1)
        lista.add(knjiga2)
        lista.add(knjiga3)
        biblioteka?.dodajKnjigu(knjiga1)
        biblioteka?.dodajKnjigu(knjiga2)
        biblioteka?.dodajKnjigu(knjiga3)
        assertEquals(lista,biblioteka?.vratiSveKnjige())
    }


    @Test
    fun vratiKnjigu_null(){
        assertThrows<IllegalArgumentException> {
            biblioteka?.pronadjiKnjigu(null,0L,"","")
        }
    }
    @ParameterizedTest
    @CsvSource(
        "Zlocin i kazna",
        "Na Drini cuprija",
        "Manifest"
    )
    fun vratiKnjiguUspesno(naslov: String){
        biblioteka?.dodajKnjigu(knjiga3)
        biblioteka?.dodajKnjigu(knjiga2)
        biblioteka?.dodajKnjigu(knjiga1)
        val result=biblioteka?.pronadjiKnjigu(null,0L,naslov,"")
        val pronadjenaKnjiga=result?.get(0)
        assertEquals(naslov,pronadjenaKnjiga?.getNaslov())
    }


}