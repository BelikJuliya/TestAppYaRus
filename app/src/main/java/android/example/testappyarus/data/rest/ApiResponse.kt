package android.example.testappyarus.data.rest

data class ApiResponse<T>(
    val info: InfoX,
    val results: List<T>
)
