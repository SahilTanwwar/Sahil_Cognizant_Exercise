public class Logger {
    private static Logger obj;

    private Logger(){};

    public static  Logger getInstance(){

        if(obj == null){
            obj = new Logger();
        }
        return obj;
    }

    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        System.out.println(l1 == l2);

    }

}

