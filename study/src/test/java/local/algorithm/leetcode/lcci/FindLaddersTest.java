package local.algorithm.leetcode.lcci;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/6/23 17:22
 */
public class FindLaddersTest {

    @Test
    public void testFindLadders() {
        List<String> result = new FindLadders().findLadders("hit", "cog", Lists.newArrayList("hot", "dot", "dog", "lot", "log"));
        System.out.println(result);
    }
}