package ru.nb.medalist.rest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class TestController(
) {

	@GetMapping("test")
	fun test(): String {
		return "Test string from user controller"
	}

}