package com.company.OOP;

class data {
    private int show;
     void setShow(int show){
        this.show = show;
    }
     int getShow(){
        return show;
    }
}

class func{
    void doSum(){
        System.out.println("abc");
    }
}
class difOne extends func{
    @Override
    void doSum() {
        super.doSum();
    }
}
public class temp extends func{
    public static void main(String[] args) {
        data data = new data();
        data.setShow(2);
        System.out.println(data.getShow());
        func func1 = new difOne();
        func1.doSum();
    }
}
