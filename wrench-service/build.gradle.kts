plugins {
    id("com.android.library")
    kotlin("android")
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    testImplementation("junit:junit:4.13")
    testImplementation("org.mockito:mockito-core:3.3.3")
    testImplementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.72")

    implementation("com.izettle.wrench:wrench-core:0.3")
    debugImplementation(project(":wrench-service-prefs"))
    releaseImplementation(project(":wrench-service-prefs-no-op"))
    implementation("androidx.annotation:annotation:1.1.0")

    api(project(":wrench-service-provider"))
    implementation("androidx.core:core-ktx:1.4.0-alpha01")
}

// The api of this module should be discussed before any potential release
// apply from: rootProject.file('gradle/gradle-mvn-push.gradle')
