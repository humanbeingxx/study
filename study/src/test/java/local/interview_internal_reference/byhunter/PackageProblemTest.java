package local.interview_internal_reference.byhunter;

import org.testng.annotations.Test;

import java.util.List;

public class PackageProblemTest {

    @Test
    public void testPutMost01() {
        int result = new PackageProblem().putMost01(8,
                new int[]{3, 5, 1, 2, 2},
                new int[]{4, 5, 2, 1, 3}
        );
        System.out.println(result);
    }

    @Test
    public void testPutMost() {
        List<Integer> result = new PackageProblem().putMostAll(
                8,
                new int[]{3, 5, 1, 2, 2},
                new int[]{4, 5, 2, 1, 3}
        );
        System.out.println(result);
    }

    @Test
    public void testPutMostMulti() {
        int result = new PackageProblem().putMostMulti(
                18,
                new int[]{3, 5, 1, 2, 2},
                new int[]{4, 5, 2, 1, 3},
                new int[]{2, 2, 2, 2, 2}
        );
        System.out.println(result);
    }
}