package team.kimfarmer.farmin.global.exception

enum class ErrorCode(
    val message: String,
    val status: Int
) {
    UNAUTHORIZED("권한이 없습니다.", 401),
    EXPIRED_TOKEN("만료된 토큰입니다.", 401),

    USER_NOT_FOUND("유저를 찾을 수 없수 없습니다.", 404),

    USER_ALREADY_EXIST("이미 존재하는 유저입니다.", 409),

    INTERNAL_SERVER_ERROR("서버 내부 에러", 500),
}