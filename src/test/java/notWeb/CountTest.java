package notWeb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountTest {

    @Test
    void sumArbitraryNumbers() {

        Count testCount = new Count(4, 5);
        Assertions.assertEquals(9, testCount.sumBuiltInNumbers());
        Assertions.assertEquals(19, testCount.sumArbitraryNumbers(10, 9));
    }
}