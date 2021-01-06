package local.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cuixiaoshuang
 * @date 2019-12-24
 **/
public class NumberOfBoomerangs {

//    public int numberOfBoomerangs(int[][] points) {
//        Map<Integer, List<int[]>> distanceMap = new HashMap<>();
//        for (int i = 0; i < points.length - 1; i++) {
//            int[] point1 = points[i];
//            for (int j = i + 1; j < points.length; j++) {
//                int[] point2 = points[j];
//                int distance = (point1[0] - point2[0]) * (point1[0] - point2[0])
//                        + (point1[1] - point2[1]) * (point1[1] - point2[1]);
//                int[] pair1 = new int[]{i, j};
//                int[] pair2 = new int[]{j, i};
//                if (distanceMap.containsKey(distance)) {
//                    distanceMap.get(distance).add(pair1);
//                    distanceMap.get(distance).add(pair2);
//                } else {
//                    List<int[]> list = new ArrayList<>();
//                    list.add(pair1);
//                    list.add(pair2);
//                    distanceMap.put(distance, list);
//                }
//            }
//        }
//
//        int result = 0;
//        for (List<int[]> value : distanceMap.values()) {
//            Map<Integer, List<int[]>> groupByLeft = new HashMap<>();
//            for (int[] ints : value) {
//                int left = ints[0];
//                if (groupByLeft.containsKey(left)) {
//                    groupByLeft.get(left).add(ints);
//                } else {
//                    List<int[]> list = new ArrayList<>();
//                    list.add(ints);
//                    groupByLeft.put(left, list);
//                }
//            }
//
//            for (List<int[]> ints : groupByLeft.values()) {
//                result += ints.size() * (ints.size() - 1);
//            }
//        }
//
//        return result;
//    }

    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int[] point1 = points[i];
            Map<Integer, Integer> distanceMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int[] point2 = points[j];
                int distance = (point1[0] - point2[0]) * (point1[0] - point2[0])
                        + (point1[1] - point2[1]) * (point1[1] - point2[1]);
                if (!distanceMap.containsKey(distance)) {
                    distanceMap.put(distance, 1);
                } else {
                    Integer count = distanceMap.get(distance);
                    result += 2 * count;
                    distanceMap.put(distance, count + 1);
                }
            }
        }

        return result;
    }
}
