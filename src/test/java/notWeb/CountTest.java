package notWeb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountTest {

    Count testCount = new Count(4, 5);

    @Test
    void sumArbitraryNumbers() {

        Assertions.assertEquals(19, testCount.sumArbitraryNumbers(10, 9));
    }

    @Test
    void sumBuiltInNumbers() {
        Assertions.assertEquals(9, testCount.sumBuiltInNumbers());
    }




}