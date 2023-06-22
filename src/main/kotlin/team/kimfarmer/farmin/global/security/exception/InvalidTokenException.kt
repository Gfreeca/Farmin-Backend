package team.kimfarmer.farmin.global.security.exception

import team.kimfarmer.farmin.global.exception.ErrorCode
import team.kimfarmer.farmin.global.exception.exceptions.BasicException


class InvalidTokenException : BasicException(ErrorCode.UNAUTHORIZED) {
}