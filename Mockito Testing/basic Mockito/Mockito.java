Exercise 1-------->

  // ExternalApi Class----->

  public class ExternalApi {
    public String getData(){
        return "Real Data";
    }
}

// MyService Class------>

public class MyService {

    ExternalApi api;
    public MyService(ExternalApi api){
        this.api = api;
    }

    public String fetchData(){
        return  api.getData();
    }
}

--------------<---------------------------->-------------------
