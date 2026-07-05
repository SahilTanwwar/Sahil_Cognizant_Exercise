interface PaymentProcessor{
    void processPayment(double amount);
}

class Paypalgateway{
    public  void makepayment(double amount){
        System.out.println("Payment of ₹" + amount +
                " processed via PayPal");
    }
}

class Stripe {
    public void charge(double amount) {
        System.out.println("Payment of ₹" + amount +
                " processed via Stripe");
    }
}

  class paypaladapter implements PaymentProcessor{
    private Paypalgateway paypalgateway;

    public paypaladapter(){
        this.paypalgateway = new Paypalgateway();
    }

    public void processPayment(double amount){
        paypalgateway.makepayment(amount);
    }
}
  class StripeAdaptor implements PaymentProcessor{
    private Stripe stripe;

    public StripeAdaptor(){
        this.stripe = new Stripe();
    }

    public void processPayment(double amount){
        stripe.charge(amount);
    }
}

public  class Adapter{
    public static void main(String[] args) {
        PaymentProcessor p1 = new paypaladapter();
        PaymentProcessor p2 = new StripeAdaptor();

        p1.processPayment(1000);
        p2.processPayment(1001);
    }
}
