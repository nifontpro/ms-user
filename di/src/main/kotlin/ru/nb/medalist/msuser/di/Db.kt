package ru.nb.medalist.msuser.di

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.nb.medalist.msuser.domain.TestData
import ru.nb.medalist.msuser.db.TestDataImpl

@Configuration
class Di {

	@Bean
	fun store(): TestData {
		return TestDataImpl()
	}
}