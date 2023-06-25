package team.kimfarmer.farmin.domain.user.exception

import team.kimfarmer.farmin.global.exception.ErrorCode
import team.kimfarmer.farmin.global.exception.exceptions.BasicException

class UserAlreadyExistException : BasicException(ErrorCode.USER_ALREADY_EXIST)