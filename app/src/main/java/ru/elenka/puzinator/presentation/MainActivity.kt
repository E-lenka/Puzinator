package ru.elenka.puzinator.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.elenka.puzinator.R
import android.content.Intent


class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onAddButtonClick(view: View) {
        Toast.makeText(applicationContext, "Добавь фото шедевра!",Toast.LENGTH_LONG).show()
        // Create an Intent to start the second activity

      val cameraIntent = Intent(this, MyCamera::class.java)

       //  Start the new activity.

       startActivity(cameraIntent)
    }
}