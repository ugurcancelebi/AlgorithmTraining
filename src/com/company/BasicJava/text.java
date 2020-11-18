package com.company.BasicJava;

public class text {  public static final int START_LENGTH = 1;

    private static final int SIZE = 6;
    private static final int NUMBER_OF_LASTCHARS_NOTTO_MASK = 4;

    public static String maskify(String creditCardNumber) {
        if (creditCardNumber == null || creditCardNumber.isEmpty()) {
            return "";
        }

        if (creditCardNumber.length() < SIZE) {
            return creditCardNumber;
        }

        if (creditCardNumber.replaceAll("\\D", "").length() < SIZE) {
            return creditCardNumber;
        }

        int cardLength = creditCardNumber.length();

        String inner = creditCardNumber.substring(1, cardLength - NUMBER_OF_LASTCHARS_NOTTO_MASK);
        inner = inner.replaceAll("[0-9]", "#");

        creditCardNumber = creditCardNumber.charAt(0) + inner + creditCardNumber.substring(cardLength - NUMBER_OF_LASTCHARS_NOTTO_MASK);
        return creditCardNumber;
    }

    public static void main(String[] args) {
        System.out.println(maskify("A1234567BCDEFG89HI"));
    }
}
