package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        auth = Firebase.auth


        findViewById<Button>(R.id.btnSignup).setOnClickListener{
            signUpUser()
        }
    }
    private fun signUpUser(){
        val email: String = findViewById<EditText>(R.id.etEmailAddress).text.toString()
        val password: String = findViewById<EditText>(R.id.etPassword).text.toString()
        // val confirmPassword: String = findViewById<EditText>(R.id.etConfirmPassword).text.toString()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG1", "createUserWithEmail:success")
//                    val user = auth.currentUser

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG1", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, email,
                        Toast.LENGTH_SHORT).show()

                }
            }

        btnLogIn.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}