package com.experis.course.springLaMiaPizzeriaCrud.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String pizzaName;
    @Lob
    private String pizzaDescription;
    @Lob
    private String pizzaPicture;
    private double pizzaPrice;
    private LocalDateTime createdAt;
    public String getPizzaPicture() {
        return pizzaPicture;
    }

    public void setPizzaPicture(String pizzaPicture) {
        this.pizzaPicture = pizzaPicture;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPizzaDescription() {
        return pizzaDescription;
    }

    public void setPizzaDescription(String pizzaDescription) {
        this.pizzaDescription = pizzaDescription;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaPrice(double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }


}
