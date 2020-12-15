package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ModifyStringTest {

    @Test
    public void testModifyString() {
        assertEquals(new ModifyString().modifyString("?zs"), "azs");
        assertEquals(new ModifyString().modifyString("j?qg??b"), "jaqgacb");
        assertEquals(new ModifyString().modifyString("??yw?ipkj?"), "abywaipkja");
    }
}