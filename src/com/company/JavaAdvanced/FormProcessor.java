package com.company.JavaAdvanced;

import com.company.JavaAdvanced.Annotations.AnnotationsForm;
import com.company.JavaAdvanced.Annotations.FormField;
import com.company.JavaAdvanced.Annotations.PasswordField;

import java.lang.reflect.Field;

public class FormProcessor {
    private static String createForm(String className) throws ClassNotFoundException {
        Class identityForm = Class.forName(className);
        AnnotationsForm form = (AnnotationsForm) identityForm.getAnnotation(AnnotationsForm.class);
        StringBuilder result = new StringBuilder(("<fieldset><legend>" + form.label() + "</legend>"));
        for (Field field : identityForm.getFields()){
            FormField metadata = field.getAnnotation(FormField.class);
            PasswordField password = field.getAnnotation(PasswordField.class);
            result.append("<label for=\"").append(metadata.id()).append("\">").append(metadata.label()).append("</label><br />");
            result.append("<input type=\"").append(password == null ? "text" : "password").append("\" id=\"").append(metadata.id()).append("\" /><br />");
        }
        result.append("</fieldset>");
        return result.toString().toString();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String finalForm = FormProcessor.createForm("com.company.JavaAdvanced.Identity");
        System.out.println(finalForm);
    }
    /*String finalState = "<fieldset>" +
                "<legend>Identity Form</legend><br/>" +
                "label for=\"txtName\">Name</label><br/>" +
                "input type=\"text\" id=\"txtName\"/><br/>" +
                "label for=\"txtSurname\">Surname</label><br/>" +
                "input type=\"text\" id=\"txtName\"/><br/>" +
                "label for=\"txtAge\">Age</label><br/>" +
                "input type=\"text\" id=\"txtName\"/><br/>" +
        "</fieldset>";*/
}
