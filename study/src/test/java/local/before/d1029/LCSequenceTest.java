package local.before.d1029;

import org.apache.commons.lang3.tuple.Pair;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/29 上午12:26
 **/
public class LCSequenceTest {

    @Test
    public void testLcs() {
        String str1 = "abcdef";
        String str2 = "AbcdEf";

        int lcs = LCSequence.length(str1, str2);

        Assert.assertEquals(lcs, 3);
    }

    @Test
    public void testPos() {
        String str1 = "abcdef";
        String str2 = "AbcdEfabcdefg";

        Pair<Integer, Integer> pos = LCSequence.pos(str1, str2);
        System.out.println(pos);

    }
}