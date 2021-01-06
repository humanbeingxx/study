package local.algorithm.leetcode;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @author cuixiaoshuang
 * @date 2020-01-10
 **/
public class RestoreIpAddressesTest {

    @Test
    public void testRestoreIpAddresses1() {
        List<String> result = new RestoreIpAddresses().restoreIpAddresses("25525511135");
        System.out.println(result);
    }

    @Test
    public void testRestoreIpAddresses2() {
        List<String> result = new RestoreIpAddresses().restoreIpAddresses("1111");
        System.out.println(result);
    }

    @Test
    public void testRestoreIpAddresses3() {
        List<String> result = new RestoreIpAddresses().restoreIpAddresses("255255255255");
        System.out.println(result);
    }

    @Test
    public void testRestoreIpAddresses4() {
        List<String> result = new RestoreIpAddresses().restoreIpAddresses("010010");
        System.out.println(result);
    }
}