package team.kimfarmer.farmin.domain.farm.exception

import team.kimfarmer.farmin.global.exception.ErrorCode
import team.kimfarmer.farmin.global.exception.exceptions.BasicException

class FarmNotFoundException : BasicException(ErrorCode.FARM_NOT_FOUND) {
}