package local.before.d1026;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/10/26 下午10:21
 **/
public class ContinuousOnesTest {

    @Test
    public void testFind() {
        int[][] matrix = {{0, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 1, 0, 0}};
        List<List<Pair<Integer, Integer>>> result = ContinuousOnes.find(matrix);
        List<List<Pair<Integer, Integer>>> expected = Lists.newArrayList(
                Lists.newArrayList(Pair.of(0,1), Pair.of(1,0), Pair.of(1,1)),
                Lists.newArrayList(Pair.of(2,2), Pair.of(2,3)),
                Lists.newArrayList(Pair.of(3,0), Pair.of(3,1))
        );
        assertEqual(result, expected);
    }

    @Test
    public void testFind2() {
        int[][] matrix = new int[4][4];
        List<List<Pair<Integer, Integer>>> result = ContinuousOnes.find(matrix);
        List<List<Pair<Integer, Integer>>> expected = Lists.newArrayList();
        assertEqual(result, expected);
    }

    @Test
    public void testFind3() {
        int[][] matrix = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        List<List<Pair<Integer, Integer>>> result = ContinuousOnes.find(matrix);
        List<List<Pair<Integer, Integer>>> expected = Lists.newArrayList();
        expected.add(Lists.newArrayList());
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                List<Pair<Integer, Integer>> expectedOne = expected.get(0);
                expectedOne.add(Pair.of(i, j));
            }
        }
        assertEqual(result, expected);
    }

    private void assertEqual(List<List<Pair<Integer, Integer>>> actual, List<List<Pair<Integer, Integer>>> expected) {
        Assert.assertEquals(actual.size(), expected.size());
        for (int i = 0; i < actual.size(); i++) {
            List<Pair<Integer, Integer>> actualOne = actual.get(i);
            List<Pair<Integer, Integer>> expectedOne = expected.get(i);
            Comparator<Pair<Integer, Integer>> comparator = (o1, o2) -> {
                if (o1.getLeft().equals(o2.getLeft())) {
                    return o1.getRight().compareTo(o2.getRight());
                }
                return o1.getLeft().compareTo(o2.getLeft());
            };
            actualOne.sort(comparator);
            expectedOne.sort(comparator);

            Assert.assertEquals(actualOne, expectedOne);
        }
    }
}