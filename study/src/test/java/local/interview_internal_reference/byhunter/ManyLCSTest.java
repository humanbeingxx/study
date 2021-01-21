package local.interview_internal_reference.byhunter;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ManyLCSTest {

    @Test
    public void testGet() {
        ManyLCS func = new ManyLCS();
        int[] data = new int[2 * 3 * 4 * 5];
        for (int i = 0; i < data.length; i++) {
            data[i] = i + 1;
        }
        int[] indices;
        int[] scales = {2, 3, 4, 5};
        indices = new int[]{1, 1, 3, 2};
        assertEquals(func.get(data, indices, scales), 70);

        indices = new int[]{0, 0, 0};
        assertEquals(func.get(data, indices, scales), 0);

        indices = new int[]{1, 2, 3, 5};
        assertEquals(func.get(data, indices, scales), 120);
    }

    @Test
    public void testLcs() {
        String result = new ManyLCS().lcs(Lists.newArrayList(
            "aabbcccbbb",
                "aabbc",
                "bbccbbb"
        ));
        System.out.println(result);
    }
}