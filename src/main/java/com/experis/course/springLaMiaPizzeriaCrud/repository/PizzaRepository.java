package com.experis.course.springLaMiaPizzeriaCrud.repository;

import com.experis.course.springLaMiaPizzeriaCrud.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
//    definisco un metodo per creare una querry custom per ricerca su nome e ingrediente (description)
    List<Pizza> findByPizzaNameContainingIgnoreCaseOrPizzaDescriptionContaining(String pizzaNameKeyword, String pizzaDescriptionKeyword);
}
