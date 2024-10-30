package com.ahumadamob.ies.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ahumadamob.ies.service.IAlumnoService;

@Component
public class UniqueDniValidator implements ConstraintValidator<UniqueDni, Integer> {

    @Autowired
    @Lazy
    private IAlumnoService alumnoService;

    @Override
    public void initialize(UniqueDni constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer dni, ConstraintValidatorContext context) {
        return (dni==null)?true:!alumnoService.existsByDni(dni); 
    }
}

