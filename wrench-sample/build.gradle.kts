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
    testImplementation("org.mockito:mockito-core:3.3.3")

    testImplementation("androidx.test:core:1.2.0")
    testImplementation("androidx.test.ext:truth:1.2.0")
    testImplementation("androidx.test:rules:1.2.0")
    testImplementation("androidx.test:runner:1.2.0")
    testImplementation("androidx.test.ext:junit:1.1.1")
    testImplementation("org.robolectric:robolectric:4.3.1")

    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("com.google.android.material:material:1.2.0-alpha01")
    implementation("androidx.coordinatorlayout:coordinatorlayout:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-beta3")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    implementation("androidx.navigation:navigation-fragment-ktx:2.2.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.2.2")

//    implementation (Libs.wrench.core)
//    debugImplementation (Libs.wrench.prefs)
//    releaseImplementation (Libs.wrench.prefs_no_op)

    implementation("com.izettle.wrench:wrench-core:0.3")
    debugImplementation("com.izettle.wrench:wrench-prefs:0.3")
    releaseImplementation("com.izettle.wrench:wrench-prefs-no-op:0.3")

    implementation(project(":wrench-livedata"))

    implementation(project(":wrench-service"))
    debugImplementation(project(":wrench-service-prefs"))
    releaseImplementation(project(":wrench-service-prefs-no-op"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.72")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7")

    implementation("com.google.dagger:dagger:2.28")
    kapt("com.google.dagger:dagger-compiler:2.28")
    implementation("com.google.dagger:dagger-android-support:2.28")
    kapt("com.google.dagger:dagger-android-processor:2.28")

    implementation("com.google.android.gms:play-services-oss-licenses:17.0.0")
    implementation("androidx.core:core-ktx:1.4.0-alpha01")
}
