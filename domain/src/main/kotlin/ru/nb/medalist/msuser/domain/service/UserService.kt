package ru.nb.medalist.msuser.domain.service

import ru.nb.medalist.msuser.domain.model.User

interface UserService {
	fun add(user: User)
	fun getAll(): List<User>
}