package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-31
 **/
public class RemoveNeighbourDuplicatesTest {

    @Test
    public void testRemoveDuplicates() {
        String result = new RemoveNeighbourDuplicates().removeDuplicates("abbaca");
        assertEquals(result, "ca");
    }
}