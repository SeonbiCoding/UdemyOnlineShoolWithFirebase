package io.allofus.udemyonlineshoolwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    var user_email: EditText? = null
    var user_password: EditText? = null
    var register_btn: Button? = null
    var firebaseAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        user_email = findViewById(R.id.et_register_email)
        user_password = findViewById(R.id.et_register_password)
        register_btn = findViewById(R.id.register)
        firebaseAuth = FirebaseAuth.getInstance()

        register_btn?.setOnClickListener {

            registerUser()
        }
    }

    private fun registerUser() {

        val email = user_email?.text.toString().trim()
        val password = user_password?.text.toString().trim()

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(applicationContext, "These fields can not be empty", Toast.LENGTH_SHORT).show()
        } else {
            firebaseAuth?.createUserWithEmailAndPassword(email, password)?.addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(applicationContext, "Register is completed", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                } else {
                    val error = it.exception?.message
                    Toast.makeText(applicationContext, "Error : $error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
