package team.kimfarmer.farmin.domain.farm.utils

import team.kimfarmer.farmin.domain.farm.domain.entity.Farm

interface FarmUtils {
    fun findByFarmIdx(idx: Long): Farm
}