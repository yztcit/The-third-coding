package com.nttn.primarysummary.chapter3_12_android

import android.os.Bundle
import android.view.View
import com.nttn.primarysummary.R
import com.nttn.primarysummary.base.BaseActivity
import kotlinx.android.synthetic.main.activity_android_base.*

/**
 * Description:     <br>
 * Version: 1.0     <br>
 * Update：2021/1/23   <br>
 * Created by Apple.
 */
class AndroidBaseActivity : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_base)
        back.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            back.id -> finish()
        }
    }
}