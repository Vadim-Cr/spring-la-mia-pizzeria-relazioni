package com.experis.course.springLaMiaPizzeriaCrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

@Entity
@Table (name="specials")
public class SpecialOffer {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

    @NotNull
    private LocalDate startDate;

//    @NotNull
//    private LocalDate endDate;

    @NotNull
    private LocalDate expireDate;


    private String offerName;

    @NotNull
    @ManyToOne
    private Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

//    public LocalDate getEndDate() {
//        return endDate;
//    }

//    public void setEndDate(LocalDate endDate) {
//        this.endDate = endDate;
//    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }
}
