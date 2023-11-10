package com.experis.course.springLaMiaPizzeriaCrud.repository;

import com.experis.course.springLaMiaPizzeriaCrud.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
