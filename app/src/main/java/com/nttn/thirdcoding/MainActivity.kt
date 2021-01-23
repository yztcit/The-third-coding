package com.nttn.thirdcoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nttn.primarysummary.chapter3_12_android.AndroidBaseActivity
import com.nttn.primarysummary.chapter2_grammar.BaseTypesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvKotlin.setOnClickListener(this)
        tvAndroid.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            tvKotlin.id -> startActivity(Intent(this, BaseTypesActivity::class.java))
            tvAndroid.id -> startActivity(Intent(this, AndroidBaseActivity::class.java))
        }
    }
}