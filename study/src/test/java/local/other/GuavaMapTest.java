package local.other;

import com.google.common.collect.*;
import org.testng.annotations.Test;

import java.util.List;
import java.util.TreeMap;

/**
 * @author xiaoshuang.cui
 * @date 2018/7/24 上午10:56
 **/
public class GuavaMapTest {

    @Test
    public void test() {
        List<String> content = Lists.newArrayList(
                "a",
                "b",
                "c",
                "a",
                "a",
                "c",
                "c",
                "b",
                "c",
                "c"
        );

        HashMultiset<String> multiset = HashMultiset.create(content);
        BiMap<String, Integer> countMap = HashBiMap.create(Maps.toMap(multiset, multiset::count));
        final TreeMap<Integer, String> treeMap = Maps.newTreeMap((o1, o2) -> o2 - o1);
        treeMap.putAll(countMap.inverse());
        final List<String> result = Lists.newArrayList(treeMap.values()).subList(0, 2);
        System.out.println(result);
    }
}
