package ru.nb.medalist.msuser.rest.controller.mappers

import ru.nb.medalist.msuser.domain.bussines.context.UserCommand
import ru.nb.medalist.msuser.domain.bussines.context.UserContext
import ru.nb.medalist.msuser.domain.model.User
import ru.nb.medalist.msuser.rest.controller.request.CreateOwnerRequest

fun UserContext.fromTransport(request: CreateOwnerRequest) {
	command = UserCommand.CREATE
	user = User(
		email = request.email ?: "",
		name = request.name ?: "",
		patronymic = request.patronymic,
		lastname = request.lastname,
	)
}