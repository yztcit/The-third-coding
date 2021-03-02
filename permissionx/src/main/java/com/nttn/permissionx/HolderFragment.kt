package com.nttn.permissionx

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

/**
 * Description:     <br>
 * Version: 1.0     <br>
 * Update：2021/2/28   <br>
 * Created by Apple.
 */
typealias PermissionCallback = (Boolean, List<String>) -> Unit
class HolderFragment : Fragment() {
    private var callback: PermissionCallback? = null

    fun requestNow(cb: PermissionCallback, vararg permissions: String) {
        callback = cb
        requestPermissions(permissions, 1)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
        grantResults: IntArray) {
        when (requestCode) {
            1 -> {
                val deniedList = ArrayList<String>()
                for ((index, result) in grantResults.withIndex()) {
                    if (result != PackageManager.PERMISSION_GRANTED) {
                        deniedList.add(permissions[index])
                    }
                }
                val allGranted = deniedList.isEmpty()
                callback?.let { it(allGranted, deniedList) }
            }
            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }
}