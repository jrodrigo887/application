package com.estudy.application.entities;
import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.MapsId;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {
    protected static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @EqualsAndHashCode.Exclude private Instant instant;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;
    
    public Payment() {}

    public Payment(Long id, Instant instant, Order order) {
        this.id = id;
        this.instant = instant;
        this.order = order;
    }
}
