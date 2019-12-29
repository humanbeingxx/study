package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/28 20:46
 */
public class CheckStudentRecord {

    public boolean checkRecord(String s) {
        if (s.indexOf('A') != s.lastIndexOf('A')) {
            return false;
        }
        return !s.contains("LLL");
    }
}
