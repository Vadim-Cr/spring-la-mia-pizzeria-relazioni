package com.experis.course.springLaMiaPizzeriaCrud.controller;

import com.experis.course.springLaMiaPizzeriaCrud.model.Pizza;
import com.experis.course.springLaMiaPizzeriaCrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pizza-stores")
public class PizzaController {
    //ATTRIBUTES
    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping
    public String index(Model model) {
//        RECUPERA LA LISTA DI TUTTE LE PIZZE DAL DATABASE
        List<Pizza> pizzaMenu = pizzaRepository.findAll();

//        PASSO AL TEMPLATE LA LISTA DI PIZZE
        model.addAttribute("pizzaList", pizzaMenu);
        return "pizzas/list";
    }

    //    scriviamo un metodo che mostri i dettagli di una pizza presa per "id"
    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id) {
        Optional<Pizza> result = pizzaRepository.findById(id);
//       verifico che l'id della pizza sia presente
        if (result.isPresent()) {
            return "pizzas/show";
        } else {
//       se invece l'id non c'è sollevo un'eccezione
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
