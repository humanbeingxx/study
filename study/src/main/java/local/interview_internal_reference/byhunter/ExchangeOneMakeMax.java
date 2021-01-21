package local.interview_internal_reference.byhunter;

import org.apache.commons.lang3.tuple.Pair;

import java.util.PriorityQueue;

public class ExchangeOneMakeMax {

    public void exchange(int[] nums) {
        boolean[] changed = new boolean[nums.length];
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getLeft().equals(o2.getLeft())) {
                return Integer.compare(o2.getRight(), o1.getRight());
            } else {
                return o2.getLeft().compareTo(o1.getLeft());
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(Pair.of(nums[i], i));
        }
        int exPos = 0;
        while (exPos < nums.length && !queue.isEmpty()) {
            if (changed[exPos] || nums[exPos] >= queue.peek().getLeft()) {
                exPos++;
                continue;
            }
            Pair<Integer, Integer> poll = queue.poll();
            if (poll.getRight() <= exPos) {
                continue;
            }
            exchange(nums, exPos, poll.getRight());
            changed[exPos] = true;
            exPos++;
        }
    }

    private void exchange(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public void exchangeForce(int[] nums) {
        boolean[] changed = new boolean[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            int max = Integer.MIN_VALUE, maxIndex = -1;
            for (int j = nums.length - 1; j > i; j--) {
                if (!changed[j] && nums[j] > max && nums[j] > nums[i]) {
                    max = nums[j];
                    maxIndex = j;
                }
            }
            if (maxIndex != -1) {
                exchange(nums, i, maxIndex);
                changed[i] = true;
                changed[maxIndex] = true;
            }
        }
    }
}
