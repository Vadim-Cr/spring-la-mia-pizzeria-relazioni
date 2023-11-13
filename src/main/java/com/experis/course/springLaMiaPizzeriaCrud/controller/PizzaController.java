package com.experis.course.springLaMiaPizzeriaCrud.controller;

import com.experis.course.springLaMiaPizzeriaCrud.model.Pizza;
import com.experis.course.springLaMiaPizzeriaCrud.repository.PizzaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public String index(@RequestParam(name = "search") Optional<String> search, Model model) {
        List <Pizza> pizzaList;
//        se il parametro di ricerca è presente filtro la lista di pizze
    if (search.isPresent()){
        pizzaList = pizzaRepository.findByPizzaNameContainingIgnoreCaseOrPizzaDescriptionContaining(search.get(), search.get());
    } else {
//        Altrimenti ti restituisco tutte le pizze non filtrate
//        RECUPERA LA LISTA DI TUTTE LE PIZZE DAL DATABASE
        pizzaList = pizzaRepository.findAll();
    }
//        PASSO AL TEMPLATE LA LISTA DI PIZZE
        model.addAttribute("pizzaList", pizzaList);
//        passo al template il valore aggiornato della strunga di ricerca per ricaricare l'input
        model.addAttribute("searchKeyword", search.orElse(""));
        return "pizzas/list";
    }

    //    scriviamo un metodo che mostri i dettagli di una pizza presa per "id"
    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Optional<Pizza> result = pizzaRepository.findById(id);
//       verifico che l'id della pizza sia presente
        if (result.isPresent()) {
//            passo al template l'oggetto Pizza
            model.addAttribute("pizza", result.get());
            return "pizzas/show";
        } else {
//       se invece l'id non c'è sollevo un'eccezione
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "pizza with id " + id + " not found");
        }
    }
//    Metodo per creare una nuova pizza
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("pizza", new Pizza());
    return "pizzas/create";
    }
    @PostMapping("/create")
    public String make(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult){
//        Validare che i dati siano corretti
        if (bindingResult.hasErrors()){
//            se ci sono errori devo ricaricare il form
            return "pizzas/create";
        }
//        Se i dati sono corretti salvo la pizza sul database
        Pizza savedPizza = pizzaRepository.save(formPizza);
        return "redirect:/pizza-stores/show/" + savedPizza.getId();
    }

}
