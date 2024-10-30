package com.ahumadamob.ies.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueDniValidator.class)
public @interface UniqueDni {
    String message() default "El DNI ya está registrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}


