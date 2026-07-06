// Exercise 3: Sorting Customer Orders
Scenario: 
You are tasked with sorting customer orders by their total price on an e-commerce platform. This helps in prioritizing high-value orders.




import  java.util.*;
public class Main {
    public static void printOrders(Order[] orders) {

        for (Order order : orders) {
            System.out.println(order);
        }

        System.out.println();
    }
    public static void main(String[] args) {
        Order [] order1 =
                {
                        new Order(101, "Rahul", 1200),
                        new Order(102, "Aman", 4500),
                        new Order(103, "Priya", 1800),
                        new Order(104, "Neha", 3000),
                        new Order(105, "Rohan", 900)
                };

        Order [] order2 = {
                new Order(101, "Rahul", 1200),
                new Order(102, "Aman", 4500),
                new Order(103, "Priya", 1800),
                new Order(104, "Neha", 3000),
                new Order(105, "Rohan", 900)
        };

        System.out.println("Original Orders:");
        printOrders(order1);

        BubbleSort.Bubblesort(order1);

        System.out.println("After Bubble Sort:");
        printOrders(order1);

        System.out.println("Original Orders:");
        printOrders(order2);

        QuickSort.quickSort(order2,0, order2.length-1);

        System.out.println("After Bubble Sort:");
        printOrders(order2);


    }
}


public class Order {
    int OrderID;
    String customerName;
    int totalPrice;

    public  Order(int OrderID ,String customerName ,int totalPrice){
        this.OrderID =OrderID;
        this.customerName =customerName;
        this.totalPrice =totalPrice;
    }

    public int getTotalPrice(){
        return  totalPrice;
    }

    @Override
    public String toString() {
        return "Order ID: " + OrderID +
                ", Customer: " + customerName +
                ", Total Price: " + totalPrice;
    }
}


public class BubbleSort {
    public static  void Bubblesort(Order [] order){
        int n= order.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(order[j].getTotalPrice() > order[j+1].getTotalPrice()){
                    Order temp = order[j];
                    order[j] =order[j+1];
                    order[j+1] = temp;
                }
            }
        }
    }


}

public class QuickSort {
    public static void quickSort(Order [] orders , int l ,int r){
        if(l<r){
            int pi = pivot(orders ,  l , r);

            quickSort(orders, l, pi-1);
            quickSort(orders , pi+1, r);
        }
    }
    public  static  int pivot(Order [] orders , int l , int r){
        int pivot = orders[r].getTotalPrice();
        int i=l-1;
        for(int j=l;j<r;j++){
            if(orders[j].getTotalPrice() < pivot){
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i+1];
        orders[i+1] = orders[r];
        orders[r] = temp;

        return i+1;
    }
}


