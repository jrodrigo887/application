package com.estudy.application.entities;
import java.io.Serializable;
import java.time.Instant;

import com.estudy.application.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode()
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    protected static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @EqualsAndHashCode.Exclude private Instant instant;

    private Integer orderStatus;
    
    public Order(Long id, Instant instant, OrderStatus orderStatus, User client) {
        this.id = id;
        this.instant = instant;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    private OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }
    private void setOrderStatus(OrderStatus ordercode) {
        if (ordercode != null) {
            this.orderStatus = ordercode.getCode();
        }
    }
    
    public Order() {}

    @ManyToOne
    @JoinColumn(name = "client_id")
    public User client;
}
