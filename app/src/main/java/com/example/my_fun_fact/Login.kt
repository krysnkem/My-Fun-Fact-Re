package com.example.my_fun_fact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.my_fun_fact.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    var binding :ActivityLoginBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUp()
    }


    fun setUp(){


        binding?.nextButton?.setOnClickListener(){
            val emailText =   binding?.emailEdittext?.text.toString()
            val passwordText =   binding?.passwordEdittext?.text.toString()
            val email = "anyemail@gmail.com"
            val password = "password123"

            if (emailText == email  && passwordText == password){
                val intent = Intent(this,MainActivity::class.java )
                Toast.makeText(this, "Welcome User",Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }else
                Toast.makeText(this, "Enter the email: $email and password: $password",Toast.LENGTH_LONG).show()
        }
        binding?.cancelButton?.setOnClickListener(){
            binding?.emailEdittext?.text?.clear()
            binding?.passwordEdittext?.text?.clear()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}