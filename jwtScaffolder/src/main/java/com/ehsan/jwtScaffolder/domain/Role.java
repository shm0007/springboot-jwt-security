package com.ehsan.jwtScaffolder.domain;

import com.ehsan.jwtScaffolder.model.RoleEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private RoleEnum name;


}