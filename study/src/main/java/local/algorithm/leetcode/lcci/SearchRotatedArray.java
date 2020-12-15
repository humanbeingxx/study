package local.algorithm.leetcode.lcci;

public class SearchRotatedArray {

    public int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int low = 0, high = arr.length - 1, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == arr[low]) {
                if (low == arr.length - 1 || arr[low] > arr[low + 1]) {
                    break;
                }
                low++;
            } else if (arr[mid] < arr[low]) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        int result;
        if (low == arr.length - 1 && arr[low] > arr[low - 1]) {
            result = search(arr, 0, arr.length - 1, target);
        } else if (target >= arr[0]) {
            result = search(arr, 0, low, target);
        } else {
            result = search(arr, low + 1, arr.length - 1, target);
        }
        return result;
    }

    int search(int[] arr, int start, int end, int target) {
        int low = start, high = end + 1, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid - 1;
                if (high > 0 && arr[high] < target) {
                    return arr[mid] == target ? mid : -1;
                }
            } else {
                low = mid + 1;
            }
        }
        if (arr[low] == target) {
            return low;
        } else {
            return -1;
        }
    }
}
