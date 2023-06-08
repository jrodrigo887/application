package com.estudy.application.entities;

import java.io.Serializable;

import com.estudy.application.entities.pks.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    protected static final long serialVersionUID = 1L;
   
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private Double price;
    private Integer quantity;
    
    public OrderItem() {}

    public OrderItem(Order order, Product product, Double price, Integer quantity) {
        super();
        id.setOrder(order);
        id.setProduct(product);
        this.price = price;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return id.getProduct();
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}   
