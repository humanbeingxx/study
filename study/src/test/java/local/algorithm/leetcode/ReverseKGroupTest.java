package local.algorithm.leetcode;

import local.algorithm.leetcode.common.ListNode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseKGroupTest {

    @Test
    public void testReverseKGroup1() {
        ListNode list = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6,
                                                        new ListNode(7)))))));
        Assert.assertEquals(new ReverseKGroup().reverseKGroup(list, 2).show(), "2143657");
    }

    @Test
    public void testReverseKGroup2() {
        ListNode list = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6,
                                                        new ListNode(7)))))));
        Assert.assertEquals(new ReverseKGroup().reverseKGroup(list, 3).show(), "3216547");
    }

    @Test
    public void testReverseKGroup3() {
        ListNode list = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6,
                                                        new ListNode(7)))))));
        Assert.assertEquals(new ReverseKGroup().reverseKGroup(list, 4).show(), "4321567");
    }

    @Test
    public void testReverseKGroup4() {
        ListNode list = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6,
                                                        new ListNode(7)))))));
        Assert.assertEquals(new ReverseKGroup().reverseKGroup(list, 16).show(), "2143657");
    }
}