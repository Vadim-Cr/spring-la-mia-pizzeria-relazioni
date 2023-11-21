package com.experis.course.springLaMiaPizzeriaCrud.service;


import com.experis.course.springLaMiaPizzeriaCrud.Exceptions.SpecialOfferNotFoundException;
import com.experis.course.springLaMiaPizzeriaCrud.model.SpecialOffer;
import com.experis.course.springLaMiaPizzeriaCrud.repository.OfferRepository;
import com.experis.course.springLaMiaPizzeriaCrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialOfferService {

    @Autowired
    PizzaRepository pizzaRepository;

    @Autowired
    OfferRepository offerRepository;

    public SpecialOffer saveSpecialOffer(SpecialOffer specialOffer) {
        return offerRepository.save(specialOffer);
    }

    public  SpecialOffer getSpecial(Integer id) throws SpecialOfferNotFoundException{
        return offerRepository.findById(id).orElseThrow(()->new SpecialOfferNotFoundException("Special Offer with the ID " + id + " has not been fond"));
    }


}
