package ru.nb.medalist.msuser.domain.bussines.processor

import ru.nb.medalist.cor.rootChain
import ru.nb.medalist.cor.worker
import ru.nb.medalist.msuser.domain.bussines.base.IBaseProcessor
import ru.nb.medalist.msuser.domain.bussines.base.workers.finishOperation
import ru.nb.medalist.msuser.domain.bussines.base.workers.initStatus
import ru.nb.medalist.msuser.domain.bussines.base.workers.operation
import ru.nb.medalist.msuser.domain.bussines.context.UserCommand
import ru.nb.medalist.msuser.domain.bussines.context.UserContext

@Suppress("RemoveExplicitTypeArguments")
class UserProcessor : IBaseProcessor<UserContext> {

	override suspend fun exec(ctx: UserContext) = businessChain.exec(ctx)

	companion object {

		private val businessChain = rootChain<UserContext> {
			initStatus("Инициализация статуса")

			operation("Создать профиль сотрудника", UserCommand.CREATE) {
				worker("Подготовка полей к авторизации") {
					user = user.copy(patronymic = "Your")
				}
			}
			finishOperation()
		}.build()
	}
}