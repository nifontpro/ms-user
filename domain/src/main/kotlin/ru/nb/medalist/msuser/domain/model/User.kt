package ru.nb.medalist.msuser.domain.model

data class User(
	val id: Long? = null,
	val email: String = "",
	val firstname: String = "",
	val patronymic: String? = null,
	val lastname: String? = null,
	val post: String? = null,
	val phone: String? = null,
//	val gender: Gender = Gender.UNDEFINED,
	val description: String? = null,
	val gender: Gender = Gender(),
	val roles: List<Role>? = null
)