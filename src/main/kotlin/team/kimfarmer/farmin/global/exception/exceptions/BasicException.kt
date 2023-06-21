package team.kimfarmer.farmin.global.exception.exceptions

import team.kimfarmer.farmin.global.exception.ErrorCode

open class BasicException(val errorCode: ErrorCode): RuntimeException()