package local.address;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author cuixiaoshuang
 * @date 2019-11-05
 **/
public class SuffixSortTest {

    @Test
    public void testSort() {
        List<String> suffix = SuffixSort.sort("四是四十是十十四是十四四十是四十");
        suffix.forEach(System.out::println);
    }
}