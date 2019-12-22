package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/22 17:43
 */
public class CountAndSayTest {

    @Test
    public void testCountPre() {
        String result = new CountAndSay().countPre("21");
        assertEquals(result, "1211");

        result = new CountAndSay().countPre("1211");
        assertEquals(result, "111221");
    }

    @Test
    public void testCountAndSay() {
        String result = new CountAndSay().countAndSay(4);
        assertEquals(result, "1211");

        result = new CountAndSay().countAndSay(10);
        assertEquals(result, "13211311123113112211");

        result = new CountAndSay().countAndSay(20);
        assertEquals(result, "11131221131211132221232112111312111213111213211231132132211211131221131211221321123113213221123113112221131112311332211211131221131211132211121312211231131112311211232221121321132132211331121321231231121113112221121321133112132112312321123113112221121113122113121113123112112322111213211322211312113211");
    }
}