// Exercise 2: E-commerce Platform Search Function
Scenario: 
You are working on the search functionality of an e-commerce platform. The search needs to be optimized for fast performance.


public class Product {

    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product ID : " + productId +
                ", Name : " + productName +
                ", Category : " + category;
    }
}


public class Linearsearch {
    public static Product Search(Product [] products , int id){
        for(Product product : products){
            if(product.getProductId()== id){
                return product;
            }
        }
        return null;
    }
}


public class BinarySearch {
    public  static  Product Binary(Product [] products , int id){
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (products[mid].getProductId() == id) {
                return products[mid];
            }

            if (products[mid].getProductId() < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return null;

    }
}


import  java.util.*;
public class Main {
    public static void main(String[] args) {

        Product[] products = {

                new Product(105, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Fashion"),
                new Product(101, "Phone", "Electronics"),
                new Product(104, "Watch", "Accessories"),
                new Product(103, "Headphones", "Electronics")

        };

        Product linearResult = Linearsearch.Search(products, 104);

        System.out.println("Linear Search Result:");
        System.out.println(linearResult);

        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));


        Product Binarysearch = BinarySearch.Binary(products, 103);

        System.out.println("Binary Search result");
        System.out.println(Binarysearch);
    }
}
