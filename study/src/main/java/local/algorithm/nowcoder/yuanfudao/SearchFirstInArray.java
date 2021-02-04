package local.algorithm.nowcoder.yuanfudao;

public class SearchFirstInArray {

    public static int search(int[] data, int target) {
        if (data == null || data.length == 0) {
            return -1;
        }
        int low = 0, high = data.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (data[mid] < target) {
                low = mid + 1;
            } else{
                high = mid;
            }
            if (low == high) {
                return data[low] == target ? low : -1;
            }
        }
        return -1;
    }
}
