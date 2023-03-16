package ru.nb.medalist.msuser.di

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["ru.nb.medalist.msuser"])
class MainApplication

fun main(args: Array<String>) {
	runApplication<MainApplication>(*args)
}
