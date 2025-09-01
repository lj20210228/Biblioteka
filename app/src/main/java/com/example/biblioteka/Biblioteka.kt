package com.example.biblioteka

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.biblioteka.interfejs.BibliotekaInterfejs
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.time.LocalDateTime

class Biblioteka: BibliotekaInterfejs {

    private var knjige=ucitajKnjige()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun dodajKnjigu(knjiga: Knjiga?): LocalDateTime {
        if(knjiga==null)
            throw NullPointerException("Knjiga ne sme biti null")
        if (knjige.contains(knjiga))
            throw IllegalArgumentException("Knjiga vec postoji")
        knjige.add(knjiga)


        val knjigeJson= Json{prettyPrint=true}.encodeToString(knjige)
        FileWriter("knjige.json",false).use {
            writter->
            writter.write(knjigeJson)

        }

        return LocalDateTime.now().withNano(0)
            .withSecond(0)
    }

    fun ucitajKnjige(): MutableList<Knjiga>{
        val file= File("knjige.json")
        if(!file.exists()||file.readText().isBlank())return mutableListOf()
        val jsonString=file.readText()

        return Json.decodeFromString<MutableList<Knjiga>>(jsonString)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun obrisiKnjigu(knjiga: Knjiga?): LocalDateTime {

        if (knjiga==null){
            throw NullPointerException("Knjiga ne sme biti null")

        }
        if (!knjige.contains(knjiga))
            throw IllegalArgumentException("Knjiga ne postoji")
        knjige.remove(knjiga)
        val jsonString=Json{prettyPrint=true}.encodeToString(knjige)
        FileWriter("knjige.json",false).use{wr->
            wr.write(jsonString)
        }
        return LocalDateTime.now()
    }

    override fun vratiSveKnjige(): List<Knjiga> {
        if(knjige.isEmpty()){
            throw NoSuchElementException("Nema knjiga u biblioteci")
        }
        return knjige
    }

    override fun pronadjiKnjigu(
        autor: Autor?,
        isbn: Long,
        naslov: String,
        izdavac: String
    ): List<Knjiga> {
        if(knjige.isEmpty())
            throw NoSuchElementException("Nema knjiga u biblioteci")
        if (autor==null&&isbn==0L&&naslov.isNullOrEmpty()&&izdavac.isNullOrEmpty())
            throw IllegalArgumentException("Morate uneti bar jedan parametar")

        return knjige.filter { knjiga->
            knjiga.getNaslov().uppercase().contains(naslov.uppercase())
        }
    }

}