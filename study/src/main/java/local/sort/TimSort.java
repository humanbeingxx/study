package local.sort;

import java.util.Stack;

/**
 * @author xiaoshuang.cui
 */
public class TimSort {

    public final static int MIN_MERGE = 2;

    private Stack<SubArray> stack;

    protected int[] originData;

    public TimSort(int[] originData) {
        stack = new Stack<>();
        this.originData = originData;
    }

    public class SubArray {
        private int start;
        private int end;

        public SubArray(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int length() {
            return end - start + 1;
        }

        public int[] getCopy() {
            int[] copy = new int[end - start + 1];
            for (int i = 0; i < end - start + 1; i++) {
                copy[i] = originData[i + start];
            }
            return copy;
        }
    }

    protected void splitRun() {
        int start = 0;
        while (start < originData.length) {
            int ascEnd = findAscEnd(start);
            stack.push(new SubArray(start, ascEnd));
            start = ascEnd + 1;
            mergeStack(needMerge());
        }
    }

    private int needMerge() {

        //TODO
        return 0;
    }

    protected void mergeStack(int flag) {
        if (flag < 0) {
            return;
        }
        if ((flag == 0 && stack.size() == 2) || (flag > 0 && stack.size() > 2)) {
            mergeTop12();
        } else {
            mergeTop23();
        }
    }

    private void mergeTop23() {
        SubArray top1 = stack.pop();
        SubArray top2 = stack.pop();
        SubArray top3 = stack.pop();
        SubArray newTop2 = merge(top2, top3);
        stack.push(newTop2);
        stack.push(top1);
    }

    private void mergeTop12() {
        SubArray pop1 = stack.pop();
        SubArray pop2 = stack.pop();
        merge(pop1, pop2);
    }


    protected SubArray merge(SubArray array1, SubArray array2) {
        int[] temp = new int[array1.length() + array2.length()];
        int start = Math.min(array1.start, array2.start);
        int end = Math.max(array1.end, array2.end);
        int index1 = array1.start;
        int index2 = array2.start;
        int indexTemp = 0;

        while (index1 <= array1.end && index2 <= array2.end) {
            if (originData[index1] <= originData[index2]) {
                temp[indexTemp++] = originData[index1++];
            } else {
                temp[indexTemp++] = originData[index2++];
            }
        }

        while (index1 <= array1.end) {
            temp[indexTemp++] = originData[index1++];
        }

        while (index2 <= array2.end) {
            temp[indexTemp++] = originData[index2++];
        }

        for (int i = 0; i < end - start + 1; i++) {
            originData[start + i] = temp[i];
        }
        return new SubArray(start, end);
    }

    private int findAscEnd(int start) {
        int end = start + 1;
        if (end >= originData.length - 1) {
            return start;
        }
        while (end < originData.length) {
            if (originData[start] <= originData[end]) {
                end++;
            } else {
                break;
            }
        }
        end--;
        if (end - start + 1 < MIN_MERGE) {
            if (start + MIN_MERGE >= originData.length) {
                end = originData.length - 1;
            } else {
                end = start + MIN_MERGE - 1;
            }
            SortUtil.bubbleSort(originData, start, end);
        }
        return end;
    }

    protected void turnover(int from, int to) {
        while (from < to) {
            SortUtil.exchange(originData, from++, to--);
        }
    }

    protected int[] getOriginData() {
        return originData;
    }

    protected Stack<SubArray> getStack() {
        return stack;
    }
}
