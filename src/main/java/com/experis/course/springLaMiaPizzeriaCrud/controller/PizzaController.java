package com.experis.course.springLaMiaPizzeriaCrud.controller;

import com.experis.course.springLaMiaPizzeriaCrud.model.Pizza;
import com.experis.course.springLaMiaPizzeriaCrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pizza-stores")
public class PizzaController {
//ATTRIBUTES
    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping
    public String index(Model model){
//        RECUPERA LA LISTA DI TUTTE LE PIZZE DAL DATABASE
        List<Pizza> pizzaMenu= pizzaRepository.findAll();

//        PASSO AL TEMPLATE LA LISTA DI PIZZE
        model.addAttribute("pizzaList", pizzaMenu);
        return "pizzas/list";
    }
}
