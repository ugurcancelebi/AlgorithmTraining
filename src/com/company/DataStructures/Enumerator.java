package com.company.DataStructures;

import java.util.*;

public class Enumerator {
    enum Companies{
        GOOGLE,MICROSOFT,NETFLIX,APPLE,AMAZON
    }
    private static Companies companies;
    private Enumerator(Companies companies){
        Enumerator.companies = companies;
    }

    public static void main(String[] args) {
        callEnumDescription();
        callVectorEnumeration();
        callIntegerSortingEnumeration(); 
        callEnumVariables();
    }
    private static void callEnumDescription(){
        System.out.println("Please type a company to see description  :");
        String companyName = new Scanner(System.in).nextLine();
        Enumerator enumerator = new Enumerator(companies);
        System.out.println(enumerator.getCompanyDescription(companyName));
    }
    private static void callVectorEnumeration(){
        Vector<String> vector = new Vector<>();
        Enumeration<String> enumeration;
        vector.add("First");vector.add("Second");vector.add("Third");vector.add("Fourth");vector.add("Fifth");
        enumeration = vector.elements();
        while (enumeration.hasMoreElements())
            System.out.println(enumeration.nextElement());
    }
    private static void callEnumVariables(){
        HashSet<String> hashSet = new HashSet<>();
        for (Companies companies:Companies.values())
            hashSet.add(companies.name());
        Enumeration<String> enumeration = Collections.enumeration(hashSet);
        while (enumeration.hasMoreElements())
            System.out.println(enumeration.nextElement());
    }
    private static void callIntegerSortingEnumeration(){
        TreeSet<Integer> treeSet = new TreeSet<>();
        Enumeration<Integer> enumeration;
        for (int i = 0;i< 10;i++){
            Random random = new Random();
            treeSet.add(random.nextInt());
        }
        enumeration = Collections.enumeration(treeSet);
        while (enumeration.hasMoreElements())
            System.out.println(enumeration.nextElement());
    }
    private String getCompanyDescription(String companyName){
        switch (companyName){
            case "GOOGLE":
                System.out.println("Biggest search engine ever known");
                break;
            case "MICROSOFT":
                System.out.println("Software company including biggest operation system ever known");
                break;
            case "NETFLIX":
                System.out.println("Movie watching application known all around the world");
                break;
            case "APPLE":
                System.out.println("Technology brand mostly known as iPhone");
                break;
            case "AMAZON":
                System.out.println("Online shopping company around the world");
                break;
            default:
                System.out.println("Company has not found..");
                break;
        }
        return companyName;
    }
}
