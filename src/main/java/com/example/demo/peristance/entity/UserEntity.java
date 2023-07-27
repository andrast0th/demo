package com.example.demo.peristance.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

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

	// TODO: if you want role based authorization you will need to persist this data in the db
	//  here it's just mocked, @Transient is used to define a field that is not in the db in a jpa entity
	@Transient
	private List<String> roles = Collections.singletonList("user");

}
