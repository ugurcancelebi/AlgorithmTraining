package com.company.JavaAdvanced;

import com.company.JavaAdvanced.Annotations.AnnotationsForm;
import com.company.JavaAdvanced.Annotations.Field;

@AnnotationsForm(label = "Identity Form", id = "frmIdentity",altText = "altText")
public class Identity {
    @Field(label = "name")
    private String name;

    @Field(label = "surname")
    private String surname;

    @Field(label = "age")
    private int age;
}
