package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author cuixiaoshuang
 * @date 2020-01-06
 **/
public class SubdomainVisits {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counter = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            int count = Integer.parseInt(split[0]);
            String domain = split[1];
            counter.put(domain, counter.getOrDefault(domain, 0) + count);

            int indexOf = domain.indexOf('.');
            while (indexOf >= 0) {
                domain = domain.substring(indexOf + 1);
                counter.put(domain, counter.getOrDefault(domain, 0) + count);
                indexOf = domain.indexOf('.');
            }
        }
        return counter.entrySet().stream().map(e -> e.getValue() + " " + e.getKey()).collect(Collectors.toList());
    }
}
