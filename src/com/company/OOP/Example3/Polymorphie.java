package com.company.OOP.Example3;

public class Polymorphie {
    interface I<T> {
        A f(T t);
    }
    static class A {
        void f(A a){
            System.out.println("A.f(A");
            a.f(this);
        }
        static B g(A a,B b) throws Ex{
            System.out.println("A.g(A, B)");
            if (a == b)
                throw new Ex();

            return (B) a;
        }
    }
    static class B extends A {
        void f(A a){
            System.out.println("B.f(A)");
        }
        static B g(B b,A a){
            System.out.println("B.g(B,A)");
            return b;
        }
    }
    static class C extends B implements I<B>{
        public void f(A a){
            System.out.println("C.f(A)");
            f((B) a);
        }
        @Override
        public A f(B b) {
            System.out.println("C.f(B)");
            return b;
        }
    }
    static class Ex extends Exception{
        static void g(I<B> i){
            System.out.println("E.g(I)");
            A a = i.f(new B());
            a.f(null);
        }
    }

    public static void main(String[] args) throws Ex{
        A a = new A();
        B b = new B();
        A ab = new B();
        C c = new C();


        ab.f(a); //b.F(A)
        a.f(ab);//A.f(A)
                  //B.f(A)
        //A.g(a,b);//Cannot cast to class B
        //a.g(b,b); //static member accessed via reference
        c.f(c.f(b)); //C.f(B)
                     //C.f(A)
                     //C.f(B)


        //B.g(b,b);//ambiguous method call
        //Ex.g((B bb)->B.g(bb,a)); //E.g(I)
                                 //B.g(B,A)
                                 //B.f(A)

    }
}
