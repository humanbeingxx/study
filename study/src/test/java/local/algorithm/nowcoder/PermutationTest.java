package local.algorithm.nowcoder;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class PermutationTest {

    @Test
    public void testPermutation1() {
        ArrayList<String> result = new Permutation().permutation("aab");
        System.out.println(result);
    }
}