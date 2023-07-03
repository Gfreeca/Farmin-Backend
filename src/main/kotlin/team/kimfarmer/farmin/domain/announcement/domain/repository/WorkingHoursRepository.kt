package team.kimfarmer.farmin.domain.announcement.domain.repository

import org.springframework.data.repository.CrudRepository
import team.kimfarmer.farmin.domain.announcement.domain.entity.WorkingHours

interface WorkingHoursRepository : CrudRepository<WorkingHours, Long> {
}