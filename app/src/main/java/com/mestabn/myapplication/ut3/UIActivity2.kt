package com.mestabn.myapplication.ut3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.mestabn.myapplication.R

class UIActivity2 : AppCompatActivity() {

    private val TAG: String = UiActivity::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uiactivity2)
    }
    private fun initPlayGround(){
        textPLayGround()
        edittextPlayground()
        edittextWithLabelPlayground()
        imageviewPlayGround()
        buttonPlayGround()
    }

    private fun textPLayGround(){
        val textView: AppCompatTextView = findViewById(R.id.label_x)
        textView.text = getString(R.string.app_name)
        textView.setText(R.string.app_name)
        textView.setTextColor(ContextCompat.getColor(this, R.color.black))
    }

    private fun edittextPlayground(){
        val input : AppCompatEditText = findViewById(R.id.input_x)
        input.setHint(R.string.app_name)
        input.setText(R.string.app_name)
        val text = input.text.toString()
    }

    private fun edittextWithLabelPlayground(){
        val inputLabel: AppCompatEditText = findViewById(R.id.input_2x)
        val text = inputLabel.text.toString()
    }

    private fun imageviewPlayGround() {
        val image: AppCompatImageView = findViewById(R.id.image01)
        image.setImageResource(R.drawable.lion_image)
        //se consigo lo mismo que con el método setImageResource.
        image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.lion_image))
        image.setOnClickListener {
            Toast.makeText(this, "Mensaje flotante", Toast.LENGTH_LONG).show()
        }
    }

    private fun buttonPlayGround() {
        val button: AppCompatButton = findViewById(R.id.button01)
        button.text =""
        button.setOnClickListener {
            Snackbar.make(it, "Mensaje flotante", Snackbar.LENGTH_LONG).show()
        }
    }


}