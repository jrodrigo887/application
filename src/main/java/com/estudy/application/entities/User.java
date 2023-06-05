package com.estudy.application.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "tb_user")
public class User extends UserAnnotation {
    private String name;
    private String email;
    private String phone;
    private String password;

    public User() {}

    public User(Long id, String name, String email, String phone, String password) {
        super();
        super.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public User(List<Order> ordens, Long id, String name, String email, String phone, String password) {
        super();
        this.ordens = ordens;
        super.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

   
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private java.util.List<Order>  ordens = new ArrayList<>();

   
}
