package com.example.prueba1.view

import com.example.prueba1.data.RepositoryClient
import com.example.prueba1.logic.Controller

class Dialog(var controller : Controller,
             var clientAdd :  (Int, String) -> Unit,
             var  clientUpdate : (Int,  String)-> Unit,
             var  clientDel : (Int) -> Unit) {


    private var action : Int = 0




    fun show(typeAction : Int){
        val posibleName = "CAMBIADO"
        val posibleId = controller.devIdRandom()
        when (typeAction){
            0 -> onAccept()

            1 ->
                if (posibleId != -1)
                    onEdit(posibleId, "CAMBIADO")

            2 ->
                if (posibleId != -1)
                    onDelete(posibleId)

        }

    }

    private fun onDelete(id : Int) {
        clientDel(id)
    }

    private fun onEdit(id: Int, name : String) {
        clientUpdate(id, name)
    }

    private fun onAccept() {
        clientAdd(RepositoryClient.incrementPrimary(), "NUEVO CLIENTE")
    }
}


