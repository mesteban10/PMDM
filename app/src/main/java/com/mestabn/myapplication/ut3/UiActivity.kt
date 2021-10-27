package com.mestabn.myapplication.ut3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import com.mestabn.myapplication.R

class UiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("@dev", "onCreate")
        setContentView(R.layout.activity_ui)

        //Declaro variable de tipo inmutable del tipo AppCompatImageView y la inicializo buscando la imagen en el activity_main.xml
        val imageLion : AppCompatImageView = findViewById(R.id.lion_image) //Busco en la vista del Main y lo guardo en variable
        //val imageLion = findViewById<AppCompatImageView>(R.id.lion_image) //Otra forma de declararlo

        //imageLion.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.lion_image)) //El contexto es la propia actividad, el this representa el Main Activity
         imageLion.setImageResource(R.drawable.lion_image)

    }
    
   override fun onStart(){
        super.onStart()
        Log.d("@dev", "onStart")
    }

    override fun onResume(){
        super.onResume()
        Log.d("@dev", "OnResune")
    }
    override fun onPause(){
        super.onPause()
        Log.d("@dev", "onPause")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d("@dev", "OnDestroy")
    }
    override fun onStop(){
        super.onStop()
        Log.d("@dev", "OnStop")
    }


}