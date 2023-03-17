package ru.nb.medalist.msuser.domain.bussines.base.workers

import ru.nb.medalist.cor.ICorChainDsl
import ru.nb.medalist.cor.worker
import ru.nb.medalist.msuser.domain.bussines.base.BaseContext
import ru.nb.medalist.msuser.domain.bussines.base.ContextState

fun <T : BaseContext> ICorChainDsl<T>.finishOperation(
	title: String = "Завершение операции"
) = worker {
	this.title = title
	on { state == ContextState.RUNNING }
	handle {
		state = ContextState.FINISHING
	}
}
