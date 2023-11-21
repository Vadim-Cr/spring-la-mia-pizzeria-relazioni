package com.experis.course.springLaMiaPizzeriaCrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max=255)
    @NotNull
    @Column(unique = true)
    private String pizzaName;

    @NotBlank
    @Size(max=1000)
    @NotNull
    @Lob
    private String pizzaDescription;

    @NotBlank
    @NotNull
    @Lob
    private String pizzaPicture;

    @NotNull
    @DecimalMin("2.0")
    @DecimalMax("50.99")
    private double pizzaPrice;

    private LocalDateTime createdAt;


    @OneToMany(mappedBy = "pizza")
    private List<SpecialOffer> specials = new ArrayList<>();
    public String getPizzaPicture() {
        return pizzaPicture;
    }

    public List<SpecialOffer> getSpecials() {
        return specials;
    }

    public void setSpecials(List<SpecialOffer> specials) {
        this.specials = specials;
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
