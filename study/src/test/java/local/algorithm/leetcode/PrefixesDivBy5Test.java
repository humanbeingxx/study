package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class PrefixesDivBy5Test {

    @Test
    public void testPrefixesDivBy51() {
        List<Boolean> result = new PrefixesDivBy5().prefixesDivBy5(new int[]{0,1,1,0,1,0,1});
        System.out.println(result);
    }
}