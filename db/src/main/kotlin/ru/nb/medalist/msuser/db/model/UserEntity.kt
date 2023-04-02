package ru.nb.medalist.msuser.db.model

import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "user_data", schema = "users", catalog = "medalist")
class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long? = null

	var email: String = ""
	var firstname: String = ""
	var patronymic: String? = null
	var lastname: String? = null
	var post: String? = null
	var phone: String? = null
	var description: String? = null

	constructor(
		id: Long? = null,
		email: String,
		firstname: String,
		patronymic: String?,
		lastname: String?,
		post: String?,
		phone: String?,
		description: String?
	) {
		this.id = id
		this.email = email
		this.firstname = firstname
		this.patronymic = patronymic
		this.lastname = lastname
		this.post = post
		this.phone = phone
		this.description = description

	}

	@ManyToOne(fetch = FetchType.EAGER)
//	@MapsId
	@JoinColumn(name = "gender_id", referencedColumnName = "id")
	var gender: GenderEntity? = null

	var sso_id: Long? = null
	//	val gender: Gender = Gender.UNDEFINED,

//	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//	@ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
//	val roles: List<RoleEntity> = emptyList()

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "user_role",
		joinColumns = [JoinColumn(name = "user_id")],
		inverseJoinColumns = [JoinColumn(name = "role_id")]
	)
	var roles: Set<RoleEntity>? = null

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other == null || javaClass != other.javaClass) return false
		val user = other as UserEntity
		return id == user.id
	}

	override fun hashCode(): Int {
		return Objects.hash(id)
	}

	override fun toString(): String {
		return firstname
	}

}