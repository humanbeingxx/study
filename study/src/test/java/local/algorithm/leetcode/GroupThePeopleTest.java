package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/12 23:56
 */
public class GroupThePeopleTest {

    @Test
    public void testGroupThePeople() {
        List<List<Integer>> result = new GroupThePeople().groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
        System.out.println(result);
    }

}