package ru.nb.medalist.msuser.db.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.nb.medalist.msuser.db.model.RoleEntity

@Repository
interface RoleRepository : JpaRepository<RoleEntity, Long>