package ru.nb.medalist.msuser.domain.bussines.context

import ru.nb.medalist.msuser.domain.bussines.base.BaseContext
import ru.nb.medalist.msuser.domain.bussines.base.IBaseCommand
import ru.nb.medalist.msuser.domain.model.User

data class UserContext(
	var user: User = User(),
	val users: MutableList<User> = mutableListOf(),
) : BaseContext(command = UserCommand.NONE)

enum class UserCommand : IBaseCommand {
	NONE,
	CREATE,
}
