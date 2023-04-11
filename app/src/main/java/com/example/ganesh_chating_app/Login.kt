package com.example.ganesh_chating_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var edEmail :EditText
    private lateinit var edPassword :EditText
    private lateinit var btnLogin :Button
    private lateinit var btnSignup :Button
    private lateinit var mAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()


        edEmail=findViewById(R.id.edEmail)
        edPassword=findViewById(R.id.edPassword)
        btnLogin=findViewById(R.id.btnLogin)
        btnSignup=findViewById(R.id.signUp)

        btnSignup.setOnClickListener{
            val intent=Intent(this,SignUp::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener{
            val email = edEmail.text.toString()
            val password=edPassword.text.toString()
            login(email,password)
        }
    }

    private fun login(email: String, password: String) {
        //logic for login
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent= Intent(this@Login,MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this@Login,"User not exist",Toast.LENGTH_SHORT).show()
                }
            }
    }
}