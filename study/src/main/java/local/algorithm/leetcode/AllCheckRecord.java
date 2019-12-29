package local.algorithm.leetcode;

/**
 * 552. 学生出勤记录 II
 * @author humanbeingxx@sina.com
 * @date 2019/12/28 21:32
 */
public class AllCheckRecord {

    public int checkRecord(int n) {
        // 利用状态转移图
        long A0L0 = 1, A0L1 = 0, A0L2 = 0, A1L0 = 0, A1L1 = 0, A1L2 = 0;
        long M = 1000000007;
        for (int i = 0; i < n; i++) {
            long A0L0_new = (A0L0 + A0L1 + A0L2) % M;
            long A0L1_new = A0L0;
            long A0L2_new = A0L1;
            long A1L0_new = (A0L0 + A0L1 + A0L2 + A1L0 + A1L1 + A1L2) % M;
            long A1L1_new = A1L0;
            long A1L2_new = A1L1;
            A0L0 = A0L0_new;
            A0L1 = A0L1_new;
            A0L2 = A0L2_new;
            A1L0 = A1L0_new;
            A1L1 = A1L1_new;
            A1L2 = A1L2_new;
        }
        return (int) ((A0L0 + A0L1 + A0L2 + A1L0 + A1L1 + A1L2) % M);
    }
}
