package local.jcore;

import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;

/**
 * @author cuixiaoshuang
 * @date 2019-08-09
 **/
public class ReturnFinallyTest {

    @Test
    public void test() {
        Map<String, String> map1 = changeMap();
        System.out.println(map1);

        Map<String, String> map2 = changeMapValue();
        System.out.println(map2);
    }

    private Map<String, String> changeMap() {
        Map<String, String> map = Maps.newHashMap();
        try {
            map.put("key1", "value1");
            return map;
        } finally {
            map = Maps.newHashMap();
        }
    }

    private Map<String, String> changeMapValue() {
        Map<String, String> map = Maps.newHashMap();
        try {
            map.put("key1", "value1");
            return map;
        } finally {
            map.put("key2", "value2");
        }
    }

    @Test
    public void testMultiFinally() {
        int i = 0;
//        if (i == 0) {
//            return;
//        }
        try {
            if (i == 0) {
                System.exit(0);
            }
        } finally {
            System.out.println("f1");
        }

        try {
            if (i == 0) {
                System.exit(0);
            }
        } finally {
            System.out.println("f2");
        }
    }
}
