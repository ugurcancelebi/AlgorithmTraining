package com.company.HackerRankJavaQuestions;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Quiz {
   /**
   * There are three lines of output:
   * For the first line, sum the lengths of  and .
   * For the second line, write Yes if  is lexicographically greater than  otherwise print No instead.
   * For the third line, capitalize the first letter in both  and  and print them on a single line, separated by a space.
   * */
   private static void javaStringsIntroduction(){
       Scanner sc = new Scanner(System.in);
       String wordA = sc.next();
       String wordB = sc.next();
       int totalValues = wordA.length() + wordB.length();
       System.out.println(totalValues);
       if (wordA.compareTo(wordB)>0){
           System.out.println("Yes");
       }else System.out.println("No");
       System.out.println(wordA.substring(0,1).toUpperCase()+wordA.substring(1)+
                            " "+wordB.substring(0,1).toUpperCase() +wordB.substring(1));
   }

   /**
    * Two strings,  and , are called anagrams if they contain all the same characters in the same frequencies.
    * For example, the anagrams of CAT are CAT, ACT, TAC, TCA, ATC, and CTA.
    * Complete the function in the editor. If  and  are case-insensitive anagrams, print "Anagrams"; otherwise, print "Not Anagrams" instead.
    */
   private static boolean checkAnagram(String a,String b){
       if (a.length() != b.length())
           return false;

       int[] temp = new int[128];
       a = a.toLowerCase();
       b = b.toLowerCase();
       int sum = 0;

       for (int i = 0; i < a.length(); i++) {
           sum += ++temp[a.charAt(i)] <= 0 ? -1 : 1;
           sum += --temp[b.charAt(i)] >= 0 ? -1 : 1;
       }
       return sum == 0;
   }
   /**
     * Given a string, , matching the regular expression [A-Za-z !,?._'@]+, split the string into tokens.
     * We define a token to be one or more consecutive English alphabetic letters.
     * Then, print the number of tokens, followed by each token on a new line..
    * */
    private static void separateIntoTokens(){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        if (s.trim().isEmpty()) {
            System.out.println(0);
        }
        else{
            String[] splitString = ("[\\s!,?._'@]+".split(s.replaceAll("^\\W+", "")));
            System.out.println(splitString.length);
            for (String string : splitString) {
                System.out.println(string);
            }
        }
    }
    private static boolean ifCondition(){
        int number = Integer.MIN_VALUE;
        return (number == -number && number != 0);
    }
    /**
    * Print the sum of both integers on the first line, the sum of both doubles (scaled to  decimal place) on
    * the second line, and then the two concatenated strings on the third line.
     * */
    private static void dataTypesChallenge(){
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
        Scanner scan = new Scanner(System.in);

        int i2;
        double d2;
        String s2;

        i2 = scan.nextInt();
        d2 = scan.nextDouble();
        scan.nextLine();
        s2 = scan.nextLine();

        System.out.println(i + i2);
        System.out.println(d + d2);
        System.out.println(s + s2);

        scan.close();
    }
    /**
    * Using Regex, we can easily match or search for patterns in a text.
    * Before searching for a pattern, we have to specify one using some well-defined syntax.
    * In this problem, you are given a pattern. You have to check whether the syntax of the given pattern is valid.
    */
    private static void checkPatternValidation(){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0){
            String pattern = in.nextLine();
            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            }catch (Exception e){
                System.out.println("Invalid");
            }
            testCases--;
        }
    }
    /**
    * The code above prints the value stored at index  of , which is  (the value we previously stored there).
    *  It's important to note that while Java initializes each cell of an
    * array of integers with a , not all languages do this.
    */
    private static void oneDimensionArray(){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = 10+(i*10);
        }
        scan.close();
        for (int value : a) {
            System.out.println(value);
        }
    }
    /**
    * Given a large integer, n , use the Java BigInteger class' is
    * ProbablePrime method to determine and print whether it's prime or not prime.
    */
    private static boolean isPrime(){
        Scanner scan = new Scanner(System.in);
        BigInteger n = scan.nextBigInteger();
        scan.close();
        return n.isProbablePrime(10);
    }

    /**
    *The username consists of  to  characters inclusive. If the username consists of less than  or greater than  characters, then it is an invalid username.
    *The username can only contain alphanumeric characters and underscores (_). Alphanumeric characters describe the character set consisting of lowercase characters , uppercase characters , and digits .
    *The first character of the username must be an alphabetic character, i.e., either lowercase character  or uppercase character .
     * */
    private static void checkValidity() {
        final Scanner scan = new Scanner(System.in);
        final String regularExpression = "[a-zA-Z][a-zA-Z0-9_]{7,29}$";

        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
