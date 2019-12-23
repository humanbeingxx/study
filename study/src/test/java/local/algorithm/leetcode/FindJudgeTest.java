package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-23
 **/
public class FindJudgeTest {

    @Test
    public void testFindJudge() {
        int judge = new FindJudge().findJudge(2, new int[][]{{1, 2}});
        assertEquals(judge, 2);

        judge = new FindJudge().findJudge(3, new int[][]{{1, 3}, {2, 3}});
        assertEquals(judge, 3);

        judge = new FindJudge().findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}});
        assertEquals(judge, -1);
    }
}