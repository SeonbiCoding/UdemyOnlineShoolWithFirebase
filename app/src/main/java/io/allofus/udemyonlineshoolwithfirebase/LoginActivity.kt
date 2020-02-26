package io.allofus.udemyonlineshoolwithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    var user_email: EditText? = null
    var user_password: EditText? = null
    var login_btn: Button? = null
    var firebaseAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        user_email = findViewById(R.id.et_login_email)
        user_password = findViewById(R.id.et_login_password)
        login_btn = findViewById(R.id.login)
        firebaseAuth = FirebaseAuth.getInstance()

        login_btn?.setOnClickListener {
            loginUser()
        }

    }

    private fun loginUser() {

        var email: String = user_email?.text.toString().trim()
        var password: String = user_password?.text.toString().trim()

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(applicationContext, "These fields can not be empty", Toast.LENGTH_SHORT)
                .show()
        } else {
            firebaseAuth?.signInWithEmailAndPassword(email, password)?.addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(applicationContext, "success", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@LoginActivity, DashboardActivity::class.java))
                } else {
                    var error = it.exception?.message
                    Toast.makeText(applicationContext, "Error : $error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}

