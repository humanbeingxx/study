package local.algorithm.leetcode;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * @author cuixiaoshuang
 * @date 2019-12-19
 **/
public class ReadBinaryWatchTest {

    @Test
    public void testCompose() {
        Set<Integer> result = Sets.newHashSet();
        new ReadBinaryWatch().compose(0, 6, 6, result, 60);
        assertEquals(result, Sets.newHashSet(Lists.newArrayList()));

        result.clear();
        new ReadBinaryWatch().compose(0, 0, 6, result, 60);
        assertEquals(result, Sets.newHashSet(Lists.newArrayList(0)));
    }

    @Test
    public void testCompose2() {
        Set<Integer> result = Sets.newHashSet();
        new ReadBinaryWatch().compose(0, 1, 3, result, 12);
        assertEquals(result, Sets.newHashSet(Lists.newArrayList(1, 2, 4, 8)));

    }

    @Test
    public void testReadBinaryWatch0() {
        List<String> result = new ReadBinaryWatch().readBinaryWatch(0);
        result.sort(String::compareTo);
        List<String> expected = Lists.newArrayList("0:00");
        expected.sort(String::compareTo);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testReadBinaryWatch1() {
        List<String> result = new ReadBinaryWatch().readBinaryWatch(1);
        System.out.println(result);
        result.sort(String::compareTo);
        List<String> expected = Lists.newArrayList("1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32");
        expected.sort(String::compareTo);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testReadBinaryWatch4() {
        List<String> result = new ReadBinaryWatch().readBinaryWatch(4);
        System.out.println(result);
        result.sort(String::compareTo);
        List<String> expected = Lists.newArrayList("0:15", "0:23", "0:27", "0:29", "0:30", "0:39", "0:43", "0:45", "0:46", "0:51", "0:53", "0:54", "0:57", "0:58", "1:07", "1:11", "1:13", "1:14", "1:19", "1:21", "1:22", "1:25", "1:26", "1:28", "1:35", "1:37", "1:38", "1:41", "1:42", "1:44", "1:49", "1:50", "1:52", "1:56", "2:07", "2:11", "2:13", "2:14", "2:19", "2:21", "2:22", "2:25", "2:26", "2:28", "2:35", "2:37", "2:38", "2:41", "2:42", "2:44", "2:49", "2:50", "2:52", "2:56", "3:03", "3:05", "3:06", "3:09", "3:10", "3:12", "3:17", "3:18", "3:20", "3:24", "3:33", "3:34", "3:36", "3:40", "3:48", "4:07", "4:11", "4:13", "4:14", "4:19", "4:21", "4:22", "4:25", "4:26", "4:28", "4:35", "4:37", "4:38", "4:41", "4:42", "4:44", "4:49", "4:50", "4:52", "4:56", "5:03", "5:05", "5:06", "5:09", "5:10", "5:12", "5:17", "5:18", "5:20", "5:24", "5:33", "5:34", "5:36", "5:40", "5:48", "6:03", "6:05", "6:06", "6:09", "6:10", "6:12", "6:17", "6:18", "6:20", "6:24", "6:33", "6:34", "6:36", "6:40", "6:48", "7:01", "7:02", "7:04", "7:08", "7:16", "7:32", "8:07", "8:11", "8:13", "8:14", "8:19", "8:21", "8:22", "8:25", "8:26", "8:28", "8:35", "8:37", "8:38", "8:41", "8:42", "8:44", "8:49");
        expected.sort(String::compareTo);
        Assert.assertTrue(result.containsAll(expected));
    }

    @Test
    public void testReadBinaryWatch8() {
        List<String> result = new ReadBinaryWatch().readBinaryWatch(8);
        System.out.println(result);
        result.sort(String::compareTo);
        List<String> expected = Lists.newArrayList("7:31", "7:47", "7:55", "7:59", "11:31", "11:47", "11:55", "11:59");
        expected.sort(String::compareTo);
        Assert.assertEquals(result, expected);
    }
}