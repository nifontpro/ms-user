package ru.nb.medalist.msuser.rest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.nb.medalist.msuser.domain.TestData
import ru.nb.medalist.msuser.domain.bussines.processor.UserProcessor
import ru.nb.medalist.msuser.domain.model.User
import ru.nb.medalist.msuser.rest.controller.base.process
import ru.nb.medalist.msuser.rest.controller.mappers.fromTransport
import ru.nb.medalist.msuser.rest.controller.mappers.toTransportGetUser
import ru.nb.medalist.msuser.rest.controller.request.CreateOwnerRequest

@RestController
@RequestMapping
class UserController(
	private val userProcessor: UserProcessor
) {

	@GetMapping("create_owner")
	suspend fun createOwner(@RequestBody request: CreateOwnerRequest): User? {

		return process(
			processor = userProcessor,
			request = request,
			fromTransport = { fromTransport(it) },
			toTransport = { toTransportGetUser() }
		)
	}

}