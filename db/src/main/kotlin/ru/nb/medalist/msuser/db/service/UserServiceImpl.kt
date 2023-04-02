package ru.nb.medalist.msuser.db.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import ru.nb.medalist.msuser.db.mappers.toUser
import ru.nb.medalist.msuser.db.mappers.toUserEntity
import ru.nb.medalist.msuser.db.repository.UserRepository
import ru.nb.medalist.msuser.domain.model.User
import ru.nb.medalist.msuser.domain.service.UserService

@Service
@Transactional
class UserServiceImpl(
	private val repository: UserRepository
) : UserService {

	override fun add(user: User) {
		repository.save(user.toUserEntity())
	}

	override fun getAll(): List<User> {
		return repository.findAll().map { it.toUser() }
	}

}