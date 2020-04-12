plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs")
    id("com.google.gms.oss.licenses.plugin")
}

androidExtensions {
    isExperimental = true
}

android {
    buildFeatures {
        dataBinding = true
    }

    compileSdkVersion(Versions.compileSdk)
    defaultConfig {
        applicationId = "com.example.wrench"
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = Versions.appVersionCode
        versionName = Versions.appVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            versionNameSuffix = " debug"
            applicationIdSuffix = ".debug"
        }
    }
    lintOptions {
        baselineFile = file("lint-baseline.xml")
        isCheckReleaseBuilds = true
        isAbortOnError = true
        isWarningsAsErrors = true
        lintConfig = File("../lint.xml")
    }
    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
}

dependencies {
    testImplementation(Libs.mockito.core)

    testImplementation(Libs.androidTestingSupportLibrary.core)
    testImplementation(Libs.androidTestingSupportLibrary.truth)
    testImplementation(Libs.androidTestingSupportLibrary.rules)
    testImplementation(Libs.androidTestingSupportLibrary.runner)
    testImplementation(Libs.androidTestingSupportLibrary.junit)
    testImplementation(Libs.robolectric)

    implementation(Libs.support.app_compat)
    implementation(Libs.support.design)
    implementation(Libs.support.coordinatorlayout)
    implementation(Libs.constraint_layout)
    implementation(Libs.lifecycle.extensions)

    implementation(Libs.navigation.fragmentKotlin)
    implementation(Libs.navigation.uiKotlin)

//    implementation (Libs.wrench.core)
//    debugImplementation (Libs.wrench.prefs)
//    releaseImplementation (Libs.wrench.prefs_no_op)

    implementation(Libs.wrench.core)
    debugImplementation(Libs.wrench.prefs)
    releaseImplementation(Libs.wrench.prefs_no_op)

    implementation(project(":wrench-livedata"))

    implementation(project(":wrench-service"))
    debugImplementation(project(":wrench-service-prefs"))
    releaseImplementation(project(":wrench-service-prefs-no-op"))

    implementation(Libs.kotlin.stdlib)
    implementation(Libs.kotlin.coroutinesAndroid)

    implementation(Libs.dagger.runtime)
    kapt(Libs.dagger.compiler)
    implementation(Libs.dagger.androidSupport)
    kapt(Libs.dagger.androidProcessor)

    implementation(Libs.oss.runtime)
}
