package com.company.BasicJava;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz5 {
    static  boolean b = true;
    public static void main(String[] args) {
        //fonksiyonu çağırmak için metod adını buraya yazın
        //örnek unit13();
    }

    private static void unit13() {
        double g = 9.8;
        int h = new Scanner(System.in).nextInt();
        double zaman = ZAMAN(g,h);
        System.out.println(zaman);
    }

    private static double ZAMAN(double g, int h) {
        return Math.sqrt(2*h/g);
    }

    private static void unit12() {
        int sayi = new Scanner(System.in).nextInt();
        System.out.println(sayiKontrol(sayi));
    }

    private static boolean sayiKontrol(int num) {
        if (num % 4 == 0&& num % 3 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void unit11() {
        System.out.println("Sayi giriniz");
        int sayi = new Scanner(System.in).nextInt();
        int gecici = sayi;
        int tersSayi = 0;


        while(sayi != 0)
        {
            tersSayi = tersSayi * 10;
            tersSayi = tersSayi + sayi%10;
            sayi = sayi/10;
        }
        int toplam = gecici + tersSayi;
        System.out.println("Iki sayinin toplami = " + toplam);
    }

    private static void unit10() {
        short hand = 42;
        if (hand < 50 && !b){
            hand ++;
        }
        if (hand < 50);
        else if(hand > 40){
            hand += 7;
            hand++;
        } else
            --hand;
        System.out.println(hand);
    }

    private static void unit9() {
        String[] s = {"Salı", "Pazartesi", "Cuma", "Carşamba", "Perşembe", "Pazar","Cumartesi"};
        Arrays.sort(s);
        System.out.println(s[0]);
    }

    private static void unit8() {
        double value = 9.0;
        System.out.println(Math.sqrt(value));
    }

    private static void unit7() {
        int x = 3;
        int y = 1;
        //if (x = y) System.out.println("X = " + x);//derleme hatası
    }

    private static void unit6() {
        int i = 0;
        while (i == 0){
            if (i == 4){
                break;
            }
            ++i;
        }
        System.out.println("i = " + i);
    }

    private static void unit5() {
        int i = 1,j = 0;
        switch (i){
            case 2 : j += 6;
            case 4 : j += 1;
            default: j += 2;
            case 0:  j += 4;
        }
        System.out.println("j = " + j);
    }

    private static void unit4() {
        String s = "foo";
        Object o = (Object)s;
        if (s.equals(o)){
            System.out.print("AAA");
        }else {
            System.out.print("BBB");
        }
        if (o.equals(s)){
            System.out.print("CCC");
        }else {
            System.out.print("DDD");
        }
    }

    private static void unit3() {
        double d = Math.round(2.5 + Math.random());
        System.out.println((int)d +" " + (float)d);
    }

    private static void unit2() {
        float f = 42.0f;
        float[] f1 = new float[2];
        float[] f2 = new float[2];
        float[] f3 = f1;
        long x = 42;
        f1[0] = 42.0f;

        System.out.println(f1==f2);
        System.out.println(f1==f3);
        //System.out.println(f2==f1[1]); cast hatası
        System.out.println(x==f1[0]);
        System.out.println(f == f1[0]);
    }

    private static void unit1() {
        int x = 0;
        String a = (x > 0) ? "olmadı" : "oldu";
        System.out.println(a + "bitti");
    }
    private static void ucgenKontrol(){
        int x = new Scanner(System.in).nextInt();
        int y = new Scanner(System.in).nextInt();
        int z = new Scanner(System.in).nextInt();

        System.out.println(checkTriangle(x,y,z));
    }
    private static boolean checkTriangle(int x,int y,int z){
        return x + y + z == 180;
    }
}
