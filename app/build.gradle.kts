plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    namespace = "com.jyldyzferr.travelapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jyldyzferr.travelapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

    //Room
    ksp(libs.room.compiler)
    ksp(libs.room.ktx.compiler)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)

    implementation(libs.lottie.compose)

    //Coil
    implementation(libs.coil.compose)

    //Coroutines
    implementation(libs.kotlinx.coroutines.android)

    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Pager
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)

    //Navigation
    val nav_version = "2.6.0"
    implementation(libs.navigation.compose)
    implementation(libs.hilt.navigation.compose)

    implementation ("me.onebone:toolbar-compose:2.3.2")
    implementation ("com.google.accompanist:accompanist-insets:0.17.0")


    implementation(libs.foundation)

    implementation(libs.material3)
    implementation(libs.multidatepicker)



    implementation(libs.parse.android)
    implementation(libs.core.ktx)

    val bom = libs.androidx.compose.bom
    implementation(platform(bom))
    androidTestImplementation(platform(bom))
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.testManifest)
    androidTestImplementation(libs.androidx.compose.ui.test)

    implementation(libs.androidx.material.icons.extended)

}