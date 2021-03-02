package com.nttn.permissionx

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

/**
 * Description:     </br>
 * Version: 1.0     <br>
 * Update：2021/2/28   <br>
 * Created by Apple.
 */
class PermissionX {
    private val TAG = "HolderFragment"

    private var activity: FragmentActivity? = null
    private var fragment: Fragment? = null

    private var permissions: Array<out String>? = null

    constructor(fragment: Fragment) {
        this.fragment = fragment
    }

    constructor(activity: FragmentActivity) {
        this.activity = activity
    }

    fun permissions(vararg permissions: String) : PermissionX{
        this.permissions = permissions
        return this
    }

    fun request(callback: PermissionCallback) {
        var fragmentManager: FragmentManager? = null
        if (activity != null) {
            fragmentManager = activity!!.supportFragmentManager
        }
        if (fragment != null) {
            fragmentManager = fragment!!.childFragmentManager
        }
        val existedFragment = fragmentManager!!.findFragmentByTag(TAG)
        val fragment = if (existedFragment != null) {
            existedFragment as HolderFragment
        } else {
            val holderFragment = HolderFragment()
            fragmentManager.beginTransaction().add(holderFragment, TAG).commitNow()
            holderFragment
        }
        fragment.requestNow(callback, *permissions!!)
    }
}