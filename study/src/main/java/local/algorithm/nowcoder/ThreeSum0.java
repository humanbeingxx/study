package local.algorithm.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum0 {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (num == null || num.length < 3) {
            return result;
        }
        Arrays.sort(num);
        for (int firstIndex = 0; firstIndex < num.length - 2 && num[firstIndex] <= 0; firstIndex++) {
            int first = num[firstIndex];
            if (firstIndex > 0 && first == num[firstIndex - 1]) {
                continue;
            }
            int secondIndex = firstIndex + 1, thirdIndex = num.length - 1;
            while (secondIndex < thirdIndex) {
                int second = num[secondIndex];
                int third = num[thirdIndex];
                int sum = first + second + third;
                if (sum == 0) {
                    result.add(tuple(first, second, third));
                    while (secondIndex < thirdIndex && num[secondIndex] == num[secondIndex + 1]) {
                        secondIndex++;
                    }
                    while (secondIndex < thirdIndex && num[thirdIndex] == num[thirdIndex - 1]) {
                        thirdIndex--;
                    }
                    secondIndex++;
                    thirdIndex--;
                } else if (sum > 0) {
                    thirdIndex--;
                } else {
                    secondIndex++;
                }
            }
        }
        return result;
    }

    private ArrayList<Integer> tuple(int a, int b, int c) {
        ArrayList<Integer> tuple = new ArrayList<>();
        tuple.add(a);
        tuple.add(b);
        tuple.add(c);
        return tuple;
    }
}
