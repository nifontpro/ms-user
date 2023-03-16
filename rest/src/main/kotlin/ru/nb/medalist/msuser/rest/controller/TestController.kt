package ru.nb.medalist.msuser.rest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.nb.medalist.msuser.domain.TestData

@RestController
@RequestMapping("api")
class TestController(
	private val testData: TestData
) {

	@GetMapping("test")
	fun test(): String {
		return testData.getTestString()
	}

}