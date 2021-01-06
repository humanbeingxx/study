package local.algorithm.leetcode;

import com.beust.jcommander.internal.Lists;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/29 15:23
 */
public class CommonCharsTest {

    @Test
    public void testCommonChars() {
        List<String> result = new CommonChars().commonChars(new String[]{"bella", "label", "roller"});
        assertEquals(result, Lists.newArrayList("e", "l", "l"));

        result = new CommonChars().commonChars(new String[]{"cool", "lock", "cook"});
        assertEquals(result, Lists.newArrayList("c", "o"));

    }
}