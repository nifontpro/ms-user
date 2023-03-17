package ru.nb.medalist.msuser.rest.controller.request

data class CreateOwnerRequest(
	val email: String? = null,
	val name: String? = null,
	val patronymic: String? = null,
	val lastname: String? = null,
)