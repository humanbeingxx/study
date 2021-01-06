package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-01-06
 **/
public class SubdomainVisitsTest {

    @Test
    public void testSubdomainVisits() {
        List<String> result = new SubdomainVisits().subdomainVisits(new String[]{
                "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
        System.out.println(result);
    }
}