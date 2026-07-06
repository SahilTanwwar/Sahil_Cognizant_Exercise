//Exercise 1: Inventory Management System
Scenario: 
You are developing an inventory management system for a warehouse. Efficient data storage and retrieval are crucial.


public class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price){
        this.productId = productId;
        this.productName= productName;
        this.price =price;
        this.quantity = quantity;
    }

    public int getProductId(){
        return productId;
    }

    public void  setProductName(String productName){
        this.productName = productName;
    }
    public void setQuantity(int quantity){
        this.quantity =quantity;
    }
    public  void  setPrice(double price){
        this.price =price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
                ", Name: " + productName +
                ", Quantity: " + quantity +
                ", Price: ₹" + price;
    }
}



import  java.util.HashMap;

public class InventoryManagement {

    private  HashMap<Integer, Product> inventory;

    public  InventoryManagement(){
        inventory= new HashMap<>();
    }

    public void  addProduct(Product product){
        inventory.put(product.getProductId(), product);
        System.out.println("Product added succefully");
    }
    public  void delete(int ProductId){
        if(inventory.remove(ProductId) != null){
            System.out.println("Product deleted succesfull");
        }else {
            System.out.println("Product not found");
        }
    }

    public  void updateProduct(int productId, String name, int quantity, double price){
        Product product = inventory.get(productId);

        if(product != null){
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);

            System.out.println("Product Updated Successfully.");
        }else{
            System.out.println("Product Not Found");
        }
    }

    public void display(){
        if(inventory.isEmpty()) {
            System.out.println("Inventory is Empty");
            return;
        }
            for(Product product : inventory.values()){
                System.out.println(product);
            }
    }

    public static void main(String[] args) {
        InventoryManagement ims = new InventoryManagement();

        ims.addProduct(new Product(101, "Laptop", 10, 60000));
        ims.addProduct(new Product(102, "Mouse", 40, 500));
        ims.addProduct(new Product(103, "Keyboard", 20, 1500));

        System.out.println("\nInventory:");
        ims.display();

        System.out.println("\nUpdating Product...");
        ims.updateProduct(102, "Wireless Mouse", 35, 700);

        System.out.println("\nInventory:");
        ims.display();


        System.out.println("\nDeleting Product...");
        ims.delete(103);

        System.out.println("\nFinal Inventory:");
        ims.display();
    }
}
