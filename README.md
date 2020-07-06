## 第三行代码
> Kotlin学习

### 1. gradle

#### 1.1.  buildSrc 统筹依赖管理

> 随着项目越来越大，工程中的module越来越多，依赖的三方库也越来越多。一般会在一个统一的地方管理这些依赖，比如谷歌官方推荐的 `ext` 变量，在根module的build.gradle中，使用 ext 集中申明各种第三方库的版本，如下：

```groovy
//Define versions
ext{
	//sdk and tools
	minSdkVersion 21
	targetSdkVersion 28
	buildToolsVersion = '28.0.3'
	
	//App dependencies
	supportLibraryVersion = '28.0.3'
	junitVerison = '4.1.2'
}
```
>  然后在子module中，引用这些版本信息。

但是这种写法 ***不支持AS的自动补充功能，也无法使用代码自动跟踪***，因此可以考虑使用*buildSrc*。
> buildSrc 是 Android 项目中一个比较特殊的project，在 buildSrc 中可以编写 Groovy 语言，但是现在谷歌越来越推荐使用 Kotlin 来编写编译语句。

**buildSrc 使用步骤：**

***1. 先在根路径下创建目录 buildSrc ，这个工程中只能有一个，名字必须是buildSrc；***
***2. 接着在 buildSrc 目录中创建 `build.gradle.kts` 文件，并添加 Kotlin 插件；***

```groovy
//build.gradle.kts
import org.gradle.kotlin.dsl.`kotlin-dsl`

repositories{
    jcenter()
}

plugins {
    `kotlin-dsl`
}
```
***3. 然后再在 buildSrc 中创建 `src/main/java` 目录，并创建 Kotlin 文件，在创建的 Kotlin 文件中创建两个 单例类（Object），如 Object Versions，Object Dependenices；分别用来管理工程中的版本信息和三方依赖库。***
***4. 在创建的单例类中分别定义变量，如下所示：***

```kotlin
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
```
***5. 最后在 module 中引用。***

```groovy
dependencies {
    implementation fileTree(dir: "libs", include: ["*.jar"])
    implementation Dependencies.kotlinStdLib
    implementation Dependencies.coreKtx

    implementation Dependencies.appCompat
    implementation Dependencies.constraintlayout

    testImplementation Dependencies.junit
    androidTestImplementation Dependencies.xJunit
    androidTestImplementation Dependencies.espresso

}
```

