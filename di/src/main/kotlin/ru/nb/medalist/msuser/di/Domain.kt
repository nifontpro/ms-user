package ru.nb.medalist.msuser.di

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.nb.medalist.msuser.domain.bussines.processor.UserProcessor

@Configuration
class Domain {

	@Bean
	fun processor(): UserProcessor = UserProcessor()

}