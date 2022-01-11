package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth


        findViewById<Button>(R.id.btnlLogin).setOnClickListener{
            signUpUser()

        }
    }
    private fun signUpUser(){
        val email: String = findViewById<EditText>(R.id.etlEmailAddress).text.toString()
        val password: String = findViewById<EditText>(R.id.etlPassword).text.toString()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG2", "signInWithEmail:success")
                   // val user = auth.currentUser

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG2", "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }

        val signupTextButton = findViewById<TextView>(R.id.btnSignUpFromLIPage)
        signupTextButton.setOnClickListener{
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

    }
}