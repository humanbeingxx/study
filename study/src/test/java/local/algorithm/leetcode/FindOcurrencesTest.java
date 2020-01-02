package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/2 21:51
 */
public class FindOcurrencesTest {

    @Test
    public void testFindOcurrences() {
        String[] result = new FindOcurrences().findOcurrences("alice is a good girl she is a good student", "a", "good");
        assertEquals(result, new String[]{"girl", "student"});

        result = new FindOcurrences().findOcurrences("we will we will rock you", "we", "will");
        assertEquals(result, new String[]{"we", "rock"});
    }
}