package team.kimfarmer.farmin.domain.announcement.exception

import team.kimfarmer.farmin.global.exception.ErrorCode
import team.kimfarmer.farmin.global.exception.exceptions.BasicException

class AnnouncementNotFoundException : BasicException(ErrorCode.USER_NOT_FOUND)