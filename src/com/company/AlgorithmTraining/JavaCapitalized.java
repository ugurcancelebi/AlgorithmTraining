package com.company.AlgorithmTraining;

import java.util.Scanner;

public class JavaCapitalized {
    public static void main(String[] args) {
        System.out.print("Enter a text : ");
        String text = new Scanner(System.in).nextLine();
        System.out.println("Converted : " + uppercaseString(text));

    }

    private static String uppercaseString(String text){
        String finalized = "";//bunu döndüreceğiz
        String[] arr = text.split(" ");//her bir kelimeye ayır
        for (int i = 0;i< arr.length;i++){//her bir kelime için
            String word = arr[i];//geçici değişken dizinin kelimesini gösteriyor
            if (word.charAt(i) == 'a' && word.charAt(i+1) == 'a') {//ilk kelime aa ile başlıyorsa direk kelimenin kendisini al
                finalized += word + " ";
                continue;
            }
            String temp = "";//gecici degisken
            for (int j = 0;j<word.length()-1;j++){//kelimedeki her karakter icin
                if (word.charAt(j) == 'a' && word.charAt(j+1) == 'a'){//eger iki tane a var ise
                    temp = word.substring(0,j)+(word.substring(j,j+1))+'A';//ikinci a'yi büyük yap
                    break;
                } else {//degilse direk kelimeyi al
                    temp = word;
                }
            }
            finalized += temp + " ";//güncel kelimeyi ekle
        }
        return finalized;//cümleyi döndür
    }
}
