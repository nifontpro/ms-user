package ru.nb.medalist.msuser.db.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.nb.medalist.msuser.db.model.UserEntity

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {

}