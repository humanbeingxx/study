package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/15 20:59
 */
public class RepeatedStringMatchTest {

    @Test
    public void testRepeatedStringMatch() {
        System.out.println(new RepeatedStringMatch().repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(new RepeatedStringMatch().repeatedStringMatch("abcd", "cdabcdabe"));
        System.out.println(new RepeatedStringMatch().repeatedStringMatch("ab", "abab"));

    }
}