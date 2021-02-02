package com.company.OOP.Example1;

public class Main {
    public static void main(String[] args) {
        ClassA instance1 = new ClassA();
        instance1.method1();
        /*Constructor ClassA constructor çağırıldığı için
          ClassA is created yazar. Sonra method1 çağırıldığı için
          method1 is called with classa yazar. */

        ClassA instance2 = new ClassB();
        instance2.method1();
        /*ClassA çağırılır ve ClassA is created yazılır,
        çok biçimlilik olduğu için classa sınıfı, classb'ye benzetilir
        ve bu durumda classb constructor da çalışır. bu çıktıyla beraber
        classb is created yazılır.
        instance2.method1() çağırılırken önce super class'taki (ClassA)
        method1 çağırılır ve method1 is called with class a yazılır
        sonra super method dışında hazılan method1 is called with classb yazılır */

        ClassA instance3 = new ClassB();
        //instance3.method2();
        /* ClassA içerisinde method2 isimli bir metod bulunmadığı için
        derive edilmiş classb'de olmasına rağmen, obje tipi classa olduğu için
        metod 2 görünmez ve derleme sürecinde can not resolved hatası verir.*/

        ClassA instance4 = new ClassC();
        ClassB instance5 = (ClassB)(instance4);
        /* classa = new classc derken hem class a'nın hem de kalıtılan classc'nin
        default constructor değerlerini alır ve çıktıya sırasıyla
        classa is created ve classc is created yazdırır.
        Sonrasında classB'yi instance4'e eşitlerken classB objesine cast etmeye
        çalıştığımız için classcastexception alırız.*/

        ClassA instance6 = new ClassB(2,3);
        /*ClassB'nin constructor'ları arasında 2 parametre alma durumu olduğu için
         casting işleminde bir sorun ile karşılaşımaz. polymorphism ile ClassA objesi
         classb'ye eşitlenir.
         n'ye karşılık gelen 2 değeri superclass'a (classa)aktarılır
         m'ye karşılık gelen 3 değeri ise classb'de kalır ve çıktı şu şekilde olur :
         classA is created with n:2
         classB is created with m:3*/

        ClassA instance7 = new ClassC();
        ((ClassC)instance7).method3();

        /*ilk satırda classA ile classC çokbiçimlilik ile eşitlenir
        bu doğrulduda her iki default constructor'daki kod kısmı çalışır :
        classA is created
        classc is created
        normalde classA objesinden türeyen instance7 değişkenimizde method3 tanımlı değildir.
        ancak (ClassC)eklemesi yaparak objemizi classc'ye cast ederiz ve bu doğrultuda classc'nin
        içindeki method3 çağırılabilirhale gelir.
        method1 is called with classc
        method1 is called with classa*/
    }
}
