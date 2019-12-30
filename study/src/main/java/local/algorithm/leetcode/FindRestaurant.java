package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cuixiaoshuang
 * @date 2019-12-30
 **/
public class FindRestaurant {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> index1 = new HashMap<>();
        Map<String, Integer> index2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            index1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            index2.put(list2[i], i);
        }
        for (Map.Entry<String, Integer> entry : index1.entrySet()) {
            if (index2.containsKey(entry.getKey())) {
                entry.setValue(entry.getValue() + index2.get(entry.getKey()));
            } else {
                entry.setValue(10000);
            }
        }
        int min = 10000, count = 0;
        for (Integer value : index1.values()) {
            if (value == min) {
                count++;
            } else if (value < min) {
                min = value;
                count = 1;
            }
        }
        String[] result = new String[count];
        int index = 0;
        for (Map.Entry<String, Integer> entry : index1.entrySet()) {
            if (entry.getValue() == min) {
                result[index++] = entry.getKey();
            }
        }
        return result;
    }
}
