package com.nttn.primarysummary.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * Description:  BaseActivity  <br>
 * Version: 1.0     <br>
 * Update：2021/1/23   <br>
 * Created by Apple.
 */
open class BaseActivity : AppCompatActivity(){
    private val TAG = BaseActivity::class.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ${javaClass.simpleName}")
        ActivityCollector.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ${javaClass.simpleName}")
        ActivityCollector.removeActivity(this)
    }
}