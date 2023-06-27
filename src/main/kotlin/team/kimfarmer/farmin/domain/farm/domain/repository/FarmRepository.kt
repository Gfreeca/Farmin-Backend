package team.kimfarmer.farmin.domain.farm.domain.repository

import org.springframework.data.repository.CrudRepository
import team.kimfarmer.farmin.domain.farm.domain.entity.Farm
import team.kimfarmer.farmin.domain.user.domain.entity.User

interface FarmRepository : CrudRepository<Farm, Long> {
}