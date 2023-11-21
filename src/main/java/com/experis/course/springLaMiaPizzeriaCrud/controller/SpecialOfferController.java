package com.experis.course.springLaMiaPizzeriaCrud.controller;

import com.experis.course.springLaMiaPizzeriaCrud.Exceptions.PizzaNotFoundException;
import com.experis.course.springLaMiaPizzeriaCrud.Exceptions.SpecialOfferNotFoundException;
import com.experis.course.springLaMiaPizzeriaCrud.model.Pizza;
import com.experis.course.springLaMiaPizzeriaCrud.model.SpecialOffer;
import com.experis.course.springLaMiaPizzeriaCrud.repository.OfferRepository;
import com.experis.course.springLaMiaPizzeriaCrud.repository.PizzaRepository;
import com.experis.course.springLaMiaPizzeriaCrud.service.SpecialOfferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Controller
@RequestMapping("/specials")
public class SpecialOfferController {

    @Autowired
    SpecialOfferService specialOfferService;

    @Autowired
    PizzaRepository pizzaRepository;

    @Autowired
    OfferRepository offerRepository;
    @GetMapping("/create")
    public String create(@RequestParam Integer pizzaId, Model model){
        try {
        Pizza pizza= pizzaRepository.findById(pizzaId).orElseThrow(()->new PizzaNotFoundException("Pizza with I " + pizzaId + " not found"));
        SpecialOffer offer = new SpecialOffer();
        offer.setStartDate(LocalDate.now());
        offer.setExpireDate(LocalDate.now().plusMonths(1));
        offer.setPizza(pizza);
            model.addAttribute("offer", offer);
            return "specials/form";
        } catch (PizzaNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("offer") SpecialOffer formOffer, BindingResult bindingResult){
//        valido i dati
        if (bindingResult.hasErrors()){
//            model.addAttribute("offer", formOffer);
            return "specials/form";
        }
//        salvo sui database
        SpecialOffer savedSpecialOffer = specialOfferService.saveSpecialOffer(formOffer);

//        offerRepository.save(formOffer);
//        redirecr al dettaglio della pizza
        return "redirect:/pizza-stores/show/" + formOffer.getPizza().getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        try {
            SpecialOffer specialOffer = specialOfferService.getSpecial(id);
            model.addAttribute("offer", specialOffer);
            return "specials/form";
        } catch (SpecialOfferNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable Integer id,
                         @Valid @ModelAttribute("offer") SpecialOffer offer, BindingResult bindingResult) {
        // valido
        if (bindingResult.hasErrors()) {
            return "specials/form";
        }
        // salvo su db
        SpecialOffer savedSpecialOffer = specialOfferService.saveSpecialOffer(offer);
//        Service.saveBorrowing(formBorrowing);
        // redirect
        return "redirect:/pizza-stores/show/" + offer.getPizza().getId();
    }
}
