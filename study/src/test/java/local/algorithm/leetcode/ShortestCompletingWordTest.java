package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class ShortestCompletingWordTest {

    @Test
    public void testShortestCompletingWord() {
        String result = new ShortestCompletingWord().shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"});
        assertEquals(result, "steps");

        result = new ShortestCompletingWord().shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"});
        assertEquals(result, "pest");

        result = new ShortestCompletingWord().shortestCompletingWord("iMSlpe4", new String[]{"claim","consumer","student","camera","public","never","wonder","simple","thought","use"});
        assertEquals(result, "simple");

        result = new ShortestCompletingWord().shortestCompletingWord("p", new String[]{"defense","second","point","property","thought","tell","stop","enjoy","seek","make"});
        assertEquals(result, "stop");
    }
}