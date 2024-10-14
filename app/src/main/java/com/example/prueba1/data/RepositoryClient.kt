package com.example.prueba1.data

import com.example.prueba1.logic.Client

class RepositoryClient {

    companion object {
        var primary = 100

        val listClient : List<Client> = listOf (
            Client(incrementPrimary(), "Santi"),
            Client(incrementPrimary(), "Sonia"),
            Client(incrementPrimary(), "Guille"),
            Client(incrementPrimary(), "Diego")
            )

        fun incrementPrimary() = primary ++

    }

}