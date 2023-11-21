package com.experis.course.springLaMiaPizzeriaCrud.Exceptions;

public class PizzaNotFoundException  extends RuntimeException {
    public PizzaNotFoundException(String message) {
        super(message);
    }
}
