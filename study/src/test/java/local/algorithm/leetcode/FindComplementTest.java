package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class FindComplementTest {

    @Test
    public void testFindComplement() {
        int result = new FindComplement().findComplement(5);
        assertEquals(result, 2);

        result = new FindComplement().findComplement(1);
        assertEquals(result, 0);

        result = new FindComplement().findComplement(0b111100001111);
        assertEquals(result, 0b11110000);
    }
}