package com.company.JavaAdvanced.Annotations;

public @interface Field {
    String label();
    String id() default "";
}
