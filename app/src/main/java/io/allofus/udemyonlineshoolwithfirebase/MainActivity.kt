package io.allofus.udemyonlineshoolwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun register(v: View) {
        startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
    }

    fun login(v: View) {
        startActivity(Intent(this@MainActivity, LoginActivity::class.java))
    }

}
