package com.duyi.bean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class GuestValidator {
    public static void main(String[] args) {
        ordinary();
        System.out.println("=================");
        failFast();
    }

    public static void ordinary() {
        Validator validator = Validation
                .buildDefaultValidatorFactory().getValidator();
        Guest guest = new Guest("", "");
        Set<ConstraintViolation<Guest>> result = validator.validate(guest);
        result.forEach(x -> {
            System.out.println(x.getPropertyPath() + ": " + x.getMessage());
        });
    }

    public static void failFast() {
        Validator validator = Validation
                .byDefaultProvider().configure()
                .addProperty("hibernate.validator.fail_fast", "true")
                .buildValidatorFactory().getValidator();
        Guest guest = new Guest("", "");
        Set<ConstraintViolation<Guest>> result = validator.validate(guest);
        result.forEach(x -> {
            System.out.println(x.getPropertyPath() + ": " + x.getMessage());
        });
    }
}
