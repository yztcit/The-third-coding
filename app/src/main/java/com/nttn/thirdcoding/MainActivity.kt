package com.nttn.thirdcoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.nttn.primarysummary.BaseTypesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            textView.id -> startActivity(Intent(
                this, BaseTypesActivity::class.java))
        }
    }
}