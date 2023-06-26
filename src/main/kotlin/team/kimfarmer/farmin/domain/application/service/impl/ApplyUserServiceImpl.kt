package team.kimfarmer.farmin.domain.application.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.kimfarmer.farmin.domain.application.service.ApplyUserService

@Service
@Transactional
class ApplyUserServiceImpl(
        private val
) : ApplyUserService {
    override fun execute(announcementId: Long) {
        TODO("Not yet implemented")
    }
}