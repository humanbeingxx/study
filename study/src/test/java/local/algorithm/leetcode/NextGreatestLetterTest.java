package local.algorithm.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-27
 **/
public class NextGreatestLetterTest {

    @Test
    public void testNextGreatestLetter() {
        char result = new NextGreatestLetter().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a');
        assertEquals(result, 'c');

        result = new NextGreatestLetter().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c');
        assertEquals(result, 'f');

        result = new NextGreatestLetter().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd');
        assertEquals(result, 'f');

        result = new NextGreatestLetter().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'z');
        assertEquals(result, 'c');


    }
}