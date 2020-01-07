package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2020-01-07
 **/
public class FreqAlphabetsTest {

    @Test
    public void testFreqAlphabets() {
        String result = new FreqAlphabets().freqAlphabets("10#11#12");
        assertEquals(result, "jkab");

        result = new FreqAlphabets().freqAlphabets("1326#");
        assertEquals(result, "acz");

        result = new FreqAlphabets().freqAlphabets("262626262626");
        assertEquals(result, "bfbfbfbfbfbf");

        result = new FreqAlphabets().freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#");
        assertEquals(result, "abcdefghijklmnopqrstuvwxyz");
    }
}