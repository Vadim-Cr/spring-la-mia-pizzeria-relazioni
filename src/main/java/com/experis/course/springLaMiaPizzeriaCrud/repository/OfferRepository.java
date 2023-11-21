package com.experis.course.springLaMiaPizzeriaCrud.repository;

import com.experis.course.springLaMiaPizzeriaCrud.model.SpecialOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<SpecialOffer, Integer> {

}
