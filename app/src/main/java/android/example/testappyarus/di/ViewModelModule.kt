package android.example.testappyarus.di

import android.example.testappyarus.presentation.characterFlow.details.CharacterDetailsViewModel
import android.example.testappyarus.presentation.characterFlow.list.CharacterViewModel
import android.example.testappyarus.presentation.common.ViewModelFactory
import android.example.testappyarus.presentation.common.ViewModelKey
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
    internal abstract fun characterViewModel(viewModel: CharacterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CharacterDetailsViewModel::class)
    internal abstract fun characterDetailsViewModel(viewModel: CharacterDetailsViewModel): ViewModel
}