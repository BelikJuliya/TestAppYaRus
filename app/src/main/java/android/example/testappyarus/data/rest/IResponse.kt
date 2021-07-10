package android.example.testappyarus.data.rest

interface IResponse<T> {

    fun toDomainObject(): T

    fun getPage(): Int
}