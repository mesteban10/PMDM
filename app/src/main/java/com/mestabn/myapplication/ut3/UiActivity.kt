package com.mestabn.myapplication.ut3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.mestabn.myapplication.R

class UiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("@dev", "onCreate")
        setContentView(R.layout.activity_ui)
        setupView()
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

    private fun setupView() {
        setText()
        setImage()
    }

    @SuppressLint("CutPasteId")
    private fun setText() {
        val textOffer: TextView = findViewById(R.id.text_offer)
        textOffer.text = getString(R.string.offer_name)
        textOffer.setText(R.string.offer_name)
        textOffer.setTextColor(ContextCompat.getColor(this, R.color.white))

        val textNameRestaurant: TextView = findViewById(R.id.text_name_restaurant)
        textNameRestaurant.text = getString(R.string.restaurant_name)
        textNameRestaurant.setText(R.string.restaurant_name)

        val textTypeFood: TextView = findViewById(R.id.text_type_food)
        textTypeFood.text = getString(R.string.food_name)
        textTypeFood.setText(R.string.food_name)

        val textTimeDelivery: TextView = findViewById(R.id.text_time_delivery)
        textTimeDelivery.text = getString(R.string.delivery_time)
        textTimeDelivery.setText(R.string.delivery_time)

        val textNuevo: TextView = findViewById(R.id.text_nuevo)
        textNuevo.text = getString(R.string.new_restaurant)
        textNuevo.setText(R.string.new_restaurant)

        val restaurantPunctuatText: TextView = findViewById(R.id.restaurant_punctuation)
        restaurantPunctuatText.text = getString(R.string.punctuation_restaurant)
        restaurantPunctuatText.setText(R.string.punctuation_restaurant)

        val priceDeliveryText: TextView = findViewById(R.id.price_delivery)
        priceDeliveryText.text = getString(R.string.delivery_price)
        priceDeliveryText.setText(R.string.delivery_price)


    }

    private fun setImage() {
        val icLike: AppCompatImageView = findViewById(R.id.ic_like)
        icLike.setImageResource(R.drawable.ic_like_heart)

    }


}