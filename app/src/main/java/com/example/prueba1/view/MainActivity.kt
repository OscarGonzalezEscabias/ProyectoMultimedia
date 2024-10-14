package com.example.prueba1.view

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.prueba1.R
import com.example.prueba1.logic.interfaces.OperationsInterface

class MainActivity : AppCompatActivity(), OperationsInterface {
    private lateinit var myButtonAdd : ImageView
    private lateinit var myButtonUpdate : ImageView
    private lateinit var myButtonDelete : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        //    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        //    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        //    insets
        //}

        Log.d(TAG, "Esto es un ejemplo de log")
        start();
    }

    private fun start() {
        myButtonAdd = findViewById(R.id.iv_add)
        myButtonUpdate = findViewById(R.id.iv_edit)
        myButtonDelete = findViewById(R.id.iv_delete)

        myButtonAdd.setOnClickListener{
            Log.d(TAG, "Boton de añadir")
        }

        myButtonUpdate.setOnClickListener{
            Log.d(TAG, "Boton de editar")
        }

        myButtonDelete.setOnClickListener{
            Log.d(TAG, "Boton de borrar")
        }
    }

    companion object {
        const val TAG = "---SALIDA---"
    }

    override fun ClientAdd(id: Int, name: String) {
        TODO("Not yet implemented")
    }

    override fun ClientDel(id: Int) {
        TODO("Not yet implemented")
    }

    override fun ClientUpdate(id: Int, name: String) {
        TODO("Not yet implemented")
    }
}