package local.sort;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

public class MergeSorterTest {
    @Test
    public void testSort() throws Exception {
        List<Integer> data = Lists.newArrayList(2, 1, 7, 5, 4, 0, 8);
        MergeSorter<Integer> sorter = new MergeSorter<>(data);
        sorter.sort();
        System.out.println(sorter.getOriginData());
    }

    @Test
    public void testMerge() throws Exception {
        List<Integer> data = Lists.newArrayList(5, 4, 3, 2, 1);
        MergeSorter<Integer> sorter = new MergeSorter<>(data);
        List<Integer> to = Lists.newArrayList(new Integer[6]);
        List<Integer> result = Lists.newArrayList(1, 3, 5, 2, 4, 6);
        sorter.merge(result, 0, 2, 5, to);
        System.out.println(to);
        System.out.println(result);
    }
}