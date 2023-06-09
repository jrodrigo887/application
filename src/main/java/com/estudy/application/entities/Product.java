package com.estudy.application.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    protected static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @EqualsAndHashCode.Exclude
    private String name;
    @EqualsAndHashCode.Exclude
    private String descriptio;
    @EqualsAndHashCode.Exclude
    private Double price;
    @EqualsAndHashCode.Exclude
    private String imgUrl;

    @ManyToMany
    @JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    Set<Category> categories = new HashSet<>();
    
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String name, String descriptio, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.descriptio = descriptio;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    @JsonIgnore
    public Set<Order> getOrders() {
        Set<Order> set = new HashSet<>();
        for (OrderItem item : items) {
            set.add(item.getOrder());
        }
        return set;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public String getName() {
        return name;
    }

    public String getDescriptio() {
        return descriptio;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Long getId() {
        return id;
    }
}
