package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author cuixiaoshuang
 * @date 2019-12-26
 **/
public class UncommonFromSentencesTest {

    @Test
    public void testUncommonFromSentences() {
        String[] result = new UncommonFromSentences().uncommonFromSentences("apple", "apple banana");
        System.out.println(Arrays.toString(result));
    }
}