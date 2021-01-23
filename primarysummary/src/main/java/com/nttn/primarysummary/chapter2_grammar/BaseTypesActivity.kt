package com.nttn.primarysummary.chapter2_grammar

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.nttn.primarysummary.R
import kotlinx.android.synthetic.main.activity_base_types.*

/**
 * Desc: 基本数据类型
 */
class BaseTypesActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_types)
        back.setOnClickListener(this)
        tv_study.setOnClickListener(this)
    }

    private fun doStudy(study: IStudy?) {
        study?.let {
            it.readBooks()
            it.doHomework()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            back.id -> onBackPressed()

            tv_study.id -> {
                val student = Student(name = "Tom", age = 19)
                doStudy(student)
            }
        }

    }

}