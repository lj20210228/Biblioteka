package com.example.biblioteka

data class Knjiga(
    private var naslov: String,
    private var isbn: Long,
    private var autori: List<Autor>,
    private var izdavaci: String,
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
        return this.izdavaci
    }
    fun setIzdavac(izdavaci: String?){
        if(izdavaci==null){
            throw NullPointerException("Izdavac ne sme biti null")
        }
        if (izdavaci.isEmpty()){
            throw IllegalArgumentException("Izdavac ne sme biti prazan")
        }
        this.izdavaci=izdavaci
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
        if (izdavaci != other.izdavaci) return false

        return true
    }

    override fun hashCode(): Int {
        var result = isbn.hashCode()
        result = 31 * result + izdanje
        result = 31 * result + naslov.hashCode()
        result = 31 * result + autori.hashCode()
        result = 31 * result + izdavaci.hashCode()
        return result
    }

    override fun toString(): String {
        return "Knjiga(naslov='$naslov', isbn=$isbn, autori=$autori, izdavac='$izdavaci', izdanje=$izdanje)"
    }


}
