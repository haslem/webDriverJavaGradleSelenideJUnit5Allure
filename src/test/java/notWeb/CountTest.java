package notWeb;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CountTest {

    Count testCount;

    @BeforeEach
    public void setup(){
        System.out.println("testing instance is created");
        testCount = new Count(4, 5);
    }

    @Test
    void sumArbitraryNumbers() {
        Assertions.assertEquals(19, testCount.sumArbitraryNumbers(10, 9));
    }

    @Test
    void sumBuiltInNumbers() {
        Assertions.assertEquals(9, testCount.sumBuiltInNumbers());
    }

    @AfterEach
    public void afterEach(){
        System.out.println("After each");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("After all");
    }


}