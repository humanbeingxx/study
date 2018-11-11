package local.before.d1104;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/4 17:21
 */
public class SkipListTest {

    @Test
    public void testList() {
        SkipList<Integer, String> list = new SkipList<>();
        System.out.println(list);
    }


    @Test
    public void testAdd() {
        SkipList<Integer, String> list = new SkipList<>();
        list.add(1, "this is 1");
        list.add(1, "this is 1");
        list.add(2, "this is 2");
        list.add(2, "this is 2");
        list.add(3, "this is 3");
        list.add(3, "this is 3");
    }

    @Test
    public void testSearch() {
        SkipList<Integer, String> list = new SkipList<>();
        list.add(1, "this is 1");
        list.add(2, "this is 2");
        list.add(3, "this is 3");
        list.add(4, "this is 4");
        list.add(5, "this is 5");
        list.add(6, "this is 6");

        String result1 = list.search(5);
        Assert.assertEquals(result1, "this is 5");

        String result2 = list.search(1);
        Assert.assertEquals(result2, "this is 1");

        String result3 = list.search(9);
        Assert.assertNull(result3);
    }

    @Test
    public void testSearchEmpty() {
        SkipList<Integer, String> list = new SkipList<>();
        String result1 = list.search(5);
        Assert.assertNull(result1);
        String result2 = list.search(1);
        Assert.assertNull(result2);
        String result3 = list.search(9);
        Assert.assertNull(result3);
    }

}