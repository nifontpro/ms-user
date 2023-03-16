package ru.nb.medalist.msuser.db

import ru.nb.medalist.msuser.domain.TestData

class TestDataImpl: TestData {
	override fun getTestString(): String {
		return "Test data string from module user:db"
	}
}