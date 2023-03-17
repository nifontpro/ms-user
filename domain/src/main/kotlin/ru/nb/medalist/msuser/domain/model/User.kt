package ru.nb.medalist.msuser.domain.model

data class User(
	val email: String = "",
	val name: String = "",
	val patronymic: String? = null,
	val lastname: String? = null,

	val id: String = ""
)