package com.step2hell.android

import android.content.ContextWrapper
import android.content.pm.PackageInfo
import android.os.Build

private val ContextWrapper.packageInfo: PackageInfo
    get() = packageManager.getPackageInfo(packageName, 0)

val ContextWrapper.appName: CharSequence
    get() = applicationInfo.loadLabel(packageManager)

val ContextWrapper.versionName: String
    get() = packageInfo.versionName

@Suppress("DEPRECATION")
val ContextWrapper.versionCode: Long
    get() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) packageInfo.longVersionCode
        else packageInfo.versionCode.toLong()
