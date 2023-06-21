package team.kimfarmer.farmin.global.exception

enum class ErrorCode(
    val message: String,
    val status: Int
) {
    INTERNAL_SERVER_ERROR("서버 내부 에러", 500),
}