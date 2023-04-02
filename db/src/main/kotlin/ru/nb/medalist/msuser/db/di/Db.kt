package ru.nb.medalist.msuser.db.di

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.nb.medalist.msuser.db.repository.UserRepository
import ru.nb.medalist.msuser.db.service.UserServiceImpl
import ru.nb.medalist.msuser.domain.service.UserService

@Configuration
class Db {

	@Bean
	fun userService(userRepository: UserRepository): UserService = UserServiceImpl(userRepository)
}