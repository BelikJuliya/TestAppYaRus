package android.example.testappyarus.di

//import android.example.testappyarus.di.NetworkModule
import android.example.testappyarus.data.IRepository
import android.example.testappyarus.data.RepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

//@Module(includes = [NetworkModule::class])
@Module()
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideRepository(repositoryImpl: RepositoryImpl) : IRepository

}