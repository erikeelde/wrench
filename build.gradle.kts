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
    id("com.github.ben-manes.versions") version "0.27.0"
    id("se.eelde.build-optimizations") version "0.1.2"

}

allprojects {
    Repos.addRepos(repositories)
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}