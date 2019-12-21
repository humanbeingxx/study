package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/21 19:55
 */
public class LongestWordTest {

    @Test
    public void testLongestWord() {
        String result1 = new LongestWord().longestWord(new String[]{"w","wo","wor","worl", "world"});
        assertEquals(result1, "world");

        String result2 = new LongestWord().longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"});
        assertEquals(result2, "apple");
    }

    @Test
    public void testConstructOne() {
        LongestWord.Node root = new LongestWord.Node('-');
        new LongestWord().constructOne(root, "apple");
        show(root);
    }

    private void show(LongestWord.Node node) {
        System.out.println(node.c + " -> " + node.isEnd);
        for (LongestWord.Node next : node.next.values()) {
            show(next);
        }
    }

    @Test
    public void testConstructTree() {
        LongestWord.Node root = new LongestWord().constructTree(new String[]{"apple", "app", "appe", "aple", "bapp"});
        show(root);
    }

    @Test
    public void testCheck() {
        LongestWord check = new LongestWord();
        LongestWord.Node root = check.constructTree(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"});
        assertTrue(check.check(root, "app"));
        assertFalse(check.check(root, "banana"));
        assertFalse(check.check(root, "appley"));
    }
}