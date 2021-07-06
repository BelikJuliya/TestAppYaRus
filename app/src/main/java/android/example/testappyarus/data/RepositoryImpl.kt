package android.example.testappyarus.data

import android.example.testappyarus.data.IRepository
import android.example.testappyarus.data.rest.ApiService
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val sampleApiService: ApiService
) : IRepository {

    }

//class RepositoryImpl (
//    val sampleApiService: ApiService) : IRepository {
//
//}
