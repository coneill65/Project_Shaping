package com.example.projectshaping

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "ShowToast")

    enum class LoginSuccess constructor(val intValue: Int){
        login(1),
        password(2),
        success(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enteredUsername = findViewById<EditText>(R.id.Username)
        val enteredPassword = findViewById<EditText>(R.id.Password)
        val btnProfile = findViewById<Button>(R.id.button)

        btnProfile.setOnClickListener{
            when (CheckLogin(enteredUsername.text.toString(), enteredPassword.text.toString())){
                LoginSuccess.login -> {
                    Toast.makeText(applicationContext, "Invalid Login, Please retry.", Toast.LENGTH_LONG).show()
                    enteredUsername.requestFocus()
                }
                LoginSuccess.password -> {
                    Toast.makeText(applicationContext, "Invalid Password, Please retry.", Toast.LENGTH_LONG).show()
                    enteredPassword.requestFocus()
                }
                else -> {
                    Toast.makeText(applicationContext, "Login successful.", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun CheckLogin(txtLogin: String, txtPassword: String): LoginSuccess {
        val holdLogin = "Colin"
        val holdPass = "password"

        return when {
            holdLogin != txtLogin -> {
                LoginSuccess.login
            }
            holdPass != txtPassword -> {
                LoginSuccess.password
            }
            else -> {
                LoginSuccess.success
            }
        }
    }
}