package android.example.testappyarus.presentation.common

import android.example.testappyarus.di.AppComponent
import android.example.testappyarus.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class YarusApp: DaggerApplication() {
    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder().application(this).build()
        return appComponent
    }
}