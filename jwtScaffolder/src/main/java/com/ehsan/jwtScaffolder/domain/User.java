package com.ehsan.jwtScaffolder.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(	name = "USER",
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "EMAIL")
		})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Size(max = 20)
	@Column(name = "NAME")
	private String name;

	@NotBlank
	@Size(max = 50)
	@Email
	@Column(name = "EMAIL")
	private String email;

	@NotBlank
	@Size(max = 120)
	@Column(name = "PASSWORD")
	private String password;

	@Size(max = 120)
	@Column(name =  "ROLE")
	private String role;
}
