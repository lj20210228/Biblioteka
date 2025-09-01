package com.example.biblioteka

import kotlinx.serialization.Serializable

@Serializable
data class Autor(
    private var ime: String,
    private var prezime: String
){
    fun getIme():String{
        return this.ime
    }
    fun setIme(ime: String?){
        if(ime==null)
            throw NullPointerException("Ime ne sme biti null")
        if(ime.isEmpty())
            throw IllegalArgumentException("Ime ne sme biti prazno")
        this.ime=ime
    }
    fun getPrezime(): String{
        return this.prezime
    }
    fun setPrezime(prezime: String?){
        if(prezime==null)
            throw NullPointerException("Prezime ne sme biti null")
        if (prezime.isEmpty()){
            throw IllegalArgumentException("Prezime ne sme biti prazno")
        }
        this.prezime=prezime
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Autor

        if (ime != other.ime) return false
        if (prezime != other.prezime) return false

        return true
    }

    override fun hashCode(): Int {
        var result = ime.hashCode()
        result = 31 * result + prezime.hashCode()
        return result
    }

    override fun toString(): String {
        return "Autor(ime='$ime', prezime='$prezime')"
    }
}
