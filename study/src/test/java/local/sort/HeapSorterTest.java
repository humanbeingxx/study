package local.sort;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class HeapSorterTest {
    @Test
    public void testSort() throws Exception {
        Integer[] data = new Integer[]{5, 4, 3, 2, 1};
        new HeapSorter<Integer>().sort(data);
        System.out.println(Arrays.toString(data));
        Assert.assertEquals(new Integer[]{5, 4, 3, 2, 1}, data);
    }

    @Test
    public void testSort2() throws Exception {
        Integer[] data = new Integer[]{1, 4, 4, 2, 1};
        new HeapSorter<Integer>().sort(data);
        System.out.println(Arrays.toString(data));
        Assert.assertEquals(new Integer[]{4, 4, 2, 1, 1}, data);
    }

    @Test
    public void testSort3() throws Exception {
        class Data implements Comparable<Data> {

            public int index;

            public int value;

            public Data(int index, int value) {
                this.index = index;
                this.value = value;
            }

            @Override
            public int compareTo(Data o) {
                return value - o.value;
            }

            @Override
            public String toString() {
                return "Data{" +
                        "index=" + index +
                        ", value=" + value +
                        '}';
            }
        }


        Data[] data = new Data[]{new Data(0, 1), new Data(1, 1), new Data(2, 1), new Data(3, 1), new Data(4, 1)};
        new HeapSorter<Data>().sort(data);
        System.out.println(Arrays.toString(data));
    }

    @Test
    public void testMakeHeap() throws Exception {
        Integer[] data = new Integer[]{5, 4, 3, 2, 1};
        new HeapSorter<Integer>().makeHeap(data);
        System.out.println(Arrays.toString(data));
        Assert.assertEquals(new Integer[]{1, 2, 3, 5, 4}, data);
    }

    @Test
    public void testAdjust() throws Exception {
        Integer[] data = new Integer[]{5, 4, 3, 2, 1};
        new HeapSorter<Integer>().adjust(data, 0, 4);
        System.out.println(Arrays.toString(data));
    }

}