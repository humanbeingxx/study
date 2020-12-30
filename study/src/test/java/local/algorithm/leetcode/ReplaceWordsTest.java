package local.algorithm.leetcode;

import org.testng.annotations.Test;

public class ReplaceWordsTest {

    @Test
    public void testTree() {
        ReplaceWords.Node root = new ReplaceWords.Node(' ');
        root.insert("abc");
        root.insert("bc");
        root.insert("ab");
        root.insert("abcd");
        String prefix = root.searchPrefix("bcd");
        System.out.println(prefix);
    }

}