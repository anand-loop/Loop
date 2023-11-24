@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.anandj.loop"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.anandj.loop"
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Android
    implementation(libs.ax.core.ktx)
    implementation(libs.ax.lifecycle.runtime.ktx)

    // Compose
    implementation(libs.ax.activity.compose)
    implementation(platform(libs.ax.compose.bom))
    implementation(libs.ax.compose.ui)
    implementation(libs.ax.compose.ui.graphics)
    implementation(libs.ax.compose.ui.tooling.preview)
    implementation(libs.ax.compose.material3)
    debugImplementation(libs.ax.compose.ui.tooling)
    debugImplementation(libs.ax.compose.ui.test.manifest)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.moshi)

    // Other
    implementation(libs.coil)
    implementation(libs.timber)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ax.test.ext.junit)
    androidTestImplementation(libs.ax.test.espresso.core)
    androidTestImplementation(platform(libs.ax.compose.bom))
    androidTestImplementation(libs.ax.compose.ui.test.junit4)
}
