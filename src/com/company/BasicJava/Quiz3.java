package com.company.BasicJava;

public class Quiz3 {

    public static void finder(boolean x,boolean y){
        if (x){
            System.out.println("X");
        } else if(x && y){
            System.out.println("X && Y");
        } else {
            if (!y){
                System.out.println("!Y");
            } else {
                System.out.println("Z");
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {4,5,6};
        int[] c = {1};
        double[] d = {1,2,3};
        double[] e = {2,3};

        double[][] arr5 = {e,d};
        int[][] arr1 = {a,b};
        int[][] arr2 = {a,b,c};
        int[][] arr7 = {a,{1,2,3},b,c};

        System.out.println(arr5 + " " + arr1 + " " + arr2 + " " + arr7 );
    }
    public static void d(){
        int x = 107;
        int res = --x % ++x;
        System.out.println(res);
    }
    public static void c(){
        int arr[] = {2,8,3,1,9};
        int s = 0;
        int temp;

        while (s < 3){
            for (int i = 0;i< arr.length-1;i++){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
            s++;
        }
        for (int i =0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void  b(){
        int[][] a = {{1,7,-2},{3,2,1},{4,8,9}};
        int[][] b = {{-3,2,4},{-2,-1,2},{2,5,-1}};
        int result = 0;
        for (int i = 0;i< a.length;i++){
            result += a[i][i] * b[i][a.length-i-1];
        }
        System.out.println(result);
    }
    public static void a(){
        int[][][] table = {{ {1 ,2 ,3 ,5},{0,57,88,73,91}},{{38,-75,-42,19,66},{-10,13,34}}};
        double[]  myArray = new double[4];
        int sum = 0;
        int index = 0;
        System.out.println("Value = "+ table.length+ table[0].length + table[0][0].length);

        for (int i = 0;i< table.length;i++){
            for (int j = 0;j<table[0].length;j++){
                sum = 0;
                for (int k = 0;k<table[0][0].length;k++){
                    sum += table[i][j][i];
                }
            }
        }
    }
}
