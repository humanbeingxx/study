package local.algorithm.leetcode;

import org.testng.annotations.Test;

/**
 * @author cuixiaoshuang
 * @date 2020-02-12
 **/
public class CharFrequencySortTest {

    @Test
    public void testFrequencySort() {
        String result = new CharFrequencySort().frequencySort("abcbccca");
        System.out.println(result);
    }
}