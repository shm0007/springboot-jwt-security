package com.ehsan.jwtScaffolder.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

}
