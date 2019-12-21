package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/21 19:44
 */
public class MostCommonValidWordTest {

    @Test
    public void testMostCommonWord() {
        String result = new MostCommonValidWord().mostCommonWord("Bob hit a  ball, the hit BALL flew far after it was  hit.", new String[]{"hit"});
        assertEquals(result, "ball");
    }
}