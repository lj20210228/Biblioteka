package com.example.biblioteka

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.biblioteka.interfejs.BibliotekaInterfejs
import java.time.LocalDateTime

class Biblioteka: BibliotekaInterfejs {

    private var knjige=mutableListOf<Knjiga>()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun dodajKnjigu(knjiga: Knjiga?): LocalDateTime {
        if(knjiga==null)
            throw NullPointerException("Knjiga ne sme biti null")
        if (knjige.contains(knjiga))
            throw IllegalArgumentException("Knjiga vec postoji")
        knjige.add(knjiga)
        return LocalDateTime.now()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun obrisiKnjigu(knjiga: Knjiga?): LocalDateTime {
        if (knjiga==null){
            throw NullPointerException("Knjiga ne sme biti null")

        }
        if (!knjige.contains(knjiga))
            throw IllegalArgumentException("Knjiga ne postoji")
        knjige.remove(knjiga)
        return LocalDateTime.now()
    }

    override fun vratiSveKnjige(): List<Knjiga> {
        return knjige
    }

    override fun pronadjiKnjigu(
        autor: Autor,
        isbn: Long,
        naslov: String,
        izdavac: String
    ): List<Knjiga> {
        if (autor==null&&isbn==0L&&naslov.isNullOrEmpty()&&izdavac.isNullOrEmpty())
            throw IllegalArgumentException("Morate uneti bar jedan parametar")
        return knjige.filter { knjiga->
            knjiga.getNaslov().toUpperCase().contains(naslov.toUpperCase())
        }
    }


}