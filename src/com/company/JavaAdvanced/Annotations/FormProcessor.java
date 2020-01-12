package com.company.JavaAdvanced.Annotations;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.lang.reflect.Field;

public class FormProcessor {
    private static boolean validateForm(Identity identity) throws IllegalAccessException, ScriptException {
        boolean result = true;
        for (Field field:identity.getClass().getFields()){
            Object data = field.get(identity);
            Validators validators =(Validators) field.getAnnotation(Validator.class);
            if (validators != null){
                for (Validator validator : validators.value()){
                    result = result && validateField(data,validator.value());
                }
            } else {
                Validator validator = field.getAnnotation(Validator.class);
                result = result && validateField(data, validator.value());
            }
        } return result;
    }
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
        return result.toString();
    }
    private static boolean validateField(Object data, String expression) throws  ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        engine.put("field","ExampleWord");
        engine.eval("var result = field "+expression + ";");
        return (boolean) engine.get("result");
    }
    public static void main(String[] args) throws ClassNotFoundException, ScriptException, IllegalAccessException {
        String finalForm = FormProcessor.createForm("com.company.JavaAdvanced.Annotations.Identity");
        System.out.println(finalForm);
        Identity identity = new Identity("Ugur","Celebi",22,"abc123");
        System.out.println(FormProcessor.validateForm(identity));
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
