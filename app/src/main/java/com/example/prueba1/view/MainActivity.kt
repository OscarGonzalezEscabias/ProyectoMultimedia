package com.example.prueba1.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.prueba1.R
import com.example.prueba1.logic.Client
import com.example.prueba1.logic.Controller
import com.example.prueba1.logic.interfaces.OperationsInterface

class MainActivity : AppCompatActivity(), OperationsInterface {
    private lateinit var myButtonAdd: ImageView
    private lateinit var myButtonUpdate: ImageView
    private lateinit var myButtonDel: ImageView
    private lateinit var myDialog : Dialog
    private val controller= Controller()

    companion object {
        const val TAG = "---SALIDA---"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //      enableEdgeToEdge()  //barra superior transparente. App de borde a borde (toaaaa)
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        Log. d(TAG, "Esto es un ejemplo de log")
        start()
    }





    private fun start() {
        myButtonAdd = findViewById(R.id.iv_add)
        myButtonUpdate = findViewById(R.id.iv_edit)
        myButtonDel = findViewById(R.id.iv_delete)
        myDialog = Dialog(controller)

        myDialog.setListener(this)

        myButtonAdd.setOnClickListener{
            myDialog.show(0)
        }

        myButtonUpdate.setOnClickListener{
            myDialog.show(1)

        }

        myButtonDel.setOnClickListener( {
            myDialog.show(2)

        })


    }


    override fun ClientAdd(id: Int, name: String){
        val newClient = Client (id, name)
        controller.ClientAddController(newClient)
        var msg =  "El cliente con id = $id, ha sido insertado correctamente"

        Log.d(TAG, msg)
        showConsoleData(msg)
    }

    override fun ClientDel(id: Int) {
        var msg = ""
        val delete = controller.ClientDelController(id)  //borramos

        if (delete)
            msg =  "El cliente con id = $id, ha sido eliminado correctamente"
        else
            msg = "El cliente con id = $id, no ha sido encontrado para eliminar"

        Log. d(TAG, msg)
        showConsoleData(msg)

    }



    override fun ClientUpdate(id: Int, name: String) {
        var msg = ""
        val update = controller.ClientEditController(id, name)

        if (update)
            msg =  "El cliente con id = $id, ha sido eliminado correctamente"
        else
            msg = "El cliente con id = $id, no ha sido encontrado para eliminar"

        Log. d(TAG, msg)
        showConsoleData(msg)

    }

    fun showConsoleData(msg:String){
        val msg = controller.showData()
        Thread.sleep(2000)
        Log. d(TAG, msg)
    }

}