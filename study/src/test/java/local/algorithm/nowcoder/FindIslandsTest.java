package local.algorithm.nowcoder;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindIslandsTest {

    @Test
    public void testSolve() {
        int result = new FindIslands().solve(new char[][]{
                {'1', '1', '0', '0', '0'}, {'0', '1', '0', '1', '1'}, {'0', '0', '0', '1', '1'}, {'0', '0', '0', '0', '0'}, {'0', '0', '1', '1', '1'}});
        Assert.assertEquals(result, 3);
    }
}