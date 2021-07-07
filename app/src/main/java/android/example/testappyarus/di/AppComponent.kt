package android.example.testappyarus.di

import android.app.Application
import android.example.testappyarus.presentation.characterFlow.CharacterListFragment
import android.example.testappyarus.presentation.common.MainActivity
import android.example.testappyarus.presentation.common.YarusApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [(AndroidInjectionModule::class), (AndroidSupportInjectionModule::class),
        (AppModule::class), (DataModule::class), (ViewModelModule::class), (NetworkModule::class)]
)
interface AppComponent : AndroidInjector<YarusApp> {

    override fun inject(application: YarusApp)

    //fun inject(activity: MainActivity)

    fun inject(characterListFragment: CharacterListFragment)


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}