package team.kimfarmer.farmin.domain.farm.utils.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import team.kimfarmer.farmin.domain.farm.domain.entity.Farm
import team.kimfarmer.farmin.domain.farm.domain.repository.FarmRepository
import team.kimfarmer.farmin.domain.farm.exception.FarmNotFoundException
import team.kimfarmer.farmin.domain.farm.utils.FarmUtils

@Component
class FarmUtilsImpl(
        private val farmRepository: FarmRepository
) : FarmUtils {
    override fun findByFarmIdx(idx: Long): Farm =
            farmRepository.findByIdOrNull(idx) ?: throw FarmNotFoundException()
}