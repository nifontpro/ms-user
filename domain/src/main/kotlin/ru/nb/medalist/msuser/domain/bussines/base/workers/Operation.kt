package ru.nb.medalist.msuser.domain.bussines.base.workers

import ru.nb.medalist.cor.ICorChainDsl
import ru.nb.medalist.cor.chain
import ru.nb.medalist.cor.worker
import ru.nb.medalist.msuser.domain.bussines.base.BaseContext
import ru.nb.medalist.msuser.domain.bussines.base.ContextState
import ru.nb.medalist.msuser.domain.bussines.base.IBaseCommand

fun <T : BaseContext> ICorChainDsl<T>.operation(
	title: String,
	command: IBaseCommand,
	block: ICorChainDsl<T>.() -> Unit
) = chain {
	on { this.command == command && state == ContextState.STARTING }
	this.title = title
	worker("Статус - операция выполняется") { state = ContextState.RUNNING }
	block()
}