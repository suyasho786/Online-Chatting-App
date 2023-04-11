package com.example.ganesh_chating_app

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    private lateinit var edEmail : EditText
    private lateinit var edPassword : EditText

    private lateinit var btnSignup : Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var edname:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        edname=findViewById(R.id.edName)
        mAuth = FirebaseAuth.getInstance()
        edEmail=findViewById(R.id.edEmail)
        edPassword=findViewById(R.id.edPassword)
        btnSignup=findViewById(R.id.signUp)
        btnSignup.setOnClickListener{
            val email = edEmail.text.toString()
            val password=edPassword.text.toString()
            signUp(email,password)
        }
    }

    private fun signUp(email: String, password: String) {
        //logic of creating user
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent= Intent(this@SignUp,MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this@SignUp,"some error occured",Toast.LENGTH_SHORT).show()
                }
            }
    }
}