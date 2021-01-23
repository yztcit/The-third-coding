package com.nttn.primarysummary.chapter2_grammar

import android.util.Log

/**
 * Description:     <br>
 * Version: 1.0     <br>
 * Update：2021/1/23   <br>
 * Created by Apple.
 */
class Student(private val sno: String = "", private val grade: Double = 0.0, name: String = "", age: Int = 0) : Person(name, age), IStudy {
    private val tag = Student::class.simpleName
    override fun readBooks() {
        Log.d(tag, "$name is $age, and $name is reading.")
    }

    override fun doHomework() {
        Log.d(tag, "$name's sno is $sno, $name got $grade, and $name is doing homework.")
    }
}