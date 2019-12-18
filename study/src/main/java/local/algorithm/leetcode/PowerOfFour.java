package local.algorithm.leetcode;

/**
 * @author humanbeingxx@sina.com
 * @date 2019/12/18 22:11
 */
public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        int pos0 = 0b0000000000000000000001;
        int pos1 = pos0 << 2;
        int pos2 = pos1 << 2;
        int pos3 = pos2 << 2;
        int pos4 = pos3 << 2;
        int pos5 = pos4 << 2;
        int pos6 = pos5 << 2;
        int pos7 = pos6 << 2;
        int pos8 = pos7 << 2;
        int pos9 = pos8 << 2;
        int pos10 = pos9 << 2;
        int pos11 = pos10 << 2;
        int pos12 = pos11 << 2;
        int pos13 = pos12 << 2;
        int pos14 = pos13 << 2;
        int pos15 = pos14 << 2;

        return num == pos0 || num == pos1 || num == pos2 || num == pos3 || num == pos4 || num == pos5 || num == pos6
                || num == pos7 || num == pos8 || num == pos9 || num == pos10 || num == pos11 || num == pos12 || num == pos13
                || num == pos14 || num == pos15;
    }
}
