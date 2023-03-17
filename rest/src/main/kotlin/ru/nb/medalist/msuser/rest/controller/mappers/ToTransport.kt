package ru.nb.medalist.msuser.rest.controller.mappers

import ru.nb.medalist.msuser.domain.bussines.context.UserContext
import ru.nb.medalist.msuser.domain.model.User

fun UserContext.toTransportGetUser(): User = user

