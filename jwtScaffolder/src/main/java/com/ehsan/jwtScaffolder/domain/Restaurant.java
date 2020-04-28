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

@Entity
@Table(	name = "RESTAURANT")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(max = 200)
    @Column(name = "NAME")
    private String name;


    @Size(max = 500)
    @Column(name = "DESCRIPTION")
    private String description;

    @NotBlank
    @Size(max = 120)
    @Column(name = "LOCATION")
    private String location;

    @Size(max = 120)
    @Column(name = "CONTACT")
    private String contact;


    @Column(name = "USER_ID")
    private Long userId;




}
