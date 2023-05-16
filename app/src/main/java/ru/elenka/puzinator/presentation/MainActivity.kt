package ru.elenka.puzinator.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.elenka.puzinator.R
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // when button "Add" is pushed
        findViewById<FloatingActionButton>(R.id.floatingActionButtonAdd).setOnClickListener {

            // Create an Intent to start the Camera activity  so we can get Url of saved image back
            requestActivityForResult.launch(
                Intent(this, MyCamera::class.java)
            )
        }
    }

    // set contracts for getting back string with image Uri from Intent to MyCamera
    private val requestActivityForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { activityResult ->
            if (activityResult.resultCode == 1002) {
                val imageUri = activityResult.data?.getStringExtra("imageUri")
                Toast.makeText(baseContext, imageUri, Toast.LENGTH_LONG).show()

            }

        }
}