package com.company.BasicJava;

public class MyArray {
    int[][] a;
    public MyArray (int row,int col){
        a = new int[row][col];
    }
    public void fillArray(int num){
        for (int i = 0;i < a.length;i++){
            for (int j = 0;j< a[i].length;j++){
                a[i][j] = num;
            }
        }
    }
    public void multiplyWith(int num){
        for (int i = 0;i < a.length;i++){
            for (int j = 0;j< a[0].length;j++){
                a[i][j] *= num;
            }
        }
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(3,4);
        myArray.fillArray(3);
        MyArray myArray2 = new MyArray(5,7);
        myArray2.fillArray(157);

        myArray2.multiplyWith(myArray.a[2][2]);
        System.out.println(myArray2.a[1][0]);
    }
}
