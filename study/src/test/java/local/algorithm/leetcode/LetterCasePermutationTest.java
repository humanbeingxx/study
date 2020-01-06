package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author cuixiaoshuang
 * @date 2020-01-06
 **/
public class LetterCasePermutationTest {

    @Test
    public void testLetterCasePermutation() {
        List<String> result = new LetterCasePermutation().letterCasePermutation("a1b2");
        assertTrue(result.containsAll(Lists.newArrayList("a1b2", "a1B2", "A1b2", "A1B2")));
        assertTrue(Lists.newArrayList("a1b2", "a1B2", "A1b2", "A1B2").containsAll(result));

        result = new LetterCasePermutation().letterCasePermutation("A1B2");
        assertTrue(result.containsAll(Lists.newArrayList("a1b2", "a1B2", "A1b2", "A1B2")));
        assertTrue(Lists.newArrayList("a1b2", "a1B2", "A1b2", "A1B2").containsAll(result));

        result = new LetterCasePermutation().letterCasePermutation("12345");
        assertEquals(result, Lists.newArrayList("12345"));

        result = new LetterCasePermutation().letterCasePermutation("3z4");
        assertEquals(result, Lists.newArrayList("3z4", "3Z4"));

        result = new LetterCasePermutation().letterCasePermutation("3Z4");
        assertEquals(result, Lists.newArrayList("3Z4", "3z4"));
    }
}