package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CalcEquationTest {

    @Test
    public void testCalcEquation1() {
        double[] result = new CalcEquation().calcEquation(
                Lists.newArrayList(
                        Lists.newArrayList("b", "c"),
                        Lists.newArrayList("b", "d"),
                        Lists.newArrayList("a", "b")
                ),
                new double[]{2, 4, 2},
                Lists.newArrayList(
                        Lists.newArrayList("a", "c"),
                        Lists.newArrayList("c", "a")
                )
        );
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void testCalcEquation2() {
        double[] result = new CalcEquation().calcEquation(
                Lists.newArrayList(
                        Lists.newArrayList("a", "c"),
                        Lists.newArrayList("b", "e"),
                        Lists.newArrayList("c", "d"),
                        Lists.newArrayList("e", "d")
                ),
                new double[]{2, 3, 0.5, 5},
                Lists.newArrayList(
                        Lists.newArrayList("a", "b"),
                        Lists.newArrayList("c", "a")
                )
        );
        System.out.println(Arrays.toString(result));
    }
}