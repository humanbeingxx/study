package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-27
 **/
public class DecodeStringTest {

    @Test
    public void testDecodeString1() {
        String result = new DecodeString().decodeString("3[a]2[bc]");
        assertEquals(result, "aaabcbc");
    }

    @Test
    public void testDecodeString2() {
        String result = new DecodeString().decodeString("3[a2[c]]");
        assertEquals(result, "accaccacc");
    }

    @Test
    public void testDecodeString3() {
        String result = new DecodeString().decodeString("2[abc]3[cd]ef");
        assertEquals(result, "abcabccdcdcdef");
    }

    @Test
    public void testDecodeString4() {
        String result = new DecodeString().decodeString("3[a]2[b4[F]c]");
        assertEquals(result, "aaabFFFFcbFFFFc");
    }

    @Test
    public void testDecodeString5() {
        String result = new DecodeString().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
        assertEquals(result, "aaabFFFFcbFFFFc");
    }

    @Test
    public void testDecodeString6() {
        String result = new DecodeString().decodeString("100[leetcode]");
        assertEquals(result, "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode");
    }
}