package ru.nb.medalist.msuser.db

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["ru.nb.medalist.msuser", "ru.nb.medalist.base"])
class MsUserApplication

fun main(args: Array<String>) {
	runApplication<MsUserApplication>(*args)
}
