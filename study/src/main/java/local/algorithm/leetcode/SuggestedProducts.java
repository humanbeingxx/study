package local.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SuggestedProducts {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Map<String, List<String>> productMap = new HashMap<>();
        for (String product : products) {
            for (int i = 1; i <= product.length(); i++) {
                String prefix = product.substring(0, i);
                productMap.putIfAbsent(prefix, new ArrayList<>());
                productMap.get(prefix).add(product);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);
            List<String> strings = productMap.get(prefix);
            if (strings == null) {
                result.add(new ArrayList<>());
            } else {
                result.add(strings.stream().sorted().limit(3).collect(Collectors.toList()));
            }
        }
        return result;
    }
}
