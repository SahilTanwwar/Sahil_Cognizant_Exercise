// Exercise1------------>

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class MyServiceTest {

    @Test
    void testExternalapi(){
         ExternalApi mockapi = mock(ExternalApi.class);

         when(mockapi.getData()).thenReturn("Mock Data");

         MyService  service = new MyService(mockapi);

         String result = service.fetchData();

         assertEquals("Mock Data" , result);
    }

}

----------------------------<------------------------------------------>---------------------
    // Exercise-2--------->

    import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;




public class MyServiceVerifyTest {

    @Test
    void  verifyTest(){

        ExternalApi mockapi=  mock(ExternalApi.class);

        when(mockapi.getData()).thenReturn("mock Data");

        MyService  service = new MyService(mockapi);
        
        service.fetchData();
        
        verify(mockapi).getData();
    }


}
