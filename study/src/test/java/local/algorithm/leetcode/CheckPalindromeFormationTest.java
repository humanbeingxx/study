package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckPalindromeFormationTest {

    @Test
    public void testCheckPalindromeFormation1() {
        boolean result = new CheckPalindromeFormation().checkPalindromeFormation("a", "b");
        assertTrue(result);
    }

    @Test
    public void testCheckPalindromeFormation2() {
        boolean result = new CheckPalindromeFormation().checkPalindromeFormation("ulacfd", "jizalu");
        assertTrue(result);
    }

    @Test
    public void testCheckPalindromeFormation3() {
        boolean result = new CheckPalindromeFormation().checkPalindromeFormation("abcce", "dccba");
        assertTrue(result);
    }

    @Test
    public void testCheckPalindromeFormation4() {
        boolean result = new CheckPalindromeFormation().checkPalindromeFormation("abdef", "fecab");
        assertTrue(result);
    }

    @Test
    public void testCheckPalindromeFormation5() {
        boolean result = new CheckPalindromeFormation().checkPalindromeFormation("pvhmupgqeltozftlmfjjde", "yjgpzbezspnnpszebzmhvp");
        assertTrue(result);
    }

    @Test
    public void testCheckPalindromeFormation6() {
        boolean result = new CheckPalindromeFormation().checkPalindromeFormation("edjjfmltfzotleqgpumhvp", "pvhmzbezspnnpszebzpgjy");
        assertTrue(result);
    }
}