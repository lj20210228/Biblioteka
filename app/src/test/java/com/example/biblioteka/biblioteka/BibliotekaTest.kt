package com.example.biblioteka.biblioteka

import com.example.biblioteka.Biblioteka
import com.example.biblioteka.interfejs.BibliotekaInterfejs

class BibliotekaTest: BibliotekaInterfejsTest() {
    override fun getInstance(): BibliotekaInterfejs {
        return Biblioteka()
    }

}