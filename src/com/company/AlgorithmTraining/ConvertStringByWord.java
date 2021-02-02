package com.company.AlgorithmTraining;

import java.util.Scanner;

public class ConvertStringByWord {
    public static void main(String[] args) {
        System.out.print("Enter a text :");
        String text = new Scanner(System.in).nextLine();
        System.out.println(convertStringByWord(text));

    }

    private static String convertStringByWord(String str) {
        String reversed=""; //Başlangıçta boş bir ters kelime oluşturuyoruz. String'leri buraya ekleyeceğiz
        String[] words =str.split(" ");//Bir string array oluşturup her bir kelimeyi .split ile ayırarak diziye çeviriyoruz
        for(int i = 0;i< words.length;i++){//kelimeler dizisindeki her kelime için
            reversed += reverseWord(words[i]);//yeni bir metod çağır ve buradan dönen değeri tersKelime değişkenine ekle.
            //Java kütüphanelerindeki StringBuilder.reverse metodu da kullanılabilir.
        }
        return reversed;//
    }

    private static String reverseWord(String s) {
        //ters kelime için empty string
        String reverse = "";
        int length = s.length();//her bir karakter için count al

        for (int i = length - 1 ; i >= 0 ; i--)//en sondan başa her bir karakter için
            reverse = reverse + s.charAt(i);//en sondaki değeri al stringe ekle, bu sayede return edilen değer ters olacak

        return reverse + " ";//kelimeyi döndür
    }
}
