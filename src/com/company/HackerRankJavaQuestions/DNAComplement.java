package com.company.HackerRankJavaQuestions;

public class DNAComplement {

    public static void main(String[] args) {
        String result = reverseString("ACCGGGTTTT");
        System.out.println(result);
    }
    //part 1
    private static String reverseString(String exp) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = exp.length()-1;i>=0;i--){
            char a = exp.charAt(i);
            reversedString.append(a);
        }
        return makeComplement(reversedString);
    }
    //part 2
    private static String makeComplement(StringBuilder reversedString) {
        StringBuilder complementedString = new StringBuilder();
        for (int i = 0;i<reversedString.length();i++){
            char a = reversedString.charAt(i);
            switch (a){
                case 'T':
                    a = 'A';
                    break;
                case 'C':
                    a = 'G';
                    break;
                case 'A':
                    a = 'T';
                    break;
                case 'G':
                    a = 'C';
                    break;
                default:
                    break;
            }
            complementedString.append(a);
        }
        return complementedString.toString();
    }
}
