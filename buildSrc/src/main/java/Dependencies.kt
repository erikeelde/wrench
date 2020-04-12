// https://handstandsam.com/2018/02/11/kotlin-buildsrc-for-better-gradle-dependency-management/

object Versions {
    const val targetSdk = 28
    const val compileSdk = 28
    const val minSdk = 14

    const val appVersionCode = 14
    const val appVersionName = "1.0.13"

    const val wrench = "0.3"
    const val dagger = "2.27"

    const val arch_core = "1.1.1"
    const val junit = "4.13"
    const val mockito = "3.3.3"
    const val mockito_all = "1.10.19"
    const val dexmaker = "2.2.0"
    const val timber = "4.7.0"
    const val android_gradle_plugin = "4.0.0-beta04"
    const val hamcrest = "1.3"
    const val kotlin = "1.3.71"
    const val work = "1.0.0-alpha01"
    const val navigation = "2.2.1"
    const val kotlin_coroutines = "1.3.5"

    const val room = "2.2.5"
    const val lifecycle = "2.2.0"
    const val paging = "2.1.2"
    const val atsl = "1.1.2-alpha03"
    const val atsl_junit = "1.1.1"
    const val test = "1.2.0-alpha03"
    const val truth = "1.2.0"
    const val espresso = "3.1.0-beta02"

    const val robolectric = "4.3.1"
    const val constraint_layout = "2.0.0-beta3"
    const val appcompat = "1.1.0"
    const val cardview = "1.0.0"
    const val savestate = "1.0.0-alpha02"
    const val coordinatorlayout = "1.1.0"
    const val recyclerview = "1.1.0"
    const val material = "1.2.0-alpha01"
    const val annotation = "1.1.0"
    const val koin = "1.0.2"
}

object AndroidTestingSupportLibrary {
    const val runner = "androidx.test:runner:1.2.0"
    const val rules = "androidx.test:rules:1.2.0"
    const val monitor = "androidx.test:monitor:${Versions.atsl}"
    const val core = "androidx.test:core:1.2.0"
    const val truth = "androidx.test.ext:truth:${Versions.truth}"
    const val junit = "androidx.test.ext:junit:${Versions.atsl_junit}"
}

object Lifecycle {
    const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val core = "androidx.lifecycle:lifecycle-livedata-core:${Versions.lifecycle}"
    const val coreKtx = "androidx.lifecycle:lifecycle-livedata-core-ktx:${Versions.lifecycle}"
    const val runtime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val java8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val compiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
}

object Espresso {
    const val core = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val contrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
    const val intents = "androidx.test.espresso:espresso-intents:${Versions.espresso}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.room}"
    const val ktx = "androidx.room:room-ktx:${Versions.room}"
    const val compiler = "androidx.room:room-compiler:${Versions.room}"
    const val rxjava2 = "androidx.room:room-rxjava2:${Versions.room}"
    const val testing = "androidx.room:room-testing:${Versions.room}"
}

object Mockito {
    const val core = "org.mockito:mockito-core:${Versions.mockito}"
    const val android = "org.mockito:mockito-android:${Versions.mockito}"
    const val all = "org.mockito:mockito-all:${Versions.mockito_all}"
}

object Kotlin {
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val test = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val allopen = "org.jetbrains.kotlin:kotlin-allopen:${Versions.kotlin}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlin_coroutines}"
}

object Wrench {
    const val core = "com.izettle.wrench:wrench-core:${Versions.wrench}"
    const val prefs = "com.izettle.wrench:wrench-prefs:${Versions.wrench}"
    const val prefs_no_op = "com.izettle.wrench:wrench-prefs-no-op:${Versions.wrench}"
}

object Navigation {

    const val fragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val ui = "androidx.navigation:navigation-ui:${Versions.navigation}"

    const val fragmentKotlin = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val uiKotlin = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    const val testing = "androidx.navigation:navigation-testing:${Versions.navigation}"

    const val safeArgsPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
}

object Oss {
    const val plugin = "com.google.gms:oss-licenses:0.9.2"
    const val runtime = "com.google.android.gms:play-services-oss-licenses:17.0.0"
}

object Libs {
    val dagger = Dagger
    val wrench = Wrench
    val lifecycle = Lifecycle
    val support = Support
    val mockito = Mockito
    val androidTestingSupportLibrary = AndroidTestingSupportLibrary
    val espresso = Espresso
    val room = Room
    val kotlin = Kotlin
    val navigation = Navigation
    val oss = Oss
    val koin = Koin

    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"

    const val paging = "androidx.paging:paging-runtime:${Versions.paging}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"

    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"

    const val junit = "junit:junit:${Versions.junit}"

    const val stetho = "com.facebook.stetho:stetho:1.5.1"

}

object Dagger {
    const val runtime = "com.google.dagger:dagger:${Versions.dagger}"
    const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val androidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val androidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
}

object Support {
    const val annotations = "androidx.annotation:annotation:${Versions.annotation}"
    const val app_compat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    const val coordinatorlayout = "androidx.coordinatorlayout:coordinatorlayout:${Versions.coordinatorlayout}"
    const val design = "com.google.android.material:material:${Versions.material}"
    const val core_utils = "androidx.legacy:legacy-appcompat-core-utils:${Versions.appcompat}"
    const val savestate = "androidx.savedstate:savedstate${Versions.savestate}"
}

object Koin {
    const val androidx = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val koinTest = "org.koin:koin-test:${Versions.koin}"
}
