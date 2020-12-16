package local.algorithm;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int H) {
        int minSpeed = 0, maxSpeed = 0, total = 0;
        for (int pile : piles) {
            total += pile;
            maxSpeed = Math.max(maxSpeed, pile);
        }
        minSpeed = Math.min(1, total % H == 0 ? total / H : total / H + 1);
        int low = minSpeed, high = maxSpeed, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (eatAll(piles, H, mid)) {
                if (low == high) {
                    break;
                }
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    private boolean eatAll(int[] piles, int h, int speed) {
        int need = 0;
        for (int pile : piles) {
            need += pile % speed == 0 ? pile / speed : pile / speed + 1;
        }
        return need <= h;
    }
}
