package com.example.my_fun_fact

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.my_fun_fact.R.color.deepPurple
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
        binding?.detailTextView?.setTextColor(Color.DKGRAY)
        binding?.logoImageView?.setImageResource(logo)
        title = name
        binding?.textTop?.text = getString(R.string.return_text, name)
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}