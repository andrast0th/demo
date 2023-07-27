package com.example.demo.peristance.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

}
