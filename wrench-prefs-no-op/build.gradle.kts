plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}
android {
    compileSdkVersion(Versions.compileSdk)

    defaultConfig {
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    lintOptions {
        baselineFile = file("lint-baseline.xml")
        isCheckReleaseBuilds = true
        isAbortOnError = true
        isWarningsAsErrors = true
        lintConfig = File("../lint.xml")
    }
}

dependencies {
    testImplementation("androidx.test:core:1.2.0")
    testImplementation("androidx.test.ext:truth:1.2.0")
    testImplementation("androidx.test:rules:1.2.0")
    testImplementation("androidx.test:runner:1.2.0")
    testImplementation("androidx.test.ext:junit:1.1.1")
    testImplementation("org.robolectric:robolectric:4.3.1")

    implementation("com.izettle.wrench:wrench-core:0.3")
    implementation("androidx.annotation:annotation:1.1.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.72")
    implementation("androidx.core:core-ktx:1.3.0")
}

apply(rootProject.file("gradle/gradle-mvn-push.gradle"))
