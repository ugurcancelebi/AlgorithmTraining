package com.company.BasicJava;

import java.util.Random;

public class Quiz6 {
    public static void main(String[] args) {
        unit1();
        unit2();
        unit3();
        unit5();
        unit6();
        unit7();
        unit8();
        unit10();
    }

    private static void unit10() {
        String str = "a";
        String str2 = "i";
        String str3 = "o";
        int count = 2;
        for (int i = 0;i<count;i++){
            str2 = str + str2 + str3;
        }
        System.out.println(str2);
    }

    private static void unit9() {
        Random random = new Random();
        byte myArray[]= new byte[1050];
        for (int myindex = 3;myindex<myArray.length-900;myindex++);
            //myArray[random.nextInt(1050)] = myindex;//casting error..
    }


    private static void unit8() {
        String a[] =  new String[7];
        for (int i = 0;i<=6;i++){
            a[i] = "";
        }
        String e[] = {"","","","","","",""};

        String f[] = new String[7];
    }

    private static void unit7() {
        int a = 5,b= 3,c=7;
        int e = a+ b -c;
        int f = a +++ b +c;
        //int g = a ** 2 + 2 * a * b-; error
    }

    private static void unit6() {
        String x = "A Problem is";
        String y = "a chance";
        String z = "for you to do your best.";
        int zLen = z.length()+3;
        char xCh = x.charAt(10);
        int yInd = y.indexOf("c");
        String xSub = x.substring(2,7);
        boolean yEq = y.equals("a chance");
    }

    private static void unit5() {
        String str = "Bilgi University";
        char chr = str.charAt(str.length() / 2);
        str = str.replace(chr,'.');
        System.out.println(str);
    }

    private static boolean unit4(int x) {
        int result = x*x + 5*x - 7;
        return (result*result + 2*result -3) > 0;
    }

    private static void unit3() {
        int[] array = {7,13,2};
        int temp;
        for (int i = 0;i<array.length;i++){
            for (int j = i+1;j < array.length;j++){
                if (array[i] > array[j]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
             }
        }
        for (int i = 0; i< array.length;i++){
            System.out.print(array[i] + " ");
        }
    }

    private static void unit2() {
        Random r = new Random();
        double randomValue = 20+(148-20)*(r.nextDouble()*2)/2;
        System.out.println(randomValue);
    }

    private static void unit1() {
        int number = new Random().nextInt();
    }
}
