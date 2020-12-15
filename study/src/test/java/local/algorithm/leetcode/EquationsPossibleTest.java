package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EquationsPossibleTest {

    @Test
    public void testEquationsPossible1() {
        boolean result = new EquationsPossible().equationsPossible(new String[]{"a==b", "b!=a"});
        assertFalse(result);
    }

    @Test
    public void testEquationsPossible2() {
        boolean result = new EquationsPossible().equationsPossible(new String[]{"b==a", "a==b"});
        assertTrue(result);
    }

    @Test
    public void testEquationsPossible3() {
        boolean result = new EquationsPossible().equationsPossible(new String[]{"a==b", "b==c", "a==c"});
        assertTrue(result);
    }

    @Test
    public void testEquationsPossible4() {
        boolean result = new EquationsPossible().equationsPossible(new String[]{"a==b", "b!=c", "c==a"});
        assertFalse(result);
    }

    @Test
    public void testEquationsPossible5() {
        boolean result = new EquationsPossible().equationsPossible(new String[]{"c==c", "b==d", "x!=z"});
        assertTrue(result);
    }

    @Test
    public void testEquationsPossible6() {
        boolean result = new EquationsPossible().equationsPossible(new String[]{"c!=c"});
        assertFalse(result);
    }

    @Test
    public void testEquationsPossible7() {
        boolean result = new EquationsPossible().equationsPossible(new String[]{"a==b", "e==c", "b==c", "a!=e"});
        assertFalse(result);
    }
}