package local.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/5 20:54
 */
public class NumUniqueEmails {

    public int numUniqueEmails(String[] emails) {
        Set<String> result = new HashSet<>();
        for (String email : emails) {
            int at = email.indexOf('@');
            String domain = email.substring(at);
            String local = email.substring(0, at - 1);
            int plus = local.indexOf('+');
            if (plus > 0) {
                local = local.substring(0, plus - 1);
            } else if (plus == 0) {
                continue;
            }
            local = local.replaceAll("\\.", "");
            result.add(local + domain);
        }
        System.out.println(result);
        return result.size();
    }
}
