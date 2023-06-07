package com.estudy.application.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    protected static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @EqualsAndHashCode.Exclude private String name;
    @EqualsAndHashCode.Exclude private String descriptio;
    @EqualsAndHashCode.Exclude private Double price;
    @EqualsAndHashCode.Exclude private String imgUrl;

    @Transient
    Set<Category> categories = new HashSet<>();
    
    public Product() { }

    public Product(Long id, String name, String descriptio, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.descriptio = descriptio;
        this.price = price;
        this.imgUrl = imgUrl;
    }
}
