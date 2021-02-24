package notWeb;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CountTest {

    Count testCount;

    @BeforeEach
    public void setup(){
        System.out.println("testing instance is created");
        testCount = new Count(4, 5);
    }

    @Test
    @DisplayName("Renamed. Sum two numbers")
//    @ParameterizedTest
//    @ValueSource(ints = {10, 9, 10})
    void sumArbitraryNumbers() {
        Assertions.assertEquals(19, testCount.sumArbitraryNumbers(10, 9));
    }

    @Test
    @DisplayName("My renamed test")
    void sumBuiltInNumbers() {
        Assertions.assertEquals(9, testCount.sumBuiltInNumbers());
    }

    @AfterEach
    public void afterEach(){
        System.out.println("After each");
    }

    //afterAll is static because it doesn't create instance of a test
    @AfterAll
    public static void afterAll(){
        System.out.println("After all");
    }


}