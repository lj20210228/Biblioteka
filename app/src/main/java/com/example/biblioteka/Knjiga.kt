package com.example.biblioteka
import kotlinx.serialization.Serializable

@Serializable
data class Knjiga(
    private var naslov: String,
    private var isbn: Long,
    private var autori: List<Autor>,
    private var izdavac: String,
    private var izdanje: Int
){
    fun getNaslov(): String{
        return this.naslov
    }
    fun setNaslov(naslov: String?){
        if(naslov==null)
            throw NullPointerException("Naslov ne sme biti null")
        if (naslov.isEmpty()){
            throw IllegalArgumentException("Naslov ne sme biti prazan")

        }
        this.naslov=naslov
    }
    fun getIsbn(): Long{
        return this.isbn
    }
    fun setIsbn(isbn: Long?){
        if(isbn==null){
            throw NullPointerException("Isbn ne sme biti null")
        }
        if(isbn<1000000000||isbn>9999999999L)
            throw IllegalArgumentException("Isbn mora imati bar 10 cifara ")
        this.isbn=isbn
    }
    fun getAutori(): List<Autor>{
        return this.autori
    }
    fun setAutori(autori: List<Autor>){
        if(autori.isEmpty()){
            throw IllegalArgumentException("Lista autora ne moze biti prazna")
        }
        this.autori=autori
    }
    fun getIzdavac():String{
        return this.izdavac
    }
    fun setIzdavac(izdavac: String?){
        if(izdavac==null){
            throw NullPointerException("Izdavac ne sme biti null")
        }
        if (izdavac.isEmpty()){
            throw IllegalArgumentException("Izdavac ne sme biti prazan")
        }
        this.izdavac=izdavac
    }
    fun getIzdanje(): Int{
        return this.izdanje
    }
    fun setIzdanje(izdanje: Int){
        if (izdanje<1)
            throw IllegalArgumentException("Izdanje mora biti vece od 0")
        this.izdanje=izdanje
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Knjiga

        if (isbn != other.isbn) return false
        if (izdanje != other.izdanje) return false
        if (naslov != other.naslov) return false
        if (autori != other.autori) return false
        if (izdavac != other.izdavac) return false

        return true
    }

    override fun hashCode(): Int {
        var result = isbn.hashCode()
        result = 31 * result + izdanje
        result = 31 * result + naslov.hashCode()
        result = 31 * result + autori.hashCode()
        result = 31 * result + izdavac.hashCode()
        return result
    }

    override fun toString(): String {
        return "Knjiga(naslov='$naslov', isbn=$isbn, autori=$autori, izdavac='$izdavac', izdanje=$izdanje)"
    }


}
