/**
 * Created by Apple on 2020/7/6.
 * Desc: 管理项目依赖
 */

/**
 * 统一管理项目中的版本信息
 */
object Versions {
    // Build Config
    const val buildGradle = "4.0.0"
    const val compileSdk = 30
    const val buildToolsVersion = "30.0.0"
    const val minSdk = 19
    const val targetSdk = 30

    // App Version
    const val appVersionCode = 1
    const val appVersionName = "1.0.0.0"

    // Kotlin
    const val kotlin = "1.3.72"
    const val coreKtx = "1.3.0"

    // Testing
    const val junit = "4.12"
    const val xJunit = "1.1.1"
    const val espresso = "3.2.0"

    // all kinds of libs
    const val support = "30.0.0"
    const val xAppcompat = "1.1.0"
    const val xConstraintlayout = "1.1.3"
}

/**
 * 统一管理项目中的依赖库
 */
object Dependencies{
    // Build
    const val buildGradle = "com.android.tools.build:gradle:${Versions.buildGradle}"

    // Kotlin
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

    // Testing
    const val junit = "junit:junit:${Versions.junit}"
    const val xJunit = "androidx.test.ext:junit:${Versions.xJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    // all kinds of libs
    const val appCompat = "androidx.appcompat:appcompat:${Versions.xAppcompat}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.xConstraintlayout}"
}