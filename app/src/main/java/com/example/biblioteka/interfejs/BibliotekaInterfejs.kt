package com.example.biblioteka.interfejs

import com.example.biblioteka.Autor
import com.example.biblioteka.Knjiga
import java.time.LocalDateTime

interface BibliotekaInterfejs {

    fun dodajKnjigu(knjiga: Knjiga?): LocalDateTime
    fun obrisiKnjigu(knjiga: Knjiga?): LocalDateTime
    fun vratiSveKnjige(): List<Knjiga>
    fun pronadjiKnjigu(autor: Autor,isbn: Long,naslov: String,izdavac: String): List<Knjiga>
}