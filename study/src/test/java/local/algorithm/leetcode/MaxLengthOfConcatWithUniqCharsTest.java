package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MaxLengthOfConcatWithUniqCharsTest {

    @Test
    public void testMaxLength1() {
        int result = new MaxLengthOfConcatWithUniqChars().maxLength(Lists.newArrayList("abcdefghijklmnopqrstuvwxyz"));
        assertEquals(result, 26);
    }

    @Test
    public void testMaxLength2() {
        int result = new MaxLengthOfConcatWithUniqChars().maxLength(Lists.newArrayList(
                "cha", "r", "act", "ers"));
        assertEquals(result, 6);
    }

    @Test
    public void testMaxLength9() {
        int result = new MaxLengthOfConcatWithUniqChars().maxLength(Lists.newArrayList(
                "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"));
        assertEquals(result, 16);
    }

    @Test
    public void testToBit() {
        MaxLengthOfConcatWithUniqChars func = new MaxLengthOfConcatWithUniqChars();
        System.out.println(Integer.toBinaryString(func.toBit("abcdefg")));
        System.out.println(Integer.toBinaryString(func.toBit("abcdefge")));
    }
}