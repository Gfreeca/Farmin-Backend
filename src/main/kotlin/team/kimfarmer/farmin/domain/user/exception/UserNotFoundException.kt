package team.kimfarmer.farmin.domain.user.exception

import team.kimfarmer.farmin.global.exception.ErrorCode
import team.kimfarmer.farmin.global.exception.exceptions.BasicException

class UserNotFoundException : BasicException(ErrorCode.USER_NOT_FOUND) {
}