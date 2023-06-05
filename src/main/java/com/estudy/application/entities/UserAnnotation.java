package com.estudy.application.entities;
import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@MappedSuperclass
public abstract class UserAnnotation implements Serializable {
    protected static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
}

