package com.example.demo.peristance.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

	@Id
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String email;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(name = "user_username"),
			inverseJoinColumns = @JoinColumn(name = "role_role_name")
	)
	private Set<RoleEntity> roles = new HashSet<>();

}
