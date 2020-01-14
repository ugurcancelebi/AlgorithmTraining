package com.company.DataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ProductData implements Comparable<ProductData>{
    private String productName;
    private int productModel;
    private double productPrice;

    ProductData(String productName, int productModel) {
        this.productName = productName;
        this.productModel = productModel;
    }

    ProductData(String productName, int productModel, double productPrice) {
        this.productName = productName;
        this.productModel = productModel;
        this.productPrice = productPrice;
    }

    String getProductName() {
        return productName;
    }

    int getProductModel() {
        return productModel;
    }

    double getProductPrice() {
        return productPrice;
    }

    @Override
    public int compareTo(ProductData productData) {
        return Integer.compare(this.getProductModel(),productData.getProductModel());
    }
}
class ProductComparator implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        ProductData pData1 = (ProductData) o;
        ProductData pData2 = (ProductData) t1;
        if (pData1.getProductPrice() == 0 && pData2.getProductPrice() == 0)
            return pData1.getProductModel() - pData2.getProductModel();
        else
            return (int)pData1.getProductPrice() - (int)pData2.getProductPrice();
    }
}
public class ComparatorEx {
    public static void main(String[] args) {
        List<ProductData> productDataList = new ArrayList<>();
        productDataList.add(new ProductData("Mercedes Benz",2010));
        productDataList.add(new ProductData("BMW",2011));
        productDataList.add(new ProductData("Opel",2009));
        Collections.sort(productDataList,new ProductComparator());
        for (ProductData data : productDataList){
            System.out.println("Sorted Car List by Model : " + data.getProductName() + " " + data.getProductModel());
        }
        List<ProductData> productData = new ArrayList<>();
        productData.add(new ProductData("IBM",2006,1999));
        productData.add(new ProductData("HP",2012,3999));
        productData.add(new ProductData("DELL",2013,2999));
        Collections.sort(productData,new ProductComparator());
        for (ProductData data : productData){
            System.out.println("Sorted Computer List by Price : " + data.getProductName()+ " " + data.getProductModel()
                    + " " + data.getProductPrice());
        }
    }
}
class Brand implements Comparable<Brand> {
    private String brand;
    private int height;
    Brand(String brand,int height){
        this.brand = brand;
        this.height = height;
    }

    String getBrand() {
        return brand;
    }

    int getHeight() {
        return height;
    }

    @Override
    public int compareTo(Brand brand) {
        return Integer.compare(this.getHeight(), brand.getHeight());
    }
}
class ComparableEx{
    public static void main(String[] args) {
        Brand brand = new Brand("Apple",15);
        Brand brand1 = new Brand("Microsoft",12);
        if (brand.compareTo(brand1) > 0)
            System.out.println(brand.getBrand()+ " " + brand.getHeight() + " is Better");
        else if (brand.compareTo(brand1) == 0)
            System.out.println("DRAW");
        else
            System.out.println(brand1.getBrand()+ " " + brand1.getHeight() + " is Better");
    }
}

