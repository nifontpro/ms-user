package ru.nb.medalist.msuser.rest.controller

import kotlinx.coroutines.reactive.collect
import org.springframework.http.MediaType
import org.springframework.http.codec.multipart.FilePart
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import ru.nb.medalist.base.utils.JwtUtils
import ru.nb.medalist.msuser.domain.bussines.processor.UserProcessor
import ru.nb.medalist.msuser.domain.model.User
import ru.nb.medalist.msuser.domain.service.UserService
import ru.nb.medalist.msuser.rest.controller.base.process
import ru.nb.medalist.msuser.rest.controller.mappers.fromTransport
import ru.nb.medalist.msuser.rest.controller.mappers.toTransportGetUser
import ru.nb.medalist.msuser.rest.controller.request.CreateOwnerRequest
import java.nio.file.Paths
import java.util.*

@RestController
@RequestMapping
class UserController(
	private val userProcessor: UserProcessor,
	private val userService: UserService,
	private val jwtUtils: JwtUtils
) {

	@PostMapping("create")
	suspend fun createOwner(
//		@RequestHeader(name = AUTHORIZATION) bearerToken: String,
		@RequestBody request: CreateOwnerRequest
	) {

		val user = User(
			email = request.email ?: "",
			firstname = request.name ?: "",
			lastname = request.lastname,
			patronymic = request.patronymic
		)

		userService.add(user)

	}

	@GetMapping("all")
	suspend fun getAll(): List<User> {
		return userService.getAll()
	}

	@GetMapping("create_owner")
	suspend fun createOwner(
		@RequestHeader(name = AUTHORIZATION) bearerToken: String,
		@RequestBody request: CreateOwnerRequest
	): User? {

		return process(
			processor = userProcessor,
			request = request,
			fromTransport = { fromTransport(it) },
			toTransport = { toTransportGetUser() }
		)
	}

	@PostMapping(value = ["/upload"], consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
	fun upload(@RequestPart("file") filePart: Mono<FilePart>): Mono<String> {

		return filePart
			.doOnNext { fp ->
				println("Received File : " + fp.filename())
			}
			.flatMap { fp ->
				fp.transferTo(basePath.resolve(fp.filename()))
			}
			.map { "OK" }
//			.then ()

	}

	@PostMapping(value = ["/up"], consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
	suspend fun up(@RequestPart("file") filePart: Mono<FilePart>): String {

		filePart.flatMap { fp ->
			println("Received File : " + fp.filename())
			fp.transferTo(basePath.resolve(fp.filename()))
		}.collect { }
//			.doOnNext { fp ->
//				println("Received File : " + fp.filename())
//
//			}
//			.flatMap { fp ->
//				fp.transferTo(basePath.resolve(fp.filename()))
//			}
////			.subscribe()
//			.collect { }

		return "OK"

	}

	companion object {
		private const val AUTHORIZATION = "Authorization"
		private const val LOCAL_FOLDER = "d:/files"
		private val basePath = Paths.get(LOCAL_FOLDER)
	}

}