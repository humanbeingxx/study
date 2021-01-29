package local.algorithm.nowcoder;

public class SearchRotatedArray {

    public int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1, mid;
        while (low < high) {
            if (arr[low] == target) {
                return low;
            }
            mid = (low + high) / 2;
            if (arr[mid] == target) {
                high = mid;
            } else if (arr[mid] == arr[low]) {
                low++;
            } else if (arr[mid] > arr[low]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= arr[mid] && target <= arr[high]) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return arr[low] == target ? low : -1;
    }
}
