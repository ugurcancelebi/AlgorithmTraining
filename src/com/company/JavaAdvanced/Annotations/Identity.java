package com.company.JavaAdvanced.Annotations;

import com.sun.istack.internal.NotNull;

@AnnotationsForm(label = "Identity Form", id = "frmIdentity",altText = "altText")
public class Identity {
    public Identity(String name, String surname, int age, String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.password = password;
    }
    @Validator("!=null")
    @Validator(".length>0")
    @FormField(label = "name")
    private String name;

    @Validator("!=null")
    @Validator(".length>0")
    @FormField(label = "surname")
    private String surname;

    @Validator("!=null")
    @Validator(">0")
    @NotNull
    @FormField(label = "age")
    private int age;

    @Validator(".length>3")
    @Validator(".length<5")
    @PasswordField
    @FormField(label = "password")
    private String password;
}
