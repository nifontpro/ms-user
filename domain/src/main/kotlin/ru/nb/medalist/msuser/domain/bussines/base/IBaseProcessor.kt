package ru.nb.medalist.msuser.domain.bussines.base

interface IBaseProcessor<T> {
	suspend fun exec(ctx: T)
}
