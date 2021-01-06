package local.algorithm;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class PredictTheWinnerTest {

    @Test
    public void testPredictTheWinner1() {
        boolean result = new PredictTheWinner().predictTheWinner(new int[]{1, 5, 2});
        assertFalse(result);
    }
}