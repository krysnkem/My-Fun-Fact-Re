package com.example.my_fun_fact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.my_fun_fact.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private var binding :  ActivityDetailBinding? = null
    private var logo = 0
    private var name:String? = null
    private var detail :String?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        logo = intent.getIntExtra(FactAdapter.LOGO_EXTRA, 0)
        name = intent.getStringExtra(FactAdapter.NAME_EXTRA)
        detail = intent.getStringExtra(FactAdapter.FACT_EXTRA)
        setUpFactDetail()
    }

    private fun  setUpFactDetail(){
        binding?.detailTextView?.text = detail
        binding?.logoImageView?.setImageResource(logo)
        title = name
        binding?.textTop?.text = "Fun Fact about $name language."
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}