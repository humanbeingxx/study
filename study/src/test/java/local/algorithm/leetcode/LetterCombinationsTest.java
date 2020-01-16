package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/17 1:17
 */
public class LetterCombinationsTest {

    @Test
    public void testLetterCombinations() {
        List<String> result = new LetterCombinations().letterCombinations("1234");
        System.out.println(result);
    }
}