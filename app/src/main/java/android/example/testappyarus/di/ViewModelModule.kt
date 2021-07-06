package android.example.testappyarus.di

import android.example.testappyarus.presentation.CharacterViewModel
import android.example.testappyarus.presentation.ViewModelFactory
import android.example.testappyarus.presentation.ViewModelKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CharacterViewModel::class)
    internal abstract fun splashViewModel(viewModel: CharacterViewModel): ViewModel
}