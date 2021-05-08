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

            if (emailText == "krysnkem@gmail.com" && passwordText == "password123"){
                val intent = Intent(this,MainActivity::class.java )
                Toast.makeText(this, "Welcome Christian",Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }else
                Toast.makeText(this, "Enter the correct email and password",Toast.LENGTH_SHORT).show()
        }
        binding?.cancelButton?.setOnClickListener(){
            binding?.emailEdittext?.text?.clear()
            binding?.passwordEdittext?.text?.clear()
        }
    }
}