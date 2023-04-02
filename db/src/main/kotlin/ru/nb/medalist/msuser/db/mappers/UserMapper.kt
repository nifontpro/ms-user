package ru.nb.medalist.msuser.db.mappers

import ru.nb.medalist.msuser.db.model.UserEntity
import ru.nb.medalist.msuser.domain.model.Gender
import ru.nb.medalist.msuser.domain.model.User

fun User.toUserEntity() = UserEntity(
	email = email,
	firstname = firstname,
	patronymic = patronymic,
	lastname = lastname,
	post = post,
	phone = phone,
	description = description,
//	roles = setOf(RoleEntity(id = null, name = "USER"))
)

fun UserEntity.toUser() = User(
	email = email,
	firstname = firstname,
	patronymic = patronymic,
	lastname = lastname,
	post = post,
	phone = phone,
	description = description,
//	roles = roles?.map { Role(id = it.id, name = it.name) },
	gender = gender?.toGender() ?: Gender(),
	id = id
)