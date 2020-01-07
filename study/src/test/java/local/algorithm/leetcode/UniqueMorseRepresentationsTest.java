package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class UniqueMorseRepresentationsTest {

    @Test
    public void testUniqueMorseRepresentations() {
        int result = new UniqueMorseRepresentations().uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
        assertEquals(result, 2);
    }
}