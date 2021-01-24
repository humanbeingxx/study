package local.interview_internal_reference.byhunter;

public class TrappingRainWater {

    public int trap(int[] tanks) {
        int[] maxInRight = new int[tanks.length];
        int currentMax = tanks[tanks.length - 1];
        for (int i = tanks.length - 2; i >= 0; i--) {
            currentMax = Math.max(currentMax, tanks[i + 1]);
            maxInRight[i] = currentMax;
        }
        currentMax = tanks[0];
        int result = 0;
        for (int i = 1; i < tanks.length; i++) {
            currentMax = Math.max(currentMax, tanks[i - 1]);
            int minMax = Math.min(currentMax, maxInRight[i]);
            result += Math.max(minMax - tanks[i], 0);
        }
        return result;
    }
}
