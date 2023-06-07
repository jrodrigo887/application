package com.estudy.application.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
    protected static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @EqualsAndHashCode.Exclude private String name;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    Set<Product> products = new HashSet<>();

    public Category() { }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
