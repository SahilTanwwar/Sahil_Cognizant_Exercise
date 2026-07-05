
 interface  Notifier{
    void send();
}
class EmailNotifier implements Notifier{
  public  void send(){
        System.out.println("Sending notification via Email");
    }
}

 abstract class NotifierDecorator implements Notifier{
    private Notifier notifier;

    public  NotifierDecorator(Notifier notifier){
        this.notifier = notifier;
    }

    public  void send(){
        notifier.send();
    }
 }

 class SMSNotifierDecorator extends NotifierDecorator{
     public SMSNotifierDecorator(Notifier notifier) {
         super(notifier);
     }

     @Override
     public void send() {
         super.send();
         System.out.println("Sending notification via SMS");
     }
 }

 class SlackNotifierDecorator extends NotifierDecorator {

     public SlackNotifierDecorator(Notifier notifier) {
         super(notifier);
     }

     @Override
     public void send() {
         super.send();
         System.out.println("Sending notification via Slack");
     }
 }

public class DecoratorPatternExample {
    public static void main(String[] args) {
        System.out.println("Email Only:");

        Notifier email = new EmailNotifier();
        email.send();

        System.out.println("\nEmail + SMS:");
        Notifier sms =
                new SMSNotifierDecorator(
                        new EmailNotifier());

        System.out.println("\nEmail + SMS + Slack:");
        Notifier all =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        all.send();

    }
}
