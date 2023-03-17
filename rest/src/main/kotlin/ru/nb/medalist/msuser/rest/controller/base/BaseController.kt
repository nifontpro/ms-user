package ru.nb.medalist.msuser.rest.controller.base

import ru.nb.medalist.msuser.domain.bussines.base.BaseContext
import ru.nb.medalist.msuser.domain.bussines.base.IBaseProcessor
import kotlin.reflect.full.createInstance

/**
 * Функционал запрос-ответ сервера с применением бизнес-логики с авторизацией
 */
suspend inline fun <reified T, reified R, reified C : BaseContext> process(
	processor: IBaseProcessor<C>,
	request: T,
	fromTransport: C.(T) -> Unit,
	toTransport: C.() -> R? = { null }
): R? {
	val context = C::class.createInstance()
	context.fromTransport(request)
	processor.exec(context)
	return context.toTransport()
}