package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

public class RemoveDuplicateLettersTest {

    @Test
    public void testRemoveDuplicateLetters1() {
        String result = new RemoveDuplicateLetters().removeDuplicateLetters("cbacdcbc");
        System.out.println(result);
    }

    @Test
    public void testRemoveDuplicateLetters2() {
        String result = new RemoveDuplicateLetters().removeDuplicateLetters("abaaaa");
        System.out.println(result);
    }

    @Test
    public void random() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 200; i++) {
            stringBuilder.append((char)(random.nextInt(26) + 'a'));
        }
        System.out.println(stringBuilder.toString());
    }
}