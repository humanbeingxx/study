package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2020/1/1 14:36
 */
public class DefangIPaddr {

    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
