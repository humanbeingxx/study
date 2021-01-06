package local.algorithm.leetcode;

import java.util.Arrays;

public class VideoStitching {

    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        });
        int right = clips[0][1], nextRight = right;
        if (clips[0][0] != 0) {
            return -1;
        }
        if (right >= T) {
            return 1;
        }
        int minClips = 1, index = 1;
        while (index < clips.length) {
            while (index < clips.length) {
                int[] clip = clips[index++];
                if (clip[0] <= right && clip[1] > nextRight) {
                    nextRight = clip[1];
                } else if (clip[0] > right) {
                    break;
                }
            }
            if (nextRight >= T) {
                return minClips + 1;
            }
            if (right >= nextRight) {
                return -1;
            }
            right = nextRight;
            minClips++;
        }
        return -1;
    }
}
