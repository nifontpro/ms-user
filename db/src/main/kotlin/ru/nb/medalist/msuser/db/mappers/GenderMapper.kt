package ru.nb.medalist.msuser.db.mappers

import ru.nb.medalist.msuser.db.model.GenderEntity
import ru.nb.medalist.msuser.domain.model.Gender

fun GenderEntity.toGender() = Gender(
	id = id,
	name = name
)