package com.nttn.thirdcoding

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.nttn.permissionx.PermissionX
import com.nttn.primarysummary.chapter3_12_android.AndroidBaseActivity
import com.nttn.primarysummary.chapter2_grammar.BaseTypesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvKotlin.setOnClickListener(this)
        tvAndroid.setOnClickListener(this)
        btnTest.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            tvKotlin.id -> startActivity(Intent(this, BaseTypesActivity::class.java))
            tvAndroid.id -> startActivity(Intent(this, AndroidBaseActivity::class.java))
            btnTest.id -> testPermissionX()
        }
    }

    private fun testPermissionX() {
        PermissionX(this)
            .permissions(Manifest.permission.CALL_PHONE)
            .request { allGranted, deniedList ->
                if (allGranted) {
                    call()
                } else {
                    Toast.makeText(this, "You denied $deniedList", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun call() {
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }
}