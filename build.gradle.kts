import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    Repos.addRepos(repositories)

    dependencies {

        classpath(Libs.android_gradle_plugin)
        classpath(Libs.kotlin.plugin)
        classpath(Libs.navigation.safeArgsPlugin)
        classpath(Libs.oss.plugin)
    }
}

plugins {
    id("com.github.ben-manes.versions") version "0.28.0"
    id("se.eelde.build-optimizations") version "0.1.2"
    id("com.github.plnice.canidropjetifier") version "0.5"
}

allprojects {
    Repos.addRepos(repositories)
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
}