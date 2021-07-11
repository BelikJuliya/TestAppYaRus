package android.example.testappyarus.di

import android.app.Application
import android.example.testappyarus.presentation.characterFlow.details.CharacterDetailsFragment
import android.example.testappyarus.presentation.characterFlow.list.CharacterListFragment
import android.example.testappyarus.presentation.common.YarusApp
import android.example.testappyarus.presentation.episodesFlow.details.EpisodeDetailsFragment
import android.example.testappyarus.presentation.episodesFlow.list.EpisodesListFragment
//import android.example.testappyarus.presentation.episodesFlow.list.EpisodesListFragment
import android.example.testappyarus.presentation.locationFlow.details.LocationDetailsFragment
import android.example.testappyarus.presentation.locationFlow.list.LocationListFragment
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

    fun inject(characterListFragment: CharacterListFragment)

    fun inject(characterDetailsFragment: CharacterDetailsFragment)

    fun inject(locationsListFragment: LocationListFragment)

    fun inject(locationDetailsFragment: LocationDetailsFragment)

    fun inject(episodesListFragment: EpisodesListFragment)

    fun inject(episodeDetailsFragment: EpisodeDetailsFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}