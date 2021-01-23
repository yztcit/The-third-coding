package com.nttn.primarysummary.base

import android.app.Activity

/**
 * Description: ActivityCollector <br>
 * Version: 1.0     <br>
 * Update：2021/1/23   <br>
 * Created by Apple.
 */
object ActivityCollector {
    private val activities = ArrayList<Activity>()

    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    fun finishAll() {
        for (activity in activities) {
            activity.finish()
        }
        activities.clear()
    }
}