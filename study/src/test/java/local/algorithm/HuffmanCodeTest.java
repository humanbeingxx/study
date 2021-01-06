package local.algorithm;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;
import org.testng.annotations.Test;

import java.util.List;

public class HuffmanCodeTest {

    @Test
    public void testEncode() {
        List<Pair<String, String>> result = new HuffmanCode().encode(Lists.newArrayList(
                Pair.of("1", 1),
                Pair.of("2", 2),
                Pair.of("3", 3),
                Pair.of("4", 4),
                Pair.of("5", 5)
        ));
        result.forEach(System.out::println);
    }
}