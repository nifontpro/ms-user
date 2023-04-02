package ru.nb.medalist.msuser.db.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "gender_data", schema = "users", catalog = "medalist")
class GenderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long? = null

	var name: String? = null

	constructor(id: Long?, name: String?) {
		this.id = id
		this.name = name
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other == null || javaClass != other.javaClass) return false
		val that = other as GenderEntity
		return id == that.id
	}

	override fun hashCode(): Int {
		return Objects.hash(name)
	}
}