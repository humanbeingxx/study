package local.algorithm.nowcoder;

import local.algorithm.nowcoder.yuanfudao.SearchFirstInArray;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchFirstInArrayTest {

    @Test
    public void testSearch() {
        assertEquals(SearchFirstInArray.search(new int[]{1, 2, 3, 3, 4, 4, 4, 5, 6}, 4), 4);
        assertEquals(SearchFirstInArray.search(new int[]{1, 2, 4, 4, 4, 5, 6}, 3), -1);
    }
}