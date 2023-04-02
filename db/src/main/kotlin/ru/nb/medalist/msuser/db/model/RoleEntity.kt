package ru.nb.medalist.msuser.db.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "role_data", schema = "users", catalog = "medalist")
class RoleEntity(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long? = null,

	var name: String? = null
) {

	//	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(
//		name = "user_role",
//		joinColumns = [JoinColumn(name = "role_id")],
//		inverseJoinColumns = [JoinColumn(name = "user_id")]
//	)
	@ManyToMany(mappedBy = "roles")
	var users: List<UserEntity> = emptyList()

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other == null || javaClass != other.javaClass) return false
		val role = other as RoleEntity
		return id == role.id
	}

	override fun hashCode(): Int {
		return Objects.hash(id)
	}

	override fun toString(): String {
		return name ?: ""
	}
}