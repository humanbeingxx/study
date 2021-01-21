package local.interview_internal_reference.byhunter;

import java.util.List;

public class ManyLCS {

    int max = 0;
    int maxIndex = -1;

    public String lcs(List<String> strings) {
        int[] scales = new int[strings.size()];
        int totalScale = 1;
        for (int i = 0; i < strings.size(); i++) {
            scales[i] = strings.get(i).length();
            totalScale *= strings.get(i).length();
        }
        int[] indices = new int[strings.size()];
        int[] dp = new int[totalScale];
        rec(dp, indices, scales, 0, strings);
        return strings.get(0).substring(maxIndex - max + 1, maxIndex + 1);
    }

    private void rec(int[] dp, int[] indices, int[] scales, int current, List<String> strings) {
        if (current == indices.length) {
            if (sameChar(indices, strings)) {
                decrIndex(indices);
                int data = get(dp, indices, scales);
                incrIndex(indices);
                set(dp, indices, scales, data + 1);
                if (max < data + 1) {
                    max = data + 1;
                    maxIndex = indices[0];
                }
            }
            return;
        }
        int scale = scales[current];
        for (int i = 0; i < scale; i++) {
            indices[current] = i;
            rec(dp, indices, scales, current + 1, strings);
        }
    }

    private void incrIndex(int[] indices) {
        for (int i = 0; i < indices.length; i++) {
            indices[i] += 1;
        }
    }

    private void decrIndex(int[] indices) {
        for (int i = 0; i < indices.length; i++) {
            indices[i] -= 1;
        }
    }

    private boolean sameChar(int[] indices, List<String> strings) {
        char c = strings.get(0).charAt(indices[0]);
        for (int i = 1; i < indices.length; i++) {
            if (strings.get(i).charAt(indices[i]) != c) {
                return false;
            }
        }
        return true;
    }

    int get(int[] data, int[] indices, int[] scales) {
        for (int i : indices) {
            if (i < 0) {
                return 0;
            }
        }
        int pos = calcPos(data.length - 1, indices, scales);
        return data[pos];
    }

    private void set(int[] data, int[] indices, int[] scales, int val) {
        int pos = calcPos(data.length - 1, indices, scales);
        data[pos] = val;
    }

    private int calcPos(int end, int[] indices, int[] scales) {
        int totalScale = 1;
        for (int scale : scales) {
            totalScale *= scale;
        }
        int pos = end;
        for (int i = indices.length - 1; i >= 0; i--) {
            totalScale /= scales[i];
            int index = indices[i];
            pos -= (scales[i] - index - 1) * totalScale;
        }
        return pos;
    }
}
