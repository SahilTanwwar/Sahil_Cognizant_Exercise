import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MyServiceTest {

    @Mock
    private ExternalApi api;

    @InjectMocks
    private MyService myService;

    @Test
    public void testFetchData() {
        // Arrange - Mock the behavior of ExternalApi
        when(api.getData()).thenReturn("Mocked Data");

        // Act - Call the method under test
        String result = myService.fetchData();

        // Assert - Verify the result
        assertEquals("Mocked Data", result);
    }
}
