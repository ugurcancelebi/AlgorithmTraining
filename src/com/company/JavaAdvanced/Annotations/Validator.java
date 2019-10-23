package com.company.JavaAdvanced.Annotations;

import java.lang.annotation.*;

@Repeatable(Validators.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Validator {
    String value();
}
