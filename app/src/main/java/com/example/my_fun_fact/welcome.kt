package com.example.my_fun_fact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.my_fun_fact.databinding.ActivityWelcomeBinding

class welcome : AppCompatActivity() {
    var binding : ActivityWelcomeBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUp()
    }

    private fun setUp() {
        binding?.getStartedButton?.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}